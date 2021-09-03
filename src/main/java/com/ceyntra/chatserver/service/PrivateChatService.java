package com.ceyntra.chatserver.service;

import com.ceyntra.chatserver.model.ChatMessage;
import com.ceyntra.chatserver.model.ChatRoom;
import com.ceyntra.chatserver.repository.ChatRoomRepository;
import com.ceyntra.chatserver.repository.PrivateChatMessageRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@NoArgsConstructor
@Service
public class PrivateChatService {

    @Autowired
    private ChatRoomRepository chatRoomRepository;

    @Autowired
    private PrivateChatMessageRepository messageRepository;


    public ChatMessage saveMessages(ChatMessage message){

        //Get the chat room for users
        ChatRoom chatRoom=chatRoomRepository.getChatRoomByUsers(message.getSenderId(),message.getRecipientId());

        if(chatRoom == null){
            //Create a chat room
            System.out.println("No chat room. Create a new one");

            chatRoom=new ChatRoom();
            chatRoom.setSenderId(message.getSenderId());
            chatRoom.setRecipientId(message.getRecipientId());
            chatRoom=chatRoomRepository.save(chatRoom);
        }

        //Complete the Chat MessageModel
        message.setChatRoom(chatRoom);

        ChatMessage msg=messageRepository.save(message);

        return msg;
    }


    public ChatRoom getChatRoomByUsers(ChatMessage message){
        System.out.println(message.getSenderId()+"-"+message.getRecipientId());

        return chatRoomRepository.getChatRoomByUsers(message.getSenderId(),message.getRecipientId());
        //return null;
    }

    public ChatRoom getChatRoomByIds(ChatMessage message){

        return chatRoomRepository.getById(1);

    }




}
