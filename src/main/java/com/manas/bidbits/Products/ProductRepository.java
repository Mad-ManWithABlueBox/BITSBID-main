package com.manas.bidbits.Products;

import com.manas.bidbits.Users.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Long> {
    List<ProductModel> findByCategory(String category);

    Optional<ProductModel> findByProductName(String productName);

    List<ProductModel> findByProductNameContaining(String productName);

    List<ProductModel> findAllBy();

    List<ProductModel> findAllBySold(boolean sold);

    Iterable<ProductModel> findAllByUser(UserModel userModel);
}
