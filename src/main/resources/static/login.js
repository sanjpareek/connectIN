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
           window.sessionStorage.setItem("user", user);
            window.location = "/profile";
        }
    }
    var userId = document.getElementById('userId').value;
    xhttp.open("GET", "/signIn?userId=" + userId, true);
    xhttp.send();
    return false;
}
