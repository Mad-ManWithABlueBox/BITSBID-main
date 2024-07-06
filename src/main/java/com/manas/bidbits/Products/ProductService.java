package com.manas.bidbits.Products;

import com.manas.bidbits.Bids.BidModel;
import com.manas.bidbits.Bids.BidRepository;
import com.manas.bidbits.Users.UserModel;
import com.manas.bidbits.Users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BidRepository bidRepository;

    @Autowired
    private UserRepository userRepository;

    // Create
    public ProductModel addProduct(ProductModel productModel, Long userId) {
        UserModel userModel = userRepository.findById(userId).orElse(null);
        assert userModel != null;
        productModel.setUser(userModel);
        return productRepository.save(productModel);
    }

    // Read
    public ProductModel getProductById(Long productId) {
        return productRepository.findById(productId).orElse(null);
    }

    public Iterable<ProductModel> getProductsByUserId(Long userId) {
        UserModel userModel = userRepository.findById(userId).orElse(null);
        assert userModel != null;
        return productRepository.findAllByUser(userModel);
    }

    // Update
    public ProductModel updateProduct(ProductModel productModel) {
        ProductModel existingProduct = productRepository.findById(productModel.getProductId()).orElse(null);
        assert existingProduct != null;
        existingProduct.setProductName(productModel.getProductName());
        existingProduct.setImage(productModel.getImage());
        existingProduct.setDetails(productModel.getDetails());
        existingProduct.setCategory(productModel.getCategory());
        existingProduct.setUser(productModel.getUser());
        existingProduct.setStartingBid(productModel.getStartingBid());
        return productRepository.save(existingProduct);
    }

    // Delete
    public String deleteProduct(Long productId) {
        productRepository.deleteById(productId);
        return "Product removed !! " + productId;
    }

    // Get all
    public Iterable<ProductModel> getAllProducts() {
        // Find the products that are not sold
        List<ProductModel> products = productRepository.findAllBy();
        products.removeIf(ProductModel::isSold);
        return products;
    }

    // Get by category
    public Iterable<ProductModel> getProductsByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    // Get featured products
    // Find the top 3 products with maximum number of bids
    public Iterable<ProductModel> getFeaturedProducts() {
        List<BidModel> bids = bidRepository.findAllBy();
        HashMap<Long, Integer> productBids = new HashMap<>();
        for (BidModel bid : bids) {
            Long productId = bid.getProduct().getProductId();
            if (productBids.containsKey(productId)) {
                productBids.put(productId, productBids.get(productId) + 1);
            } else {
                productBids.put(productId, 1);
            }
        }
        List<ProductModel> products = productRepository.findAllBySold(false);
        products.sort((o1, o2) -> {
            Integer o1Bids = productBids.get(o1.getProductId());
            Integer o2Bids = productBids.get(o2.getProductId());
            if (o1Bids == null) {
                o1Bids = 0;
            }
            if (o2Bids == null) {
                o2Bids = 0;
            }
            return o2Bids.compareTo(o1Bids);
        });
        return products.subList(0, Math.min(3, products.size()));
    }
}
