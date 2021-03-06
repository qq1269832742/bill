/********************************************
 * 文件名称: Var103003.java
 * 系统名称: 票据管理平台V2.0
 * 模块名称:
 * 软件版权: 北京合融科技有限公司
 * 功能说明: 
 * 系统版本: 2.0.0.1
 * 开发人员: fqq
 * 开发时间: 20160808
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期    修改人员    修改说明
 *********************************************/

package com.herongtech.online.trans.trans103003;

import java.util.List;

import com.herongtech.data.interfaces.data.IData;
import com.herongtech.online.trans.trans103002.Var103002InfoBean;
import com.herongtech.rc.domain.bean.RcBaseSearchBean;


/**
 * 客户信息查询
 * @author Administrator
 *
 */
public class Var103003 {
	public static final String  HUNDSUN_VERSION="@system  票据管理平台  @version 2.0.0.1  @lastModiDate @describe ";
	/**
	 * 查询结果
	 */
	private IData resultData = null;
	private String custAccount = null;
	
	private List<Var103003InfoBean> result;
	
	
	/**
	 * 总记录数
	 */
	private String totRecNum = null;
	private String currentPage = null;
	private String pageSize = null;
	/**
	 * 
	 * @return IDataset
	 */
	public IData getResultData() {
		return resultData;
	}

	/**
	 * 
	 * @param resultDataSet
	 */
	public void setResultData(IData resultData) {
		this.resultData = resultData;
	}

	

	public String getCustAccount() {
		return custAccount;
	}

	public void setCustAccount(String custAccount) {
		this.custAccount = custAccount;
	}

	public List<Var103003InfoBean> getResult() {
		return result;
	}

	public void setResult(List<Var103003InfoBean> result) {
		this.result = result;
	}

	public String getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}

	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	public String getTotRecNum() {
		return totRecNum;
	}

	public void setTotRecNum(String totRecNum) {
		this.totRecNum = totRecNum;
	}
	
}
