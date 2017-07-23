package com.connectin;

import com.connectin.Utility.Utility;
import com.connectin.models.Users;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by sanjana on 22/7/17.
 */

@Controller
public class MainController {

    @RequestMapping("/signUp")
    public String signUp(){
        return "signup.html";
    }

    @RequestMapping("/home")
    public String loginCall(){
        return "login.html";
    }

    @RequestMapping("/profile")
    public String viewProfile(){
        return "user_profile.html";
    }

    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public @ResponseBody Users signInUser(@RequestBody String loginData){
        Map<String, String> params = Utility.getQueryParams(loginData);
        Users user = DBServices.getUser(params.get("userId"),  params.get("password"));
        return user;
    }

    @RequestMapping(value = "/newUser", method = RequestMethod.GET)
    public String addNewUser(String userId,String password,  String firstName, String lastName, String email){
        try{
            DBServices.insertRecord(userId, password, firstName, lastName, email);
        }catch (Exception e){
            System.out.print("Encountered exception : " + e);
        }
        return loginCall();
    }

}

