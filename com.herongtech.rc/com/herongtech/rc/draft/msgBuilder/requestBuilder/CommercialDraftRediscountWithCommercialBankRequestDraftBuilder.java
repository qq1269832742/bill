package com.herongtech.rc.draft.msgBuilder.requestBuilder;

import java.math.BigDecimal;

import org.apache.commons.lang.StringUtils;
import org.apache.xmlbeans.XmlOptions;
import org.ecds013.Account1;
import org.ecds013.BanEndorsementMarkCode;
import org.ecds013.CommercialDraft1;
import org.ecds013.CommercialDraftRediscountWithCommercialBankRequestV01;
import org.ecds013.CurrencyAndAmount;
import org.ecds013.Document;
import org.ecds013.DocumentDocument;
import org.ecds013.MessageIdentification1;
import org.ecds013.Organisation1;
import org.ecds013.Organisation2;
import org.ecds013.Organisation3;
import org.ecds013.RediscountWithCommercialBank1;
import org.ecds013.RepurchasedMarkCode;
import org.ecds013.RoleCode;
import org.ecds013.SettlementMarkCode;

import com.herongtech.commons.tools.StringUtil;
import com.herongtech.console.core.constant.DraftConstants;
import com.herongtech.console.core.util.MoneyUtils;
import com.herongtech.exception.impl.BizAppException;
import com.herongtech.rc.domain.bean.RgctBillInfo;
import com.herongtech.rc.draft.common.MsgUtil;
import com.herongtech.rc.draft.common.vo.DraftInfoVo;
import com.herongtech.rc.draft.common.vo.DraftSender;
import com.herongtech.rc.draft.msgBuilder.AbstractDraftBuilder;

/**
 * 013转贴现
 * 
 */
public class CommercialDraftRediscountWithCommercialBankRequestDraftBuilder
		extends AbstractDraftBuilder {

	@Override
	public String buildBody(DraftSender draftSender) throws BizAppException {
		XmlOptions options = createXmlOptions(draftSender.getMesgType());

		DraftInfoVo vo = (DraftInfoVo) draftSender.getReqInfo();
		RgctBillInfo bill = vo.getBill();
		DocumentDocument document = DocumentDocument.Factory
				.newInstance(options);
		Document doc = document.addNewDocument();

		CommercialDraftRediscountWithCommercialBankRequestV01 commerDraft = doc
				.addNewCommercialDraftRediscountWithCommercialBankRequest();
		/* 报文信息 */
		MessageIdentification1 msgid = commerDraft.addNewMsgId();
		msgid.setId(vo.getReqMsgId()); // 报文标识
		msgid.setCreDtTm(MsgUtil.getCurrentTime()); // 报文时间

		/* 转贴现信息 */
		RediscountWithCommercialBank1 rediscount = commerDraft
				.addNewRdscntWthComrclBk();
		rediscount.setRpdMk(RepurchasedMarkCode.Enum.forString(vo.getRpdMk()));
		rediscount.setDt(MsgUtil.getConverTime(vo.getApplyDt()));
		rediscount.setIntrstRate(new BigDecimal(vo.getIntrstRate().toString()));
//		rediscount.setRpdIntrstRate(new BigDecimal(vo.getRpdIntrstRate().toString()));
		CurrencyAndAmount amt = rediscount.addNewAmt();
		amt.setCcy(DraftConstants.CURRENCY_TYPE);
		amt.setStringValue(MoneyUtils.double2String(vo.getAmt()));
		rediscount.setBanEndrsmtMk(BanEndorsementMarkCode.Enum.forString(vo
				.getBanEndrsmtMk()));
		rediscount.setSttlmMk(SettlementMarkCode.Enum.forString(vo
				.getSettleMk()));
		if (DraftConstants.REPURCHASED_MARK_CODE_RM01.equals(vo.getRpdMk())) {
			// 回购类
			rediscount.setRpdIntrstRate(new BigDecimal(vo.getRpdIntrstRate().toString()));
			rediscount.setRpdDueDt(MsgUtil.getConverTime(vo.getRpdDueDt()));
			rediscount.setRpdOpenDt(MsgUtil.getConverTime(vo.getRpdOpenDt()));
			CurrencyAndAmount rpdAmt = rediscount.addNewRpdAmt();
			rpdAmt.setCcy(DraftConstants.CURRENCY_TYPE);
			rpdAmt.setStringValue(MoneyUtils.double2String(vo.getRpdAmt()));
		}
		if (StringUtils.isNotBlank(vo.getBtchNb())) {
//			rediscount.setBtchNb(vo.getBtchNb());
		}
		if (StringUtils.isNotBlank(vo.getFromRemark())) {
			rediscount.setRmrkByPropsr(vo.getFromRemark());
		}

		/* 票面信息 */
		CommercialDraft1 info = commerDraft.addNewComrclDrft();
		info.setIdNb(bill.getBillNo());
		CurrencyAndAmount AMT = info.addNewIsseAmt();
		AMT.setCcy(DraftConstants.CURRENCY_TYPE);
		AMT.setStringValue(MoneyUtils.double2String(bill.getBillMoney()));
		/* 贴出人信息 */
		Organisation1 from = commerDraft.addNewRqstngBkOfRdscntWthComrclBk();
		Account1 acct = from.addNewAcct();
		acct.setId(vo.getFromAcctNo());
		acct.setAcctSvcr(vo.getFromBankNo());
		from.setCmonId(vo.getFromOrgCode());
		from.setElctrncSgntr(vo.getFromElctrncSgntr());
		from.setNm(vo.getFromName());
		from.setRole(RoleCode.Enum.forString(vo.getFromRoleType()));
		if (StringUtils.isNotBlank(vo.getFromAgcyBankNo())) {
			Organisation3 agcy = from.addNewAgcy();
			agcy.addNewAcct().setAcctSvcr(vo.getFromAgcyBankNo());
		}

		/* 帖入行信息 */
		Organisation2 receive = commerDraft.addNewRcvgBkOfRdscntWthComrclBk();
		Account1 recAcct = receive.addNewAcct();
		recAcct.setId(vo.getReceiveAcctNo());
		recAcct.setAcctSvcr(vo.getReceiveBankNo());
		receive.setNm(vo.getReceiveName());

		String draft = document.xmlText(options);
		String signPart = commerDraft.xmlText();
		return addSign(draft, signPart, draftSender.getIsAddSign());
	}

}
