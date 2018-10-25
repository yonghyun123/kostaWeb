<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>EL연습</title>
</head>
<body>
${"김기정"}
${'김기정'}
${10}
${null}
${true}<br>

${10+'20'} <%=10+"20" %>, ${10+'20'}, ${10/200}<br>
${true && false }, ${true and false}
${empty null }
${empty '' }

</body>
</html>