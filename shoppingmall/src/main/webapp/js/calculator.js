var resultBtn = document.getElementById('result');
resultBtn.addEventListener('click', function(){
	var num1 = document.querySelector('#num1').value;
	var num2 = document.querySelector('#num2').value;
	var op = document.querySelector('#operator');
	var opText = op.options[op.selectedIndex].value
	
	console.log(num1);
	console.log(num2);
	console.log(opText);
	
	num1 = Number(num1);
	num2 = Number(num2);
	var resultVal = '';
	if(opText === '+'){
		resultVal = num1 + num2;
	} else if(opText === '-'){
		resultVal = num1 - num2;
	} else if(opText === '*'){
		resultVal = num1 * num2;
	} else if(opText === '/'){
		resultVal = num1 / num2;
	}
	console.log(resultVal);
	document.querySelector('#output').innerText = resultVal;
	
})