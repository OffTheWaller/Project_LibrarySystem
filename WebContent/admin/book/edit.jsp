<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<LINK href="${pageContext.request.contextPath}/css/Style1.css" type="text/css" rel="stylesheet">
		
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
		
		<script type="text/javascript">
		
			$(function(){
				//获得当前回显的book的cid
				$("#cid option[value='${book.cid }']").prop("selected",true);
				//是否热门
				$("#is_hot option[value='${book.is_hot }']").prop("selected",true);
			});
		
		
			//页面加载完毕后 确定那个option被选中
			/* window.onload = function(){
				//获得当前回显的book的cid
				var cid = "${product.cid }";
				//获得所有的<select name="cid">下的option
				var options = document.getElementById("cid").getElementsByTagName("option");
				//比较每一个option的value与cid
				for(var i=0;i<options.length;i++){
					if(cid==options[i].value){
						options[i].selected = true;
					}
				}
			} */
			
			
			
		</script>
		
		
	</HEAD>
	
	<body>
		<!--  -->
		<form id="userAction_save_do" name="Form1" action="${pageContext.request.contextPath}/adminUpdateBook" method="post">
			
			<input type="hidden" name="bid" value="${book.bid }">
			
			<table cellSpacing="1" cellPadding="5" width="100%" align="center" bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
						height="26">
						<strong><STRONG>编辑图书</STRONG>
						</strong>
					</td>
				</tr>

				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						图书名称：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="bname" value="${book.bname }" id="userAction_save_do_logonName" class="bg"/>
					</td>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						是否热门：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						
						<select id="is_hot" name="is_hot">
							<option value="1">是</option>
							<option value="0">否</option>
						</select>
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						图书价格：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="bprice" value="${book.bprice }" id="userAction_save_do_logonName" class="bg"/>
					</td>
					
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						图书封面：
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="3">
						<input type="file" name="upload" />
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						所属分类：
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="3">
						<select id="cid" name="cid">
							<c:forEach items="${categoryList }" var="category">
								<option value="${category.cid }">${category.cname }</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						图书描述：
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="3">
						<textarea name="bdesc" rows="5" cols="30">${book.bdesc }</textarea>
					</td>
				</tr>
				<tr>
					<td class="ta_01" style="WIDTH: 100%" align="center"
						bgColor="#f5fafe" colSpan="4">
						<button type="submit" id="userAction_save_do_submit" value="确定" class="button_ok">
							确定
						</button>

						<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
						<button type="reset" value="重置" class="button_cancel">&#37325;&#32622;</button>

						<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
						<INPUT class="button_ok" type="button" onclick="history.go(-1)" value="返回"/>
						<span id="Label1"></span>
					</td>
				</tr>
			</table>
		</form>
	</body>
</HTML>