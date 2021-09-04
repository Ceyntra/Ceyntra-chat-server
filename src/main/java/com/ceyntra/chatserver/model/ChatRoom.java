package com.ceyntra.chatserver.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "chatroom")
public class ChatRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int chatRoomId;
    private int senderId;
    private int recipientId;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chatRoom",targetEntity = ChatMessage.class,fetch = FetchType.LAZY)
    private Set<ChatMessage> chatMessageSet = new HashSet<ChatMessage>();



}