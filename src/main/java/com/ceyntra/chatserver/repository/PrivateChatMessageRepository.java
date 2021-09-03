package com.ceyntra.chatserver.repository;

import com.ceyntra.chatserver.model.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivateChatMessageRepository extends JpaRepository<ChatMessage,Integer> {
}
