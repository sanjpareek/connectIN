/**
 * Created by sanjana on 23/7/17.
 */

(function(e) {
    var userString = window.sessionStorage.getItem("user");
    var user = JSON.parse(userString);
    var name = user.firstName + " " + user.lastName;
    var email = user.email;

    document.getElementById("userName").innerHTML = name;
    document.getElementById("email").innerHTML = email;
})();