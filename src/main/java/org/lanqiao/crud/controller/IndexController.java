package org.lanqiao.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {
    @PostMapping("user/login")
    public String login(String username, String password, Model model, HttpSession session){
        if (!StringUtils.isEmpty(username)&&"123456".equals(password)){
            session.setAttribute("username",username);
            return "redirect:/main.html";//防止表单重复提交
        }else {
            model.addAttribute("msg","用户名或者密码错误，请重新登陆");
            return "index";
        }
    }

    @PostMapping("/user/test")
    public String test(String username, String password, Model model){
            return "list";
    }
}
