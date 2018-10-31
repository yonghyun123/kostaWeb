var resultBtn = document.getElementById('result');
resultBtn.addEventListener('click', function(){
	var num1 = document.querySelector('#num1').value;
	var num2 = document.querySelector('#num2').value;
	var op = document.querySelector('#operator');
	var opText = '+';
	opText = op.options[op.selectedIndex].value
	console.log(opText);
	num1 = Number(num1);
	num2 = Number(num2);
	var url = "calculator_action.jsp?num1="+num1+"&num2="+num2+"&op="+opText;
	location.href=url;
})

function replace(operator){
   return encodeURIComponent(operator);

}