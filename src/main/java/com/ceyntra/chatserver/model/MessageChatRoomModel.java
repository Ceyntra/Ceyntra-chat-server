package com.ceyntra.chatserver.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MessageChatRoomModel {

    private ChatRoom chatRoom;
    private int travellerId;
    private String travellerName;
    private String imageUrl;
    private ChatMessage lastMessage;
    private boolean isActive;


}
