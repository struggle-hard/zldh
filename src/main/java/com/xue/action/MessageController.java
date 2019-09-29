package com.xue.action;

import com.xue.common.config.CommonResult;
import com.xue.pojo.Message;
import com.xue.service.MessageService;
import com.xue.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

//    @RequestMapping(value = "/saveMessage",method = RequestMethod.GET)
//    @ResponseBody
//    public CommonResult saveMessage(@RequestBody Message message){
//         messageService.save(message);
//        if(count>0){
//            return CommonResult.success(count);
//        }
//        return CommonResult.failed();
//    }


    @RequestMapping(value = "/list")
    public String showMessage( @RequestParam(value = "pageNum", defaultValue = "0") int pageNum, @RequestParam(value = "pageSize", defaultValue = "2") int pageSize, Model model){
        System.out.println("============================");
        Page<Message> msgs=messageService.getMsgList(pageNum, pageSize);
        System.out.println("总页数" + msgs.getTotalPages());
        System.out.println("当前页是：" + pageNum);

        System.out.println("分页数据：");
        Iterator<Message> u = msgs.iterator();
        while (u.hasNext()){

            System.out.println(u.next().toString());
        }
        model.addAttribute("msgs", msgs);

        return "messages";
    }
}
