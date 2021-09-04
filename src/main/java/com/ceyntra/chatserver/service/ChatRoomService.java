package com.ceyntra.chatserver.service;

import com.ceyntra.chatserver.model.ChatRoom;
import com.ceyntra.chatserver.model.MessageChatRoomModel;
import com.ceyntra.chatserver.model.Traveller;
import com.ceyntra.chatserver.repository.ChatRoomRepository;
import com.ceyntra.chatserver.repository.PrivateChatMessageRepository;
import com.ceyntra.chatserver.repository.TravelarRepository;
import com.ceyntra.chatserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ChatRoomService {

    @Autowired
    private ChatRoomRepository chatRoomRepository;

    @Autowired
    private TravelarRepository travelarRepository;

    @Autowired
    private PrivateChatMessageRepository privateChatMessageRepository;

    @Autowired
    private UserRepository userRepository;


    public List<MessageChatRoomModel> getChatRoomsByuserId(int userId){

        List<ChatRoom> chatRooms=chatRoomRepository.findChatRoomByUserId(userId);

        List<MessageChatRoomModel> messageChatRoomModels= new ArrayList<>();

        chatRooms.forEach(
                chatRoom -> {
                    int id;
                    MessageChatRoomModel messageChatRoomModel=new MessageChatRoomModel();

                    if(chatRoom.getSenderId() != userId){
                        //Sender
                        id=chatRoom.getSenderId();
                    }else {
                        //Recipient
                        id=chatRoom.getRecipientId();
                    }

                    System.out.println("Traveller id :"+ id);

                    //Set chat Room
                    messageChatRoomModel.setChatRoom(chatRoom);

                    //Set travalar Id
                    messageChatRoomModel.setTravellerId(id);

                    //Get traveller by id
                    Traveller traveller=travelarRepository.findByTraveller_id(id);

                    //Set image, traveller name
                    messageChatRoomModel.setImageUrl(traveller.getProfile_photo());
                    messageChatRoomModel.setTravellerName(traveller.getFirst_name()+" "+ traveller.getLast_name());

                    //Get user logging status
                    messageChatRoomModel.setActive(userRepository.getLoginStatusByUserId(id) == 1 ? true : false);

                    //Set latest message
                    messageChatRoomModel.setLastMessage(privateChatMessageRepository.getFirstByChatRoomOrderByTimestampDesc(chatRoom));

                    //add to the model list
                    messageChatRoomModels.add(messageChatRoomModel);
                }
        );



        return messageChatRoomModels;
    }


}
