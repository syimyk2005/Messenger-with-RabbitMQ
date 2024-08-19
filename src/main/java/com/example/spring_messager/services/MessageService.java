package com.example.spring_messager.services;
import com.example.spring_messager.repositoryes.MessageRepository;
import com.example.spring_messager.repositoryes.UserRepository;
import com.example.spring_messager.models.Message;
import com.example.spring_messager.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserRepository userRepository;

    public Message sendMessage(Message message) {
        User sender = userRepository.findByUsername(message.getSender().getUsername());
        User recipient = userRepository.findByUsername(message.getRecipient().getUsername());

        if (sender == null || recipient == null) {
            throw new IllegalArgumentException("Sender or recipient not found");
        }

        message.setSender(sender);
        message.setRecipient(recipient);
        message.setTimestamp(LocalDateTime.now());

        messageRepository.save(message);

        return message;
    }

    public List<Message> getMessages(String username) {
        return messageRepository.findBySenderUsernameOrRecipientUsername(username, username);
    }
}
