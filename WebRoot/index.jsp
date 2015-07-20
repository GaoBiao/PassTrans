<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>密码箱</title>
<link type="text/css" href="<c:url value="/static/css/style.css"/>" rel="stylesheet" />
</head>

<body>

	<h3>密码箱使用方法：</h3>
	<ul>
		<li>1、<a class="markbtn" href="javascript:void((function(){var element=document.getElementById('passtrans_js');if(element){pt_init();}else{element=document.createElement('script');element.id='passtrans_js';element.charset='utf-8',element.setAttribute('src','<%=basePath%>static/js/passtrans.js?'+Date.parse(new Date()));document.body.appendChild(element);}})());"><span>扫描登录</span></a></li>
		<li>2、下载手机APP。扫描下载APP：<img style="vertical-align: top;" src="<c:url value="/static/images/qrcode.bmp"/>" /></li>
		<li>3、打开APP，输入要保存的用户名密码以及对应的网址</li>
		<li>4、PC端浏览器访问要登录网址的登录页面，点击收藏夹（书签）里的“扫码登录”，出现二维码</li>
		<li>5、使用手机APP扫描二维码，确认登录信息</li>
		<li>6、PC端自动输入用户名密码，登录即可.</li>
	</ul>

</body>
</html>
