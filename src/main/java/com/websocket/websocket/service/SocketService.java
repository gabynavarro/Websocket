package com.websocket.websocket.service;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class SocketService {
    private Map<String, String> nameSession = new HashMap<>();

    public String getNameBySession(String session) {
        return nameSession.get(session);
    }

    public void saveSession(String sessionId, String name) {
        nameSession.put(sessionId, name);
        System.out.println(nameSession);
    }

    public void removeSession(String sessionId) {
        nameSession.remove(sessionId);
    }
}
