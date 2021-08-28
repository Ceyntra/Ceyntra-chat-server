package com.ceyntra.chatserver.service;

import com.ceyntra.chatserver.model.GlobalChatMessage;
import com.ceyntra.chatserver.model.Traveller;
import com.ceyntra.chatserver.repository.GlobalChatRepository;
import com.ceyntra.chatserver.repository.TravelarRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@NoArgsConstructor
@Service
public class GlobalChatMessageService {

    @Autowired
   private TravelarRepository travelarRepository;

    @Autowired
    private GlobalChatRepository chatRepository;


    public GlobalChatMessage sendMessage(GlobalChatMessage message){

        //Get travelar details
        Traveller travelarModel=travelarRepository.findByTraveller_id(message.getSenderId());

        message.setSenderName(travelarModel.getFirst_name());
        message.setTimestamp(new Date());

        //Save on database
        GlobalChatMessage msg=chatRepository.save(message);

        return message;
    }


}
