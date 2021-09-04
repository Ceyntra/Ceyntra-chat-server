package com.ceyntra.chatserver.controller;

import com.ceyntra.chatserver.model.ChatMessage;
import com.ceyntra.chatserver.model.ChatRoom;
import com.ceyntra.chatserver.repository.ChatRoomRepository;
import com.ceyntra.chatserver.repository.PrivateChatMessageRepository;
import com.ceyntra.chatserver.service.PrivateChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Set;

@RestController
public class PrivateChatController {

    @Autowired
    private PrivateChatService privateChatService;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private PrivateChatMessageRepository privateChatMessageRepository;


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

    @GetMapping("/messages/{senderId}/{recipientId}")
    public List<ChatMessage> getChatMessagesByRoom(@PathVariable("senderId") int senderId, @PathVariable("recipientId") int recipientId){

        System.out.println(""+senderId+"-"+recipientId);

        return privateChatService.getChatMessagesByUserIds(senderId, recipientId);
    }

}
