package com.xue.pojo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AdminInfo {
    private String oldPassword;
    private String newPassword;

    public AdminInfo(String oldPassword,String newPassword){
        this.oldPassword=oldPassword;
        this.newPassword=newPassword;
    }

}
