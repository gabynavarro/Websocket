package com.websocket.websocket.controller;

import com.websocket.websocket.dto.MessageDto;
import com.websocket.websocket.service.SocketService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
@RequiredArgsConstructor
public class MessageController {
    private final SocketService socketService;

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public MessageDto sendMessage(MessageDto message, @Header("simpSessionId") String sessionId) throws InterruptedException {
        Thread.sleep(1000); // simulated delay
        socketService.saveSession(sessionId, message.getName());
        return new MessageDto("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
      //  return new MessageDto("Message with text : "+" from " + message.getName());
    }
}
