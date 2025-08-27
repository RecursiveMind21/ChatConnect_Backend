package com.ChatConnect.backend.controller;

import com.ChatConnect.backend.dto.ConnectionRequest;
import com.ChatConnect.backend.dto.MessageRequest;
import com.ChatConnect.backend.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    UserService userService = new UserService();

    @GetMapping("/getId")
    public String getId(){
        return userService.handleGenerateID();
    }

    @GetMapping("/connect/{id}")
    public String recieveConnection(@PathVariable String id,@RequestBody ConnectionRequest req){
        userService.handleIncomingConnectionRequest(id,req.getName());
        return "Received connection request from " + req.getName();
    }

    @PostMapping("/connect/{id}")
    public String sendConnection(@PathVariable String id,@RequestBody ConnectionRequest req){
        userService.handleOutgoingConnectionRequest(id,req.getName());
        return "Connection sent to " + id + " by " + req.getName();
    }

    @PostMapping("/chat")
    public String sendMessage(@RequestBody MessageRequest request){
        return userService.handleMessageSend(request);
    }

    @GetMapping("/chat/{id}")
    public ArrayList<String> getMessages(@PathVariable String id){
        return userService.handleMessageRequest(id);
    }


}
