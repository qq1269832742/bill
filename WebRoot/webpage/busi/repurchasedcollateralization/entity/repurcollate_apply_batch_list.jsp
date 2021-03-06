<%-- 
 * 文件名称: repurCollate_apply_batch_list.jsp
 * 系统名称: 票据管理平台
 * 模块名称:
 * 软件版权: 北京合融科技有限公司
 * 功能说明: 
 * 系统版本: @version2.0.0.1
 * 开发人员: v
 * 开发时间: 2016-8-10
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期    修改人员    修改说明
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/webpage/system/admin/taglib.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<base href="<%=basePath%>">
		<%-- jsp文件头和头部 --%>
		<%@ include file="/webpage/system/admin/top.jsp"%>
	</head>
<body>
	<div class="clearfix">
		<div id="page-content" class="page-content">
			<div id="header">
				<form action="<%=basePath%>repurCollateApplyController.do?method=searchBatch"  method="post" name="custForm" id="custForm" class="form-search">
					<%-- 查询区  --%>
					<div class="row-fluid">
						<label class="no-padding-right" for="custNo"><span class="star">*</span>客户号</label>
						<input type="text" class="input-medium" id="custNo" name="custNo" valid="required" value="${query.custNo}" placeholder="请输入客户号"/>
						<a class="btn-mini" id="search"  onclick="fill();">填充</a>
						<label class="no-padding-right" for="custName"><span class="star">*</span>客户名称</label>
						<input readonly="true" class="input-medium" type="text" id="custName" name="custName" valid="required" value="${custName}"/>
					</div>
				</form>
			</div>
			<%-- 按钮操作区 --%>
			<div id="center">
				<form  id="btnForm">
					<div class="row-fluid">
						<div class="span6" id="btn-left" >
							<a class="btn-mini" href="javascript:billManage();">下一步</a>
					    </div>
					   <div class="span6" id="btn-right">
					   </div>
				   </div>
				</form>
			 </div>
		     <div id="footer">
				<table class="table table-striped table-bordered table-hover" id="tab" cellpadding="0" cellspacing="0">
					<thead>
						<tr>
							<th class="center" onclick="">
								<span class="lbl"></span>
							</th>
							<th>批次号</th>
							<th>批次类型</th>
							<th>批次种类</th>
							<th>客户名称</th>
							<th>产品编号</th>
							<th>合计张数</th>
							<th>合计金额</th>
							<th>客户经理编号</th>
							<th>客户经理名称</th>
							<th>所属部门</th>
							<th>详情</th>
						</tr>
					</thead>
					<tbody id="dataBody">
						<c:choose>
								<c:when test="${not empty resultList}">
									<c:forEach items="${resultList}" var="batchList" varStatus="vs">
										<tr>
											<td class="center">
												<input type="checkbox" onclick="radioStyle(this,'saveId')" name="saveId" value="${batchList.saveId}"/><span class="lbl"></span>
											</td>
											<td class="center">${batchList.batchNo}</td>
											<td class="center">${fns:getDictLabel('K_BILL_TYPE',batchList.batchType)}</td>
											<td class="center">${fns:getDictLabel('K_BILL_CLASS',batchList.batchClass)}</td>
											<td class="center">${batchList.custName}</td>
											<td class="center">${batchList.prodNo}</td>
											<td class="center">${batchList.totalNum}</td>
											<td class="center">${fns:formateMoney(batchList.totalMoney)}</td>
											<td class="center">${batchList.custManager}</td>
											<td class="center">${batchList.custManagerName}</td>
											<td class="center">${batchList.deptName}</td>
											<td class="center"><a href="javascript:goBatchDetail('${batchList.saveId}')">查看</a></td>
										</tr>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<tr>
										<td colspan="100" class="center">没有相关数据</td>
									</tr>
								</c:otherwise>
							</c:choose>
						</tbody>
					</table>
				</div>
				<form action="#" name="dataCollectForm" method="post"></form>
				<%-- /列表操作区 --%>
				<div>
					<div id="page" class="pagination hid">
						<form action="<%=basePath%>repurCollateApplyController.do?method=searchBatch" name="pageForm" method="post">
							<%@ include file="/webpage/system/admin/pageFormContent.jsp"%>
							<input type="hidden" name="custNo" value="${query.custNo}"/>
							<input type="hidden" name="custName" value="${custName}"/>
						</form>
					</div>
				</div>
			</div>
		</div>
<%@ include file="/webpage/system/admin/modalDialog.jsp"%> 
<%@ include file="/webpage/system/admin/footer.jsp"%> 
<script>
    var custNo = $("#custNo").val();
    if(custNo!=""){
    	$(".hid").show();
    }else{
    	$(".hid").hide();
    }
	$("#tab th,td").addClass("center");
	$(function(){
		var custNo = "${custNo}";
		if(""!=custNo && custNo!=null){
			$.ajax({
				type: "POST",
				url: "<%=basePath%>repurCollateApplyController.do?method=custInfo",
		    	data: {'custNo':custNo},
				dataType:'json',
				success: function(data){
					if(data.success){  //处理成功
						$("#custNo").val(custNo);
						$("#custName").val(data.attributes.custName);
						fillBatch(1,5);
					}else{
						$("#custName").val("");
						bootbox.alert(data.msg); 
					}
				}
			});	
		}
	});
	//批次详情
	function goBatchDetail(saveId){
	   	 var diag = new top.Dialog();
		 diag.Drag = true;
		 diag.Title ="详情";
		 diag.URL = "<%=basePath%>collateralizationApplyController.do?method=goBatchDetail&saveId="+saveId;
		 diag.Width = 990;
		 diag.Height = 190;
		 diag.CancelEvent = function(){ //关闭事件
			diag.close();
		 };
		 diag.show();
	}
	//票据管理
	function billManage(){
		 var checkNum = getCheckNum("saveId");
	   	 if (checkNum !=1){
	   		bootbox.alert("请先选择要编辑的记录!");
	   		return;
	   	 }
	   	 var saveId = getCheckStr("saveId");
	   	 $("#_ButtonClose_0").css({'width':'27px','top':'4px','background-position': '-1px 0px'});
	   	 dynamicHiddenElement('dataCollectForm','saveId',saveId);
	   	 modal("#layer_loading,#image");//点击票据管理按钮，弹出‘加载中’的遮罩层
	     dataCollectForm.action = "<%=basePath%>repurCollateApplyController.do?method=billManage"
	     dataCollectForm.submit();
	}
	function fill(){ //根据客户号查询客户信息并填充
			var custNo = $('#custNo').val();
			$.ajax({
				type: "POST",
				url: "<%=basePath%>repurCollateApplyController.do?method=custInfo",
		    	data: {'custNo': custNo},
				dataType:'json',
				beforeSend:function(){
					if(custNo==null||custNo==""){
						bootbox.alert("请输入客户号!");
						$("#custName").val("");
				   		return false;
					}
				},
				cache: false,
				success: function(data){	
					if(data.success){  //处理成功
						$("#custName").val(data.attributes.custName);
						$("#custNo").val(data.attributes.custNo);
						modal("#layer_loading,#image");
						custForm.submit();
					}else{
						$("#custName").val("");
						bootbox.alert(data.msg);
						var trHtml = "<tr><td colspan=\"100\" class=\"center\">没有相关数据</td></tr>";
						$("#dataBody").html(trHtml);
					}
				}
			});
		}
		function nextPage(page){
			fillBatch(page,5);
		}
		function changeCount(value){
			fillBatch(1,value);
		}
</script>
</body>
</html>