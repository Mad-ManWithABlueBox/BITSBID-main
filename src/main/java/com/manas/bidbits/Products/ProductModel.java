package com.manas.bidbits.Products;

import com.manas.bidbits.Users.UserModel;
import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", insertable = false, updatable = false)
    private Long id;
    @Column(name = "product_name")
    private String productName;

    @Column(name = "image")
    private String image;

    @Column(name = "details")
    private String details;

    @Column(name = "category")
    private String category;

    @ManyToOne(targetEntity = UserModel.class)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private UserModel user;

    @Column(name = "starting_bid")
    private int startingBid;

    @Column(name = "sold", columnDefinition = "boolean default false")
    private boolean sold;

    public boolean getSold() {
        return this.sold;
    }

    public void setStartingBid(int startingBid) {
        this.startingBid = startingBid;
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

    public int getStartingBid() {
        return startingBid;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public UserModel getUser() {
        return user;
    }

    public Long getUserId() {
        return user.getUserId();
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getDetails() {
        return details;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public Long getProductId() {
        return id;
    }

}
