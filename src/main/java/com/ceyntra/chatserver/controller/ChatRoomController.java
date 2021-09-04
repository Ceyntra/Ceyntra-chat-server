package com.ceyntra.chatserver.controller;

import com.ceyntra.chatserver.model.ChatRoom;
import com.ceyntra.chatserver.model.MessageChatRoomModel;
import com.ceyntra.chatserver.repository.PrivateChatMessageRepository;
import com.ceyntra.chatserver.service.ChatRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChatRoomController {

    @Autowired
    private ChatRoomService chatRoomService;


    @GetMapping("/chatroom/{userId}")
    public List<MessageChatRoomModel> getChatRoomsByuserId(@PathVariable("userId") int userId){

        System.out.println(userId);

        List<MessageChatRoomModel> models= chatRoomService.getChatRoomsByuserId(userId);

        return models;
    }





}
