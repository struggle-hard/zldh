package com.xue.service;


import com.xue.pojo.Admin;

import java.util.Map;

public interface AdminService {



    /**
     * 登录功能
     * @param username 登录名
     * @param password 密码
     * @@return  用于生成jwt的token
     */
    String login(String username, String password);

    /**
     * 修改个人密码
     */
    int updatePassword(Admin admin);

    /**
     * 根据用户名获取用户信息
     */
    Admin SelectByUsername(String username);

    /**
     *
     * @param params
     * @return
     */
    Admin queryByparam(Map<String, Object> params);
}
