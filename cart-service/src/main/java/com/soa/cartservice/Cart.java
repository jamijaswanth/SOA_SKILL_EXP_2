package com.soa.cartservice;

import java.util.List;

public class Cart {

    private int userId;
    private List<Integer> productIds;

    public Cart(int userId, List<Integer> productIds) {
        this.userId = userId;
        this.productIds = productIds;
    }

    public int getUserId() {
        return userId;
    }

    public List<Integer> getProductIds() {
        return productIds;
    }
}