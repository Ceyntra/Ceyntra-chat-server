package com.ceyntra.chatserver.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chatRoom",fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<ChatMessage> chatMessageSet = new HashSet<>();


}