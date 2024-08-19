package com.example.spring_messager.listeners;
import com.example.spring_messager.models.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @RabbitListener(queues = "messenger-queue")
    public void receiveMessage(Message message) {
        // Handle received message
        System.out.println("Received message: " + message.getContent());
    }
}

