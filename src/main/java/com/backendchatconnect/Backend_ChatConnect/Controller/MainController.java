package com.backendchatconnect.Backend_ChatConnect.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backendchatconnect.Backend_ChatConnect.Util.ID;

@RestController
public class MainController {

    ID id = new ID();

    @GetMapping("/getId")
    public String getID(){
        return id.generateID();
    }
}
