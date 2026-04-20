package com.fyfe.controller;

import com.fyfe.pojo.User;
import com.fyfe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/user")
public class LoginController {
    @Autowired
    private UserService userService;

    //跳转首页（登录页）
    @RequestMapping("/toIndex")
    public String show(){
        return "index";
    }

    //登录操作
    @ResponseBody
    @RequestMapping("/loginUser")
    public String login(User user, HttpServletRequest request){
        String userName = user.getUsername();
        String passWord = user.getPassword();
        List<User> u1 =userService.login(userName,passWord);
        if (u1.size() <= 0){
            return "用户名或密码错误";
        }else{
            request.getSession().setAttribute("session_user",user);//登录成功后将用户放入session中，用于拦截
            return "登录成功";
        }
    }

    //跳转注册页
    @RequestMapping("/toRegister")
    public String toRegister(){
        return "register";
    }

    //注册操作
    @ResponseBody
    @RequestMapping("/register")
    public String register(User user){
        String userName = user.getUsername();
        List<User> u1 =userService.checkUser(userName);
        if (u1.size() > 0){
            return "用户名已存在";
        }

        int su = userService.register(user);
        if(su==0){
            System.out.println("----");
        }
        return "welcome";
    }

    //测试未登陆拦截页面
    @RequestMapping("/welcome")
    public String welcome(HttpServletRequest request, Model model) {
        User sessionUser = (User) request.getSession().getAttribute("session_user"); // 假设登录时存入了 "loginUser"
        System.out.println("sessionUser，" + sessionUser.getUsername());
        model.addAttribute("session_user", sessionUser);
        return "welcome";
    }

    //退出登录
    @RequestMapping("/outUser")
    public void outUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().removeAttribute("session_user");
        response.sendRedirect("/user/toIndex");
    }
}