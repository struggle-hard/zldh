package com.xue.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Setter
@Getter
@Entity
public class Message implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name ="username")
    private String username;

    @Column(name = "phone")
    private String phone;

    @Column(name = "content")
    private String content;

    public Message(Integer id, String username, String phone, String content) {
        this.id = id;
        this.username = username;
        this.phone = phone;
        this.content = content;
    }
    public Message(){

    }
}
