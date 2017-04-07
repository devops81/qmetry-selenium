var attempt = 3; //Variable to count number of attempts

//Below function Executes on click of login button
function validate(){
	var username = document.getElementById("username").value;
	var password = document.getElementById("password").value;
	
	if ( username == "400219041" && password == "sa"){
		alert ("Login successfully");
		window.location = "success.html"; //redirecting to other page
		return false;
	}
	else if(username == "" && password == "sa")
	{
		document.getElementById('error').innerHTML="User Name can not be blanked";
	}
	else if(username == "400219041" && password == "")
	{
		document.getElementById('error').innerHTML="Password can not be blanked";
	}
	
	else if(username == "" && password == "")
	{
		document.getElementById('error').innerHTML="User Name & Password can not be blanked";
	}
	
	/*else if (!username.match(/^[a-zA-Z]+$/)) 
    {
        alert('Only alphabets are allowed');
        return false;
    }*/
	
	else{
		
		
		attempt --;//Decrementing by one
		alert("Invalid User or Password and You have left only "+attempt+" attempt");
		
		//Disabling fields after 3 attempts
		if( attempt == 0){
			document.getElementById("username").disabled = true;
			document.getElementById("password").disabled = true;
			document.getElementById("submit").disabled = true;
			return false;
		}
	}
}
function blockSpecialChar(e){
        var k;
        document.all ? k = e.keyCode : k = e.which;
        return ((k > 64 && k < 91) || (k > 96 && k < 123) || k == 8 || k == 32 || (k >= 48 && k <= 57));
        }