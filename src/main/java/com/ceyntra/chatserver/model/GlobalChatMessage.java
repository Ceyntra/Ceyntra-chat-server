package com.ceyntra.chatserver.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "globalChatMessage")
public class GlobalChatMessage {

    @Id
    private int id;
    private int senderId;
    private String senderName;
    private String content;
    private Date timestamp;


}
