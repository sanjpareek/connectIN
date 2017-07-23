package com.connectin;

import com.connectin.models.Users;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping("/signIn")
    public @ResponseBody Users signInUser(String userId){
        Users user = DBServices.getUser(userId);
        return user;
    }

    @RequestMapping(value = "/newUser", method = RequestMethod.GET)
    public String addNewUser(String userId, String firstName, String lastName, String email){
        try{
            DBServices.insertRecord(userId,firstName, lastName, email);
        }catch (Exception e){
            System.out.print("Encountered exception : " + e);
        }
        return loginCall();
    }

}

