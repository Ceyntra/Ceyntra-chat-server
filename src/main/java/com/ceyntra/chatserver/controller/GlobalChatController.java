package com.ceyntra.chatserver.controller;

import com.ceyntra.chatserver.model.GlobalChatMessage;
import com.ceyntra.chatserver.repository.GlobalChatRepository;
import com.ceyntra.chatserver.service.GlobalChatMessageService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GlobalChatController {

    @Autowired
    private GlobalChatRepository repository;

    @Autowired
    private GlobalChatMessageService service;

    @MessageMapping("/message")
    @SendTo("/topic/globalchat")
    public GlobalChatMessage greeting(@RequestBody GlobalChatMessage message) throws Exception {
        //GlobalChatMessage(id=0, senderId=432, senderName=, content=fdfdfdsfdf, timestamp=null)
        System.out.println(message.toString());
        GlobalChatMessage message1=service.sendMessage(message);
        System.out.println(message1.toString());

      return message;
    }

    @GetMapping("/allmessages")
    public ArrayList<GlobalChatMessage>  getAllMessages(){
        Gson gson = new Gson();
        ArrayList<GlobalChatMessage> messages= (java.util.ArrayList<GlobalChatMessage>) repository.findAll();
        return messages;
    }






}
