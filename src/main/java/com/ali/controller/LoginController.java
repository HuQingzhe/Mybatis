package com.ali.controller;

import com.ali.model.User;
import com.ali.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author QingzheHu
 * @date 2021/7/2 17:39
 */

@Controller
public class LoginController {
    @Resource
    private UserService userService;

    @RequestMapping("")
    public String gotoLoginPage() {
        return "login";
    }

    @RequestMapping("login")
    public String gotoLogin(User user, HttpSession session) {
        User u = userService.login(user);
        if (u != null) {
            session.setAttribute("user", u);
            return "redirect:/student/show";
        }
        return "login";
    }
}
