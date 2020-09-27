<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <script type="text/javascript" src="/js/jquery-1.7.2.min.js" charset="UTF-8"></script> -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">

function qrcode() {
	
	$.ajax({
		url : "${pageContext.request.contextPath}/qrcode",
		type : 'post',
		dataType : 'json',
		data : $('#qr').serialize(),
		success : function(data) {
			alert("qr생성")	
			alert(data.img);         
			$('#img').attr('src', data.img);
			$('#content').val("");
			
		},
		error : function(xhr) {  
			alert("꽝");
		
		}
	});		
}

</script>
<title>QR Code Sample</title>
</head>
<body>
<h1>QR Code</h1>
<div>
<form action="" id="qr">
        <input id="content" type="text" name="content"/>
        <input type="button" id="execute" value="건물명" onclick="qrcode();"/>    
        <img id="img" >
</form>
</div>
</body>
</html>