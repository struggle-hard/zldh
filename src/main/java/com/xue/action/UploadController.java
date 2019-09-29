package com.xue.action;

import com.xue.util.Appconst;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/upload")
public class UploadController {

    @RequestMapping(value = "/banners")
    @ResponseBody
    public Map<String,Object> uploadPic(HttpServletRequest request, @RequestParam("file") MultipartFile file, @RequestParam Map<String, Object> params){
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            String bannername = (String) params.get("bannername");
            /*String fileName = Appconst.uploadFile(request, file, bannername);*/  //真正像上传的时候可以放开
            result.put("ok",true);
            result.put("msg","上传成功");

        } catch (Exception e) {
            e.printStackTrace();
            result.put("ok",false);
            result.put("msg","上传失败");
        }
        return result;
    }
}
