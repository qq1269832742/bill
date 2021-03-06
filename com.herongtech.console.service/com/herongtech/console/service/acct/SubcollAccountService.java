package com.herongtech.console.service.acct;

import java.util.Iterator;
import java.util.List;

import com.herongtech.console.core.constant.IConstants;
import com.herongtech.console.core.util.DateTimeUtil;
import com.herongtech.console.core.util.MathScaleUtil;
import com.herongtech.console.core.util.MoneyUtils;
import com.herongtech.console.domain.acct.bean.AccountRequestDTO;
import com.herongtech.console.domain.acct.bean.AccountResponseDTO;
import com.herongtech.console.domain.acct.bean.AcctBalance;
import com.herongtech.console.domain.acct.bean.AcctFlow;
import com.herongtech.console.domain.acct.bean.AcctFlowInfo;
import com.herongtech.console.domain.acct.dao.AcctBalanceDao;
import com.herongtech.console.domain.acct.dao.AcctFlowDao;
import com.herongtech.console.domain.acct.dao.AcctFlowInfoDao;
import com.herongtech.console.domain.bean.UserLoginfo;
import com.herongtech.console.domain.subcoll.bean.SubcollBillInfo;
import com.herongtech.console.service.ServiceFactory;
import com.herongtech.console.service.callremote.bean.AcctRequest;
import com.herongtech.console.service.callremote.interfaces.ICoreRemoteService;
import com.herongtech.console.service.interfaces.IAccountFacadeService;
import com.herongtech.console.service.interfaces.ISequenceService;
import com.herongtech.console.web.busicontroller.common.SubcollCodeConst;

public class SubcollAccountService implements IAccountFacadeService{

	 private ICoreRemoteService coreRemoteService;
	@Override
	public AccountResponseDTO account(AccountRequestDTO accountReq)
			throws Exception {
		
		//SubcollApplyInfo apply=(SubcollApplyInfo) accountReq.getApply();
        List<SubcollBillInfo> billList=accountReq.getBillList();
        UserLoginfo logonInfo=accountReq.getUserLogonInfo();
        ISequenceService sequenceService=ServiceFactory.getSequenceService();
        AcctFlowDao afDao=new AcctFlowDao();
        AcctFlowInfoDao afiDao=new AcctFlowInfoDao();
        AcctBalanceDao abDao=new AcctBalanceDao();
        AcctFlow af=new AcctFlow();//流水信息
        
        double totPayMoney=0.0;
        double totInterest=0.0;
        for(Iterator<SubcollBillInfo> iter=billList.iterator();iter.hasNext();){
            SubcollBillInfo bill=iter.next();
            
            af.setAfId(sequenceService.getPrimaryKeyValue());
            af.setAcctBranchNo(logonInfo.getBranchNo());
//            af.setAcctStatus(acctStatus)
            af.setAcctType(IConstants.ACCT_TYPE.ACCOUNT);
            af.setForeFlowNo(sequenceService.getAcctFlowNo(logonInfo.getBranchNo()));
            af.setProdNo(SubcollCodeConst.PRODUCT_ACPT_TS_QKSH);
          
            af.setTotalAmount(MoneyUtils.formate(Double.valueOf(bill.getBillMoney())));
            af.setTransBranchName(logonInfo.getBranchName());
            af.setTransBranchNo(logonInfo.getBranchNo());
            af.setTransDt(DateTimeUtil.getWorkdayString());
//            af.setTransName(transName);//TODO:记账可能需要根据产品类型 来判断对应的交易编码
            af.setTransNo(SubcollCodeConst.PRODUCT_ACPT_TS_QKSH);
            af.setTransTm(DateTimeUtil.get_hhmmss_time());
            af.setTransUserNo(logonInfo.getUserNo());
            af.setSettlementInterest(totInterest);
            af.setSettlementMoney(totPayMoney);
            afDao.addAcctFlow(af);
            
            AcctFlowInfo afi=new AcctFlowInfo();//流水信息明细
            afi.setAcctBranchNo(af.getAcctBranchNo());
            afi.setAcctInfoId(sequenceService.getPrimaryKeyValue());
            afi.setAfId(af.getAfId());
            afi.setBillAmonut(bill.getBillMoney());
            afi.setBillNo(bill.getBillNo());
//            afi.setCurRemaIntrst();//买入时无需塞值
//            afi.setDiscrepancyInterest()
            afi.setInfoId(bill.getSubcollmxId());
            afi.setProdNo(af.getProdNo());
            afi.setRgctId(bill.getRgctId());
            afi.setSettlementAmt(bill.getPayMoney());
            afi.setSettlementIntrst(bill.getInterest());
            afi.setTransBranchNo(af.getTransBranchNo());
            afi.setTransDt(af.getTransDt());
            afi.setTransNo(af.getTransNo());
            afi.setTransTm(af.getTransTm());
            totPayMoney=MathScaleUtil.add(totPayMoney, afi.getSettlementAmt());
            totInterest=MathScaleUtil.add(totInterest, afi.getSettlementIntrst());
            afiDao.addAcctFlowInfo(afi);
            
            AcctBalance balance=abDao.getAcctBalanceByRgctId(bill.getRgctId());//余额信息
            balance.setEndDt(af.getTransDt());
            balance.setUpdateDt(af.getTransDt());
            balance.setUpdateTm(af.getTransTm());
            balance.setStatus(IConstants.BALANCE_STATUS.NON_BALANCE);
            abDao.modifyAcctBalance(balance);
            
            bill.setExSerial(af.getForeFlowNo());
            
        }
        
        //调用接口转换程序
        AcctRequest request=new AcctRequest();  
        request.setTransNo(af.getTransNo());
        request.setAf(af);
        //request.setApply(apply);
        request.setList(billList);
        request.addProperty("af", af);
        //request.addProperty("apply", apply);
        request.addProperty("list", billList);
        AccountResponseDTO respDto=coreRemoteService.account(request);
        
        return respDto;
	}

	@Override
	public AccountResponseDTO reverseAccount(AccountRequestDTO accountReq)
			throws Exception {
        
        //SaleApplyInfo apply=(SaleApplyInfo) accountReq.getApply();
        List<SubcollBillInfo> billList=accountReq.getBillList();
        UserLoginfo logonInfo=accountReq.getUserLogonInfo();
        ISequenceService sequenceService=ServiceFactory.getSequenceService();
        AcctFlowDao afDao=new AcctFlowDao();
        AcctFlowInfoDao afiDao=new AcctFlowInfoDao();
        AcctBalanceDao abDao=new AcctBalanceDao();
        
        AcctFlow af=new AcctFlow();
        
        
        double totPayMoney=0.0;
        double totInterest=0.0;
        
        for(Iterator<SubcollBillInfo> iter=billList.iterator();iter.hasNext();){
            SubcollBillInfo bill=iter.next();
            
            af.setAfId(sequenceService.getPrimaryKeyValue());
            af.setAcctBranchNo(logonInfo.getBranchNo());
//            af.setAcctStatus(acctStatus)
            af.setAcctType(IConstants.ACCT_TYPE.REVERSE_ACCOUNT);
            af.setForeFlowNo(sequenceService.getAcctFlowNo(logonInfo.getBranchNo()));
            af.setProdNo(SubcollCodeConst.PRODUCT_ACPT_TS_QKSH);
          
            af.setTotalAmount(MoneyUtils.formate(Double.valueOf(bill.getBillMoney())));
            af.setTransBranchName(logonInfo.getBranchName());
            af.setTransBranchNo(logonInfo.getBranchNo());
            af.setTransDt(DateTimeUtil.getWorkdayString());
//            af.setTransName(transName);//TODO:记账可能需要根据产品类型 来判断对应的交易编码
            af.setTransNo(SubcollCodeConst.PRODUCT_ACPT_TS_QKSH);
            af.setTransTm(DateTimeUtil.get_hhmmss_time());
            af.setTransUserNo(logonInfo.getUserNo());
            
            AcctFlowInfo afi=new AcctFlowInfo();
            afi.setAcctBranchNo(af.getAcctBranchNo());
            afi.setAcctInfoId(sequenceService.getPrimaryKeyValue());
            afi.setAfId(af.getAfId());
            afi.setBillAmonut(bill.getBillMoney());
            afi.setBillNo(bill.getBillNo());
//            afi.setCurRemaIntrst();//买入时无需塞值
//            afi.setDiscrepancyInterest()
            afi.setInfoId(bill.getSubcollmxId());
            afi.setProdNo(af.getProdNo());
            afi.setRgctId(bill.getRgctId());
            afi.setSettlementAmt(bill.getPayMoney());
            afi.setSettlementIntrst(bill.getInterest());
            afi.setTransBranchNo(af.getTransBranchNo());
            afi.setTransDt(af.getTransDt());
            afi.setTransNo(af.getTransNo());
            afi.setTransTm(af.getTransTm());
            totPayMoney=MathScaleUtil.add(totPayMoney, afi.getSettlementAmt());
            totInterest=MathScaleUtil.add(totInterest, afi.getSettlementIntrst());
            afiDao.addAcctFlowInfo(afi);
            
            AcctBalance balance=abDao.getAcctBalanceByRgctIdAndStatus(bill.getRgctId(),IConstants.BALANCE_STATUS.NON_BALANCE);
            balance.setEndDt(af.getTransDt());
            balance.setUpdateDt(af.getTransDt());
            balance.setUpdateTm(af.getTransTm());
            balance.setStatus(IConstants.BALANCE_STATUS.BALANCE);
            abDao.modifyAcctBalance(balance);


            
            bill.setExSerial(af.getForeFlowNo());
            
        }
        af.setSettlementInterest(totInterest);
        af.setSettlementMoney(totPayMoney);
        afDao.addAcctFlow(af);
        
        //调用接口转换程序
        AcctRequest request=new AcctRequest();  
        request.setTransNo(af.getTransNo());
        request.setAf(af);
        //request.setApply(apply);
        request.setList(billList);
        request.addProperty("af", af);
        //request.addProperty("apply", apply);
        request.addProperty("list", billList);
        AccountResponseDTO respDto=coreRemoteService.reverseAccount(af);
        
        return respDto;
    }
	 public void setCoreRemoteService(ICoreRemoteService coreRemoteService) {
	        this.coreRemoteService = coreRemoteService;
	    }
}
