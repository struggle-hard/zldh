package com.xue.dao;


import com.xue.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminDao {
    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    Admin SelectByUsername(String username);

    int updatePassword(Admin admin);

}
