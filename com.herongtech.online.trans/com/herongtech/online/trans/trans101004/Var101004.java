/********************************************
 * 文件名称: Var101004.java
 * 系统名称: 票据管理平台V2.0
 * 模块名称:
 * 软件版权: 北京合融科技有限公司
 * 功能说明: 
 * 系统版本: 2.0.0.1
 * 开发人员: dq
 * 开发时间: 20160809
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期    修改人员    修改说明
 *********************************************/

package com.herongtech.online.trans.trans101004;

import java.util.List;




/**
 * 客户信息查询
 * @author Administrator
 *
 */
public class Var101004 {
	public static final String  HUNDSUN_VERSION="@system  票据管理平台  @version 2.0.0.1  @lastModiDate @describe ";
	/**
	 * 总记录数
	 */
	private int totRecNum = 0;
	//传入的参数
	private int pageSize;	//每页显示的行数	int	Y	
	private int currentPage;	//当前页号	int	Y	
	private String custAccount;	//客户账号	String(50)	Y	
	//传出的参数
	private int totalRows;	//	总行数	int	Y	
	private int retNum;	//	本次返回行数	int	Y	
	private List<Var101004Bean> beanlist;
	public List<Var101004Bean> getBeanlist() {
		return beanlist;
	}

	public void setBeanlist(List<Var101004Bean> beanlist) {
		this.beanlist = beanlist;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public String getCustAccount() {
		return custAccount;
	}

	public void setCustAccount(String custAccount) {
		this.custAccount = custAccount;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public int getRetNum() {
		return retNum;
	}

	public void setRetNum(int retNum) {
		this.retNum = retNum;
	}

	public static String getHundsunVersion() {
		return HUNDSUN_VERSION;
	}

	
	public int getTotRecNum() {
		return totRecNum;
	}

	public void setTotRecNum(int totRecNum) {
		this.totRecNum = totRecNum;
	}

}
