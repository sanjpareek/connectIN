/**
 * Created by sanjana on 23/7/17.
 */

var profileLoad =function(e) {
    var userString = window.sessionStorage.getItem("user");
    var user = JSON.parse(userString);
    var name = user.firstName + " " + user.lastName;
    var email = user.email;
    document.getElementById("userName").innerHTML = name;
    document.getElementById("email").innerHTML = email;
    document.getElementById("centerDiv").style.display = 'block';
    document.getElementById("friendsDiv").style.display = 'none';
    document.getElementById("userPic").src="Elon-Musk.png";
    document.getElementById("email").style.display = 'block';
    document.getElementById("userId").innerHTML = "";
};

var friendsList = function () {
    document.getElementById("centerDiv").style.display = 'none';
    document.getElementById("friendsDiv").style.display = 'block';
};

var searchUser = function (e){
    if(e){
        document.getElementById("userName").innerHTML = e.innerHTML;
    }else{
        document.getElementById("userName").innerHTML = document.getElementById("userId").value;
    }
    document.getElementById("email").style.display = 'none';
    document.getElementById("userPic").src="ironman.png";
    document.getElementById("centerDiv").style.display = 'block';
    document.getElementById("friendsDiv").style.display = 'none';
};

