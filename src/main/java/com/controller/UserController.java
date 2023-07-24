package com.controller;

import com.model.User;
import com.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * @author Livre arbítrio
 * @date 2023/7/18
 * 公众号：无
 * 博  客：https://createres1.github.io/
 * @apiNote
 */
@Controller
public class UserController  extends GenericController{
    @Resource
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * web根路径：默认跳转至login
     *
     * @return
     */
    @RequestMapping("/")
    public ModelAndView toLogin() {
        return new ModelAndView("login");
    }

    /**
     * 处理登录请求
     *
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/login")
    public ModelAndView login(String username, String password) throws Exception {
        User currentUser = this.userService.findByUsernameAndPassword(username, password);
        if (currentUser == null) {
            return new ModelAndView("login", "message", "用户名或密码错误");
        } else {
            this.session.setAttribute("currentUser", currentUser);
            return new ModelAndView("index");
        }
    }
}
