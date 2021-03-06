package com.herongtech.console.domain.acpt.bean;

public class AcptRegAndBillInfo {
	private String acptmxId = " ";	//承兑明细流水号
	private String acptId = " ";	//承兑流水号
	private String rgctId = " ";	//登记中心id
	private Long esno = 0l;	//批次内序号
	private String branchNo = " ";	//签发机构
	private String protocalNo = " ";	//银承协议编号
	private String facNo = " ";	//授信额度编号
	private String remitter = " ";	//出票人客户名称
	private String remitterCustNo = " ";	//出票人客户号
	private String remitterAcct = " ";	//出票人客户账号
	private String remitterBranchNo = " ";	//出票人开户机构
	private String remitterBankNo = " ";	//出票人开户行行号
	private String remitterBankName = " ";	//出票人开户行名称
	private String billClass = " ";	//票据分类
	private String billType = " ";	//票据种类
	private String voucherType = " ";	//凭证种类
	private String billNo = " ";	//票号
	private double billMoney = 0.0;	//票面金额
	private String currencyCategory = " ";	//币种
	private String billStatus = " ";	//票据状态
	private String draweeBankNo = " ";	//付款行行号
	private String draweeBankName = " ";	//付款行行名
	private String draweeAddr = " ";	//付款行地址
	private String payee = " ";	//收款人名称
	private String payeeAcct = " ";	//收款人账号
	private String payeeBankNo = " ";	//收款人开户行行号
	private String payeeBankName = " ";	//收款人开户行名称
	private String dueDt = " ";	//到期日
	private String issueDt = " ";	//出票日
	private String acptDt = " ";	//承兑日期
	private String acceptor = " ";	//承兑人名称
	private String acceptorAcct = " ";	//承兑人账号
	private String acceptorBankNo = " ";	//承兑人行号
	private String acceptorBankName = " ";	//承兑人开户行名称
	private String colltnStatus = " ";	//委托收款状态
	private String colltnId = " ";	//委托收款登记簿主键
	private String sspdStatus = " ";	//挂失状态
	private String sspdId = " ";	//挂失id
	private String printStatus = " ";	//打印状态
	private String prsnttnAcctNo = " ";	//提示付款人账号
	private String prsnttnName = " ";	//提示付款人名称
	private String prsnttnBankNo = " ";	//提示付款人开户行行号
	private String prsnttnBankName = " ";	//提示付款人开户行名称
	private String paymentPath = " ";	//资金通道
	private String paymentDt = " ";	//付款日
	private String custRemark = " ";	//客户附言
	private String bankRemark = " ";	//银行附言
	private String payWaitOrder = " ";	//应付挂账订单号
	private String txlCtrctNb = " ";	//交易合同编号
	private String invcNb = " ";	//发票号码
	private String realAcctDt = " ";	//实际记账日期
	private String realAcctTime = " ";	//实际记账时间
	private String drwgBckOperNo = " ";	//未用退回柜员
	private String drwgBckDt = " ";	//未用退回日期
	private String drwgBckTime = " ";	//未用退回时间
	private String drwgBckFlowNo = " ";	//未用退回操作流水号
	private String status = " ";	//状态
	private String applyCancelFlag = " ";	//申请撤销标记
	private String requestMsgId = " ";	//申请报文编号
	private String yzSource = " ";	//移植来源
	private String conferNo = " ";	//交易合同编号
	private String id = " ";	//主键
	private String regFlowNo = " ";	//委托登记流水号
	private String busiType = " ";	//业务类型
	private String draweeAcct = " ";	//付款人帐号
	private String draweeName = " ";	//付款人户名
	private String draweeBankNameName = " ";	//付款行行名
	private String payeeName = " ";	//收款人名称
	private double colltnAmt = 0.0;	//colltn_amt//委收金额
	private double payAmt = 0.0;	//pay_amt//付款金额
	private double compensAmt = 0.0;	//compens_amt//赔偿金额
	private String bankType = " ";	//行别
	private String city = " ";	//城市
	private String regDt = " ";	//reg_dt//登记日期
	private String isDelay = " ";	//is_delay//是否延期
	private String delayReason = " ";	//delay_reason//延期原因
	private String accountDt = " ";	//account_dt//销记日期
	private String rejectDt = " ";	//reject_dt//退票日期
	private String rejectCode = " ";	//reject_code//退票编码
	public String getAcptmxId() {
		return acptmxId;
	}
	public void setAcptmxId(String acptmxId) {
		this.acptmxId = acptmxId;
	}
	public String getAcptId() {
		return acptId;
	}
	public void setAcptId(String acptId) {
		this.acptId = acptId;
	}
	public String getRgctId() {
		return rgctId;
	}
	public void setRgctId(String rgctId) {
		this.rgctId = rgctId;
	}
	public Long getEsno() {
		return esno;
	}
	public void setEsno(Long esno) {
		this.esno = esno;
	}
	public String getBranchNo() {
		return branchNo;
	}
	public void setBranchNo(String branchNo) {
		this.branchNo = branchNo;
	}
	public String getProtocalNo() {
		return protocalNo;
	}
	public void setProtocalNo(String protocalNo) {
		this.protocalNo = protocalNo;
	}
	public String getFacNo() {
		return facNo;
	}
	public void setFacNo(String facNo) {
		this.facNo = facNo;
	}
	public String getRemitter() {
		return remitter;
	}
	public void setRemitter(String remitter) {
		this.remitter = remitter;
	}
	public String getRemitterCustNo() {
		return remitterCustNo;
	}
	public void setRemitterCustNo(String remitterCustNo) {
		this.remitterCustNo = remitterCustNo;
	}
	public String getRemitterAcct() {
		return remitterAcct;
	}
	public void setRemitterAcct(String remitterAcct) {
		this.remitterAcct = remitterAcct;
	}
	public String getRemitterBranchNo() {
		return remitterBranchNo;
	}
	public void setRemitterBranchNo(String remitterBranchNo) {
		this.remitterBranchNo = remitterBranchNo;
	}
	public String getRemitterBankNo() {
		return remitterBankNo;
	}
	public void setRemitterBankNo(String remitterBankNo) {
		this.remitterBankNo = remitterBankNo;
	}
	public String getRemitterBankName() {
		return remitterBankName;
	}
	public void setRemitterBankName(String remitterBankName) {
		this.remitterBankName = remitterBankName;
	}
	public String getBillClass() {
		return billClass;
	}
	public void setBillClass(String billClass) {
		this.billClass = billClass;
	}
	public String getBillType() {
		return billType;
	}
	public void setBillType(String billType) {
		this.billType = billType;
	}
	public String getVoucherType() {
		return voucherType;
	}
	public void setVoucherType(String voucherType) {
		this.voucherType = voucherType;
	}
	public String getBillNo() {
		return billNo;
	}
	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}
	public double getBillMoney() {
		return billMoney;
	}
	public void setBillMoney(double billMoney) {
		this.billMoney = billMoney;
	}
	public String getCurrencyCategory() {
		return currencyCategory;
	}
	public void setCurrencyCategory(String currencyCategory) {
		this.currencyCategory = currencyCategory;
	}
	public String getBillStatus() {
		return billStatus;
	}
	public void setBillStatus(String billStatus) {
		this.billStatus = billStatus;
	}
	public String getDraweeBankNo() {
		return draweeBankNo;
	}
	public void setDraweeBankNo(String draweeBankNo) {
		this.draweeBankNo = draweeBankNo;
	}
	public String getDraweeBankName() {
		return draweeBankName;
	}
	public void setDraweeBankName(String draweeBankName) {
		this.draweeBankName = draweeBankName;
	}
	public String getDraweeAddr() {
		return draweeAddr;
	}
	public void setDraweeAddr(String draweeAddr) {
		this.draweeAddr = draweeAddr;
	}
	public String getPayee() {
		return payee;
	}
	public void setPayee(String payee) {
		this.payee = payee;
	}
	public String getPayeeAcct() {
		return payeeAcct;
	}
	public void setPayeeAcct(String payeeAcct) {
		this.payeeAcct = payeeAcct;
	}
	public String getPayeeBankNo() {
		return payeeBankNo;
	}
	public void setPayeeBankNo(String payeeBankNo) {
		this.payeeBankNo = payeeBankNo;
	}
	public String getPayeeBankName() {
		return payeeBankName;
	}
	public void setPayeeBankName(String payeeBankName) {
		this.payeeBankName = payeeBankName;
	}
	public String getDueDt() {
		return dueDt;
	}
	public void setDueDt(String dueDt) {
		this.dueDt = dueDt;
	}
	public String getIssueDt() {
		return issueDt;
	}
	public void setIssueDt(String issueDt) {
		this.issueDt = issueDt;
	}
	public String getAcptDt() {
		return acptDt;
	}
	public void setAcptDt(String acptDt) {
		this.acptDt = acptDt;
	}
	public String getAcceptor() {
		return acceptor;
	}
	public void setAcceptor(String acceptor) {
		this.acceptor = acceptor;
	}
	public String getAcceptorAcct() {
		return acceptorAcct;
	}
	public void setAcceptorAcct(String acceptorAcct) {
		this.acceptorAcct = acceptorAcct;
	}
	public String getAcceptorBankNo() {
		return acceptorBankNo;
	}
	public void setAcceptorBankNo(String acceptorBankNo) {
		this.acceptorBankNo = acceptorBankNo;
	}
	public String getAcceptorBankName() {
		return acceptorBankName;
	}
	public void setAcceptorBankName(String acceptorBankName) {
		this.acceptorBankName = acceptorBankName;
	}
	public String getColltnStatus() {
		return colltnStatus;
	}
	public void setColltnStatus(String colltnStatus) {
		this.colltnStatus = colltnStatus;
	}
	public String getColltnId() {
		return colltnId;
	}
	public void setColltnId(String colltnId) {
		this.colltnId = colltnId;
	}
	public String getSspdStatus() {
		return sspdStatus;
	}
	public void setSspdStatus(String sspdStatus) {
		this.sspdStatus = sspdStatus;
	}
	public String getSspdId() {
		return sspdId;
	}
	public void setSspdId(String sspdId) {
		this.sspdId = sspdId;
	}
	public String getPrintStatus() {
		return printStatus;
	}
	public void setPrintStatus(String printStatus) {
		this.printStatus = printStatus;
	}
	public String getPrsnttnAcctNo() {
		return prsnttnAcctNo;
	}
	public void setPrsnttnAcctNo(String prsnttnAcctNo) {
		this.prsnttnAcctNo = prsnttnAcctNo;
	}
	public String getPrsnttnName() {
		return prsnttnName;
	}
	public void setPrsnttnName(String prsnttnName) {
		this.prsnttnName = prsnttnName;
	}
	public String getPrsnttnBankNo() {
		return prsnttnBankNo;
	}
	public void setPrsnttnBankNo(String prsnttnBankNo) {
		this.prsnttnBankNo = prsnttnBankNo;
	}
	public String getPrsnttnBankName() {
		return prsnttnBankName;
	}
	public void setPrsnttnBankName(String prsnttnBankName) {
		this.prsnttnBankName = prsnttnBankName;
	}
	public String getPaymentPath() {
		return paymentPath;
	}
	public void setPaymentPath(String paymentPath) {
		this.paymentPath = paymentPath;
	}
	public String getPaymentDt() {
		return paymentDt;
	}
	public void setPaymentDt(String paymentDt) {
		this.paymentDt = paymentDt;
	}
	public String getCustRemark() {
		return custRemark;
	}
	public void setCustRemark(String custRemark) {
		this.custRemark = custRemark;
	}
	public String getBankRemark() {
		return bankRemark;
	}
	public void setBankRemark(String bankRemark) {
		this.bankRemark = bankRemark;
	}
	public String getPayWaitOrder() {
		return payWaitOrder;
	}
	public void setPayWaitOrder(String payWaitOrder) {
		this.payWaitOrder = payWaitOrder;
	}
	public String getTxlCtrctNb() {
		return txlCtrctNb;
	}
	public void setTxlCtrctNb(String txlCtrctNb) {
		this.txlCtrctNb = txlCtrctNb;
	}
	public String getInvcNb() {
		return invcNb;
	}
	public void setInvcNb(String invcNb) {
		this.invcNb = invcNb;
	}
	public String getRealAcctDt() {
		return realAcctDt;
	}
	public void setRealAcctDt(String realAcctDt) {
		this.realAcctDt = realAcctDt;
	}
	public String getRealAcctTime() {
		return realAcctTime;
	}
	public void setRealAcctTime(String realAcctTime) {
		this.realAcctTime = realAcctTime;
	}
	public String getDrwgBckOperNo() {
		return drwgBckOperNo;
	}
	public void setDrwgBckOperNo(String drwgBckOperNo) {
		this.drwgBckOperNo = drwgBckOperNo;
	}
	public String getDrwgBckDt() {
		return drwgBckDt;
	}
	public void setDrwgBckDt(String drwgBckDt) {
		this.drwgBckDt = drwgBckDt;
	}
	public String getDrwgBckTime() {
		return drwgBckTime;
	}
	public void setDrwgBckTime(String drwgBckTime) {
		this.drwgBckTime = drwgBckTime;
	}
	public String getDrwgBckFlowNo() {
		return drwgBckFlowNo;
	}
	public void setDrwgBckFlowNo(String drwgBckFlowNo) {
		this.drwgBckFlowNo = drwgBckFlowNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getApplyCancelFlag() {
		return applyCancelFlag;
	}
	public void setApplyCancelFlag(String applyCancelFlag) {
		this.applyCancelFlag = applyCancelFlag;
	}
	public String getRequestMsgId() {
		return requestMsgId;
	}
	public void setRequestMsgId(String requestMsgId) {
		this.requestMsgId = requestMsgId;
	}
	public String getYzSource() {
		return yzSource;
	}
	public void setYzSource(String yzSource) {
		this.yzSource = yzSource;
	}
	public String getConferNo() {
		return conferNo;
	}
	public void setConferNo(String conferNo) {
		this.conferNo = conferNo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRegFlowNo() {
		return regFlowNo;
	}
	public void setRegFlowNo(String regFlowNo) {
		this.regFlowNo = regFlowNo;
	}
	public String getBusiType() {
		return busiType;
	}
	public void setBusiType(String busiType) {
		this.busiType = busiType;
	}
	public String getDraweeAcct() {
		return draweeAcct;
	}
	public void setDraweeAcct(String draweeAcct) {
		this.draweeAcct = draweeAcct;
	}
	public String getDraweeName() {
		return draweeName;
	}
	public void setDraweeName(String draweeName) {
		this.draweeName = draweeName;
	}
	public String getDraweeBankNameName() {
		return draweeBankNameName;
	}
	public void setDraweeBankNameName(String draweeBankNameName) {
		this.draweeBankNameName = draweeBankNameName;
	}
	public String getPayeeName() {
		return payeeName;
	}
	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}
	public double getColltnAmt() {
		return colltnAmt;
	}
	public void setColltnAmt(double colltnAmt) {
		this.colltnAmt = colltnAmt;
	}
	public double getPayAmt() {
		return payAmt;
	}
	public void setPayAmt(double payAmt) {
		this.payAmt = payAmt;
	}
	public double getCompensAmt() {
		return compensAmt;
	}
	public void setCompensAmt(double compensAmt) {
		this.compensAmt = compensAmt;
	}
	public String getBankType() {
		return bankType;
	}
	public void setBankType(String bankType) {
		this.bankType = bankType;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getRegDt() {
		return regDt;
	}
	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}
	public String getIsDelay() {
		return isDelay;
	}
	public void setIsDelay(String isDelay) {
		this.isDelay = isDelay;
	}
	public String getDelayReason() {
		return delayReason;
	}
	public void setDelayReason(String delayReason) {
		this.delayReason = delayReason;
	}
	public String getAccountDt() {
		return accountDt;
	}
	public void setAccountDt(String accountDt) {
		this.accountDt = accountDt;
	}
	public String getRejectDt() {
		return rejectDt;
	}
	public void setRejectDt(String rejectDt) {
		this.rejectDt = rejectDt;
	}
	public String getRejectCode() {
		return rejectCode;
	}
	public void setRejectCode(String rejectCode) {
		this.rejectCode = rejectCode;
	}
	public String getRejectReason() {
		return rejectReason;
	}
	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}
	public String getOperNo() {
		return operNo;
	}
	public void setOperNo(String operNo) {
		this.operNo = operNo;
	}
	public String getOperTime() {
		return operTime;
	}
	public void setOperTime(String operTime) {
		this.operTime = operTime;
	}
	public String getAuditUserNo() {
		return auditUserNo;
	}
	public void setAuditUserNo(String auditUserNo) {
		this.auditUserNo = auditUserNo;
	}
	public String getAuditTime() {
		return auditTime;
	}
	public void setAuditTime(String auditTime) {
		this.auditTime = auditTime;
	}
	public String getSettleMark() {
		return settleMark;
	}
	public void setSettleMark(String settleMark) {
		this.settleMark = settleMark;
	}
	public String getFund() {
		return fund;
	}
	public void setFund(String fund) {
		this.fund = fund;
	}
	private String rejectReason = " ";	//reject_reason//退票理由
	private String operNo = " ";	//操作柜员
	private String operTime = " ";	//操作时间
	private String auditUserNo = " ";	//复核柜员
	private String auditTime = " ";	//复核时间
	private String settleMark = " ";	//settle_mark//清算方式 SM00线上,SM01线下
	private String fund = " ";	//fund//资金去向 0-转帐 1-挂帐

}
