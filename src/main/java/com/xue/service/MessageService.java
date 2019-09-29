package com.xue.service;


import com.xue.pojo.Message;
import org.springframework.data.domain.Page;

public interface MessageService {
    void save(Message message);

    Page<Message> getMsgList(int pageNum, int pageSize);
}
