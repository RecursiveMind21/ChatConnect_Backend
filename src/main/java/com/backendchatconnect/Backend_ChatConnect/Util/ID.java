package com.backendchatconnect.Backend_ChatConnect.Util;

import java.security.SecureRandom;

public class ID {
    private final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private final int length = 8;
    private final SecureRandom random = new SecureRandom();

    public String generateID(){
        StringBuilder id = new StringBuilder(length);
        for(int i = 0; i<length; i++){
            int index = random.nextInt(chars.length());
            id.append(chars.charAt(index));
        }
        return id.toString();
    }
}
