package com.backendchatconnect.Backend_ChatConnect.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    String makeID(String name) {
        return String.valueOf(Math.abs(name.hashCode()));
    }

    @GetMapping("/getId/{name}")
    public String getID(@PathVariable String name){
        return makeID(name);
    }
}
