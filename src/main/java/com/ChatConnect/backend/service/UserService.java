package com.ChatConnect.backend.service;

import com.ChatConnect.backend.dto.MessageRequest;
import com.ChatConnect.backend.repository.UserRepository;
import com.ChatConnect.backend.utility.IdGenerator;

import java.util.ArrayList;

public class UserService {

    UserRepository userRepository = new UserRepository();

    public String handleGenerateID(){
        return IdGenerator.generateRandomId();
    }

    public String handleMessageSend( MessageRequest request){
        String user_id = request.getUser_id();
        String message = request.getMessage();

        userRepository.chats.computeIfAbsent(user_id, k -> new ArrayList<>());
        userRepository.chats.get(user_id).add(message);

        return "Message " + message + " from user " + user_id;
    }

    public ArrayList<String> handleMessageRequest(String id){
        if(userRepository.chats.containsKey(id)){
            return userRepository.chats.get(id);
        } else {
            ArrayList<String> chat = new ArrayList<>();
            chat.add("No User Found");
            return chat;
        }
    }

    public void handleIncomingConnectionRequest(String id,String name){

    }

    public void handleOutgoingConnectionRequest(String id,String name){

    }
}
