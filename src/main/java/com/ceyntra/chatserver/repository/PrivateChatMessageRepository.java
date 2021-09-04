package com.ceyntra.chatserver.repository;

import com.ceyntra.chatserver.model.ChatMessage;
import com.ceyntra.chatserver.model.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PrivateChatMessageRepository extends JpaRepository<ChatMessage,Integer> {


    List<ChatMessage> findChatMessagesBySenderIdAndRecipientId(int senderId,int recipientId);

    @Query("from ChatMessage c where (c.recipientId=:user1 and c.senderId=:user2) OR c.recipientId=:user2 and c.senderId=:user1")
    List<ChatMessage> getChatMessagesByUsers(@Param("user1") int user1, @Param("user2") int user2);


    List<ChatMessage> getChatMessagesByChatRoom(ChatRoom chatRoom);

    @Query("select c from ChatMessage c where c.chatRoom=:chatRoom order by c.timestamp")
    ChatMessage getChatMessageByChatRoomID(ChatRoom chatRoom);



    ChatMessage getFirstByChatRoomOrderByTimestampDesc(ChatRoom chatRoom);

}
