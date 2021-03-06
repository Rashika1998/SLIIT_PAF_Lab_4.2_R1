/**
 * 
 */

function emptyCheck(name,id) { 
 var inputValue = document.getElementById(name); 
 if (inputValue.value == "" || inputValue.value == null || inputValue.value == " ") { 
 id.style.backgroundColor = "red"; 
 
 }else{ 
 id.style.backgroundColor = ""; 
 } 
} 




function nicValidation(nic,id) {
 var regExpression = /^[0-9]{9}[vVxX]$/; 
 if (!regExpression.test(nic)) { 
 id.style.backgroundColor = "red"; 
 alert("Invalid NIC") 
 }else{ 
 value.style.backgroundColor = ""; 
 } 
}






function emailValidation(email, id) {
 var regExpression = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/; 
 if (!regExpression.test(email)) { 
 id.style.backgroundColor = "red"; 
 alert("Invalid E-mail") 
 }else{ 
 value.style.backgroundColor = ""; 
 } 
} 





function mobileValidation(phone, id) {
 var regExpression = /^\d{10}$/; 
 if (!regExpression.test(phone)) { 
 id.style.backgroundColor = "red"; 
 alert("Invalid Mobile number") 
 }else{ 
 value.style.backgroundColor = ""; 
 } 
}


function validateForm() {
 
 var username = document.getElementById('username'); 
 var email = document.getElementById('email'); 
 var nic = document.getElementById('nic'); 
 var mobile = document.getElementById('mobile'); 
 var password = document.getElementById('password'); 
 var password_confirm = document.getElementById('password_confirm'); 


	
	emailValidation(email.value, email)
	nicValidation(nic.value, nic) 
	mobileValidation(mobile.value, mobile)
	
}






