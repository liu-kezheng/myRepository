<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript">
$(function(){
	$("a").click(function(){
		$.post("login.do?methodName=login",{"name":$(":text").val(),"idcard":$(":password").val()},function(data){
			console.log(data);
			console.log(typeof data);
			var msg = eval("(" + data + ")");
			var result="";
			for(var i = 0 ;i<msg.length;i++){	
			result += "<tr>"+
			"<td>"+msg[i].id+"</td>"+
			"<td>"+msg[i].name+"</td>"+
			"<td>"+msg[i].sex+"</td>"+
			"<td>"+msg[i].idcard+"</td>"+
			"<td>"+msg[i].address+"</td>"+
			"</tr>";
			}
			$("#mytbody").html(result);
		})
	})
});
	

</script>
</head>
<body>
用户名:<input type="text" name="name">
IdCard:<input type="password" name="idcard" >
<a href="javascript:;">查询</a><br/>
<hr>
<table border="1px" cellspacing="0px">
	<tr>
		<td>ID</td>
		<td>姓名</td>
		<td>IDCard</td>
		<td>性别</td>
		<td>地址</td>
	</tr>
	<tbody id="mytbody">
	</tbody>
</table>
</body>
</html>