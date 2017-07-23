/**
 * Created by sanjana on 22/7/17.
 */
function openSignUp() {
            window.location = "/signUp";
            return false;
}

function loginUser() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
           var user = xhttp.responseText;
           if(user.length == 0){
                document.getElementById('errorMsg').innerHTML = "Invalid Id or password! Please try again.";
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
