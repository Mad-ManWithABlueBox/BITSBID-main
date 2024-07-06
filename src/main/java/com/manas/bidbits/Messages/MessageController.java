package com.manas.bidbits.Messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/messages")
public class MessageController {
    @Autowired
    private MessageService messageService;

    // Get all messages
    @GetMapping(path = "/")
    public Iterable<MessageModel> getAllMessages() {
        return messageService.getAllMessages();
    }

    // Get all messages for user
    @GetMapping(path = "/user")
    public Iterable<MessageModel> getAllMessagesForUser(@RequestParam Long userId) {
        return messageService.getMessagesForUser(userId);
    }

    // Get messages by product id
    @GetMapping(path = "/product")
    public Iterable<MessageModel> getMessagesByProductId(@RequestParam Long productId) {
        return messageService.getMessagesByProductId(productId);
    }

    // Send Message
    @PostMapping(path = "/")
    public MessageModel addMessage(@RequestBody MessageModel messageModel, @RequestParam Long productId, @RequestParam Long userId, @RequestParam Long receiverId) {
        return messageService.addMessage(messageModel, productId, userId, receiverId);
    }

    // Get messages by sender id
    @GetMapping(path = "/sender")
    public Iterable<MessageModel> getMessagesBySenderId(@RequestParam Long senderId) {
        return messageService.getMessagesBySenderId(senderId);
    }

    // Get messages by receiver id
    @GetMapping(path = "/receiver")
    public Iterable<MessageModel> getMessagesByReceiverId(@RequestParam Long receiverId) {
        return messageService.getMessagesByReceiverId(receiverId);
    }

    // Get Messages for highest bid
    @GetMapping(path = "/highestBid")
    public Object getMessagesByHighestBid(@RequestParam Long productId) {
        return messageService.getMessagesFromHighestBidder(productId);
    }

    // Get Messages for sender and product
    @GetMapping(path = "/senderAndProduct")
    public Iterable<MessageModel> getMessagesBySenderAndProduct(@RequestParam Long productId, @RequestParam Long senderId) {
        return messageService.getMessagesByProductAndSender(productId, senderId);
    }
}
