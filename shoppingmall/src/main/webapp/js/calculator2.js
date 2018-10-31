var resultBtn = document.getElementById('result');
resultBtn.addEventListener('click', function(){
	var num1 = document.querySelector('#num1').value;
	var num2 = document.querySelector('#num2').value;
	var op = document.querySelector('#operator');
	var opText = op.options[op.selectedIndex].value
	console.log(opText);
	if(opText == '+'){
		opText = '!';
	}
	ajax({
		method: 'get',
		url: 'ajax.mall',
		param: 'num1='+num1+'&num2='+num2+'&op='+opText,
		callback: receiveServer
	});
})

function receiveServer(request){
   var result = request.responseText;
   document.querySelector('#output').innerText = result;
}