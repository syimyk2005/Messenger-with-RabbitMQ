package com.example.spring_messager.repositoryes;
import com.example.spring_messager.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findBySenderUsernameOrRecipientUsername(String senderUsername, String recipientUsername);
}
