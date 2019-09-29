package com.xue.service.impl;


import com.xue.dao.AdminDao;
import com.xue.pojo.Admin;
import com.xue.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;

    @Override
    public String login(String username, String password) {
        return null;
    }

    @Override
    public int updatePassword(Admin admin) {
        return adminDao.updatePassword(admin);
    }

    @Override
    public Admin SelectByUsername(String username) {
        return adminDao.SelectByUsername(username);
    }

    @Override
    public Admin queryByparam(Map<String, Object> params) {
        return null;
    }
}
