<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<title>密码管理</title>
<script type="text/javascript" src="<c:url value="/static/js/core-min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/static/js/enc-base64.js"/>"></script>
<script type="text/javascript" src="<c:url value="/static/js/cipher-core.js"/>"></script>
<script type="text/javascript" src="<c:url value="/static/js/aes.js"/>"></script>
<script type="text/javascript" src="<c:url value="/static/js/pad-zeropadding-min.js"/>"></script>
<script type="text/javascript">
function decrypt1(){
	var encrypted = document.getElementById("str").value;
	var key  = CryptoJS.enc.Latin1.parse(document.getElementById("key").value);
	var iv   = CryptoJS.enc.Latin1.parse("vYdKUfTV01TA4t41");
	var decrypted = CryptoJS.AES.decrypt(encrypted,key,{iv:iv,padding:CryptoJS.pad.ZeroPadding});
	alert(decrypted.toString(CryptoJS.enc.Utf8));
}
function encrypt1(){
	var str = document.getElementById("str").value;
	var ss = str.split(",");
	document.getElementById("token").value = ss[2];
	var key  = CryptoJS.enc.Latin1.parse(ss[0]);
	var ivStr = "vYdKUfTV01TA4t41";
	var iv   = CryptoJS.enc.Latin1.parse(ivStr);
	var data = document.getElementById("username").value+","+document.getElementById("password").value;
	var encrypted = CryptoJS.AES.encrypt(data,key,{iv:iv,mode:CryptoJS.mode.CBC,padding:CryptoJS.pad.ZeroPadding});
	
	document.getElementById("pass").value = CryptoJS.enc.Base64.stringify(encrypted.ciphertext)+","+ivStr;
	document.forms[0].submit();
}
</script>
</head>

<body>
<textarea id="str" rows="" cols="34" placeholder="此处粘贴二维码扫描的内容"></textarea>
<div style="display:none">
Key:<input type="text"  id="key"/><br>
<input type="button" value="解密" onclick="decrypt1()">
</div>
<br>
用户名:<input type="text"  id="username"/><br>
密　码:<input type="password"  id="password"/><br>
<form method="post" action="<c:url value="/passtrans"/>" target="iframe">
	<input type="hidden"  name="token" id="token"/>
	<input type="hidden"  name="pass" id="pass"/>
	<input type="button" onclick="encrypt1()" value="确定"/>
</form>
<iframe name="iframe"></iframe>
</body>
</html>
