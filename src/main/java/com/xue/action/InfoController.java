package com.xue.action;


import com.xue.common.config.CommonResult;
import com.xue.pojo.Admin;
import com.xue.pojo.AdminInfo;
import com.xue.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;



@RestController
@RequestMapping("/info")
public class InfoController {


    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/updatePassword",method = RequestMethod.POST)
    public ModelAndView updatePassword(HttpServletRequest request, AdminInfo adminInfo, BindingResult result){
        Admin admin = new Admin();
        ModelAndView mv = new ModelAndView();
        String user = (String) request.getSession().getAttribute("user");
//        校验原密码
        Admin adminInf = adminService.SelectByUsername(user);
        if(adminInf.getPassword().equals(adminInfo.getOldPassword())){
            try {
                admin.setUsername(user);
                admin.setPassword(adminInfo.getNewPassword());
                int count = adminService.updatePassword(admin);
                if(count>0){
                    mv.addObject("hintMessage", "修改成功！");
                }else{
                    mv.addObject("hintMessage", "修改失败！");
                }
            } catch (Exception e) {
//               LOGGER.error("原密码错误：{}",e.getMessage());
            }
        }else{
            mv.addObject("hintMessage", "旧密码错误！");
        }
        mv.setViewName("person");
        return mv;
    }


}
