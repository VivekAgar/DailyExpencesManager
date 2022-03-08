package com.mycompany.dailyexpensemanager.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method=RequestMethod.POST, value="/user/add")
    public void addTopic(@RequestBody User user) {
        userService.addUser(user);

    }

    @RequestMapping(method=RequestMethod.GET, value="/user/hello")
    public String hello() {
        return "alive !running ";
    }



}
