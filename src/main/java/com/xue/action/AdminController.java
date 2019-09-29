package com.xue.action;


import com.xue.pojo.Admin;
import com.xue.pojo.AdminInfo;
import com.xue.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminservice;


    @RequestMapping(value = "login")
    public String login(@RequestParam Map<String, Object> params, Model model, HttpServletRequest request){
        String username = (String) params.get("username");
        String password = (String) params.get("password");
        if(StringUtils.isEmpty(username) && StringUtils.isEmpty(password)){
            return "login";
        }
        String message = "";
        //查询
        Admin admin = adminservice.SelectByUsername(username);
        if(admin != null){
            if(password.equals(admin.getPassword())){
                request.getSession().setAttribute("user", admin.getUsername());
                return "index";
            }else{
                message = "密码错误";
            }
        }else{
            message = "用户名错误";
        }
        model.addAttribute("msg",message);
        return "login";
    }

    @RequestMapping(value = "userinfo")
    public String userinfo(){
        return "person";
    }

    @RequestMapping(value = "bannerupload")
    public String bannerupload(){
        return "index";
    }

    @RequestMapping(value = "messageView")
    public String messageView(){
        return "messages";
    }
    @RequestMapping(value = "personView")
    public ModelAndView personView(){

        ModelAndView modelAndView = new ModelAndView();
        AdminInfo adminInfo = new AdminInfo(null,null);
        modelAndView.addObject("adminInfo", adminInfo);
//        modelAndView.addObject("hintMessage", "初始化成功！");
        modelAndView.setViewName("person");

        return modelAndView;
    }

    @RequestMapping(value = "index")
    public String index(){
        return "index";
    }

}
