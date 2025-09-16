package de.neuefische.java.nfjavaonl200825spring.messages;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private List<Message> messages = new ArrayList<>();

    @GetMapping
    public List<Message> getAllMessages() {
        return messages;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Message addMessage(@RequestBody Message newMessage) {
        System.out.println(newMessage);
        messages.add(newMessage);
        return newMessage;
    }

    @DeleteMapping("/{id}")
    public void deleteMessage(@PathVariable String id) {
        System.out.println("Delete Message: " + id);
        messages = messages.stream()
                .filter(m -> !m.id().equals(id))
                .toList();

//        return "Message with id: " + id + " successfully deleted.";
    }
}
