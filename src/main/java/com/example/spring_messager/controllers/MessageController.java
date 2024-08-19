package com.example.spring_messager.controllers;
import com.example.spring_messager.services.MessageService;
import com.example.spring_messager.models.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/send")
    public Message sendMessage(@RequestBody Message message) {
        return messageService.sendMessage(message);
    }

    @GetMapping("/{username}")
    public List<Message> getMessages(@PathVariable String username) {
        return messageService.getMessages(username);
    }
}
