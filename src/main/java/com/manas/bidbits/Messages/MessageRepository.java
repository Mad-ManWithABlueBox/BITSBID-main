package com.manas.bidbits.Messages;

import com.manas.bidbits.Products.ProductModel;
import com.manas.bidbits.Users.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<MessageModel, Long> {


    public Iterable<MessageModel> findAllByProductId(Long productId);

    Iterable<MessageModel> findAllBySender(UserModel sender);

    Iterable<MessageModel> findAllByProduct(ProductModel product);

    Iterable<MessageModel> findAllByProductAndSender(ProductModel product, UserModel sender);

    Iterable<MessageModel> findAllByProductAndReceiver(ProductModel product, UserModel receiver);

    Iterable<MessageModel> findAllByReceiver(UserModel user);
}
