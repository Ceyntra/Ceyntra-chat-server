package com.ceyntra.chatserver.controller;

import com.ceyntra.chatserver.model.ChatMessage;
import com.ceyntra.chatserver.model.ChatRoom;
import com.ceyntra.chatserver.repository.ChatRoomRepository;
import com.ceyntra.chatserver.service.PrivateChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrivateChatController {

    @Autowired
    private PrivateChatService privateChatService;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;


    @MessageMapping("/chat")
    public ChatMessage processMessage(@Payload ChatMessage chatMessage) {

        System.out.println(chatMessage.toString());

        //Save on database
       ChatMessage saved = privateChatService.saveMessages(chatMessage);

       //send to subscriber
        messagingTemplate.convertAndSendToUser(
                chatMessage.getRecipientId()+"","/queue/messages",
                saved);

        return saved;
    }

    

}
