/**
 * Created by sanjana on 22/7/17.
 */
function openSignUp() {
            window.location = "/signUp";
            return false;
}

function loginUser() {
    var userId = document.getElementById('userId').value;
    var password = document.getElementById('password').value;
    if(userId.length ==0){
        document.getElementById('errorMsg').innerHTML = "Please enter an id!!";
        return;
    }
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
           var user = xhttp.responseText;
           if(user.length == 0){
                document.getElementById('errorMsg').innerHTML = "User doesn't exist! Redirecting to create user page";
                setTimeout(function () {
                    openSignUp();
                }, 1000);

           }else{
               window.sessionStorage.setItem("user", user);
               window.location = "/profile";
           }

        }
    }
    var userId = document.getElementById('userId').value;
    var password = document.getElementById('password').value;
    var params = "userId=" + userId + "&password=" + password;
    xhttp.open("POST", "/signIn", true);
    xhttp.send(params);
    return false;
}
