package com.manas.bidbits.Messages;

import com.manas.bidbits.Products.ProductModel;
import com.manas.bidbits.Users.UserModel;
import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
@Table(name = "messages")
public class MessageModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private Long messageId;

    @Column(name="timestamp")
    private String timestamp;

    @Column(name = "message")
    private String message;

    @ManyToOne(targetEntity = UserModel.class)
    @JoinColumn(name = "sender_id", referencedColumnName = "user_id")
    private UserModel sender;

    @ManyToOne(targetEntity = UserModel.class)
    @JoinColumn(name = "receiver_id", referencedColumnName = "user_id")
    private UserModel receiver;

    @ManyToOne(targetEntity = ProductModel.class)
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private ProductModel product;

    public MessageModel() {
    }

    public MessageModel(String message, UserModel sender, ProductModel product) {
        this.message = message;
        this.sender = sender;
        this.product = product;
    }

    public Long getMessageId() {
        return messageId;
    }

    public String getMessage() {
        return message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
    public void setReceiver(UserModel receiver) {
        this.receiver = receiver;
    }

    public UserModel getReceiver() {
        return receiver;
    }

    public UserModel getSender() {
        return sender;
    }

    public void setSender(UserModel sender) {
        this.sender = sender;
    }

    public ProductModel getProduct() {
        return product;
    }

    public void setProduct(ProductModel product) {
        this.product = product;
    }
}
