package com.mycompany.dailyexpensemanager.user;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;

@RestController
public class HomeResource {

    @RequestMapping(method= RequestMethod.GET, value = "/")
    public String home(){
        return ("<h1>Welcome to Home Page</h1");
    }

    @RequestMapping(method= RequestMethod.GET, value = "/user")
    public String user(){
        return ("<h1>Welcome User</h1>");
    }

    @RequestMapping(method= RequestMethod.GET, value = "/admin")
    public String admin(){
        return ("<h1>Welcome Admin</h1>");
    }

}
