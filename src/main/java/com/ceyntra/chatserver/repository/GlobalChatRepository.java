package com.ceyntra.chatserver.repository;

import com.ceyntra.chatserver.model.GlobalChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GlobalChatRepository extends JpaRepository<GlobalChatMessage,Integer> {
}
