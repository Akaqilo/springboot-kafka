package com.czr.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.czr.entity.User;
import com.czr.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Value("${spring.kafka.topic.userTopic}")
    private String userTopic;

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Override
    public Boolean sendUserMsg() {
        System.out.println("----------------------------");
        System.out.println(userTopic);
        System.out.println("----------------------------");
        List<User> list = new ArrayList<>();
        User user1 = new User();
        user1.setId(1);
        user1.setUsername("czr1");
        user1.setPassword("543900");
        User user2 = new User();
        user2.setId(2);
        user2.setUsername("czr2");
        user2.setPassword("543900");
        list.add(user1);
        list.add(user2);
        kafkaTemplate.send(userTopic, JSONObject.toJSONString(list));
        return Boolean.TRUE;
    }
}
