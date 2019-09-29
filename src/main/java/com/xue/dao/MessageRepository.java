package com.xue.dao;


import com.xue.pojo.Message;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
public interface MessageRepository extends JpaRepository<Message,Long>{
//    int save(Message message);
//    List<Message> getAll();

}
