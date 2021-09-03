package com.example.chat.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "chatroom")
public class ChatRoom {
    @Id
    private int id;
    private String chatId;
    private String senderId;
    private String recipientId;
}