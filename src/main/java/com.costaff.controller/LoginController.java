package com.costaff.controller;

import com.costaff.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping(method = RequestMethod.POST,value = "/login")
    public String login(HttpServletRequest req, HttpServletResponse res){
        String username=req.getParameter("username1");
        String password =req.getParameter("password");
        boolean loginStatus=loginService.authenticate(username,password);
        if(loginStatus==true)
            return "dashboard";
        else
            return "error";
    }


}