function validateForm(){
var x = document.forms["signIn"]["email"].value;
/*var y = document.forms["signIn"]["password"].value;
	if(x==null && y==null || x=="" && y==""){
		alert("Email and password must be filled out! ");
		return false;
	}
	else if(x==null && y!=null || x=="" && y!=""){
		alert("Email must be filled out! ");
		return false;
	}
	else if(y==null && x!=null || y=="" && x!=""){
		alert("Email must be filled out! ");
		return false;
	}*/
	if(x==null || x==""){
		alert("Name must be filled out! ");
		return false;
	}
}