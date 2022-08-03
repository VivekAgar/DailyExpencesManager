package com.mycompany.dailyexpensemanager.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.List;

@RestController
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

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

    @RequestMapping(method=RequestMethod.GET, value="/user/list")
    public List<User> listAll() {
        logger.info("in  /user/list VIVEK : ");
        logger.debug("in  /user/list VIVEK : ");
        List<User> users = userService.getAllUsers();
        logger.debug("in  /user/list VIVEK : "+ users);
        return users;

    }

    @RequestMapping(method=RequestMethod.GET, value="/user/logout")
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
            logger.info("Logging Out");
        }
        return "redirect:/";

    }





//    @RequestMapping(method=RequestMethod.GET, value="/user/list")
//    public String listAll() {
//        logger.info("in  /user/list VIVEK : ");
//        logger.debug("in  /user/list VIVEK : ");
//        List<User> users = userService.getAllUsers();
//        //logger.debug("in  /user/list VIVEK : "+ users);
//        return users;
//
//    }




}
