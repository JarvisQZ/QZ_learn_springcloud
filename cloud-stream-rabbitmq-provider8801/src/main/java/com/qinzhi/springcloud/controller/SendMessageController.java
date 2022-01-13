package com.qinzhi.springcloud.controller;

import com.qinzhi.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SendMessageController {

    @Resource
    IMessageProvider messageProvider;

    @GetMapping(value = "/sendMessage")
    public String sengMessage() {
        return messageProvider.send();
    }
}
