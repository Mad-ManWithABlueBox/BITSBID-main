package com.manas.bidbits.Products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/v1/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    // Create
    @PostMapping(path = "/")
    public ProductModel addProduct(@RequestBody ProductModel productModel, @RequestParam Long userId) {
        return productService.addProduct(productModel, userId);
    }

    // Read
    @GetMapping(path = "/")
    public ProductModel getProductById(@RequestParam Long productId) {
        return productService.getProductById(productId);
    }

    @GetMapping(path = "/user")
    public Iterable<ProductModel> getProductsByUserId(@RequestParam Long userId) {
        return productService.getProductsByUserId(userId);
    }

    // Update
    @PostMapping(path = "/update")
    public ProductModel updateProduct(@RequestBody ProductModel productModel) {
        return productService.updateProduct(productModel);
    }

    // Delete
    @DeleteMapping(path = "/")
    public String deleteProduct(@RequestParam Long productId) {
        return productService.deleteProduct(productId);
    }

    // Get all
    @GetMapping(path = "/list")
    public Iterable<ProductModel> getAllProducts() {
        return productService.getAllProducts();
    }

    // Get by category
    @GetMapping(path = "/listByCategory")
    public Iterable<ProductModel> getProductsByCategory(@RequestParam String category) {
        return productService.getProductsByCategory(category);
    }

    @GetMapping(path = "/featured")
    public Iterable<ProductModel> getFeaturedProducts() {
        return productService.getFeaturedProducts();
    }
}
