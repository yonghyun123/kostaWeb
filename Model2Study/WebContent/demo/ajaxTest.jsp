<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>

</body>
<script type="text/javascript">
	var xhr = new XMLHttpRequest();
	xhr.addEventListener('load', function(){
		var data = JSON.parse(xhr.responseText);
		console.log(data);
	});
	xhr.open('GET','http://localhost/model2/ajax.mall');
	xhr.send();
</script>
</html>