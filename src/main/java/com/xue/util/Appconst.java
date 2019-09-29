package com.xue.util;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 常量类
 */
public class Appconst {
    public static String uploadPath = "http://localhost:8082/upload/imgs/";

    /**
     * 获取32位uuid
     * @return
     */
    public static String uuid(){
        String uuid = UUID.randomUUID().toString().replace("-","");
        return uuid;
    }

    /**
     * 上传图片
     * @param request
     * @param file
     * @return
     * @throws IOException
     */
    public static String uploadFile(HttpServletRequest request, MultipartFile file, String bannername) throws IOException {
       /*String uploadPath = request.getSession().getServletContext().getRealPath("/");*/
        String c = System.getProperty("user.dir");
        String uploadPath = c + "\\src\\main\\resources\\static\\zldh\\images\\";
        return mkFile(uploadPath, file, bannername);
    }

    public static String mkFile(String filePath, MultipartFile file, String bannername) throws IOException {
        File dir = new File(filePath);
        if(!dir.exists()){
            dir.mkdir();
        }
        String OriginalFileName = file.getOriginalFilename();
        String fileSuffix = OriginalFileName.substring(OriginalFileName.lastIndexOf("."), OriginalFileName.length());
        String fileName = bannername + fileSuffix;
        File newFile = new File(filePath + fileName);
        file.transferTo(newFile);
        return fileName;
    }
}
