package com.example.dao.impl;

import com.example.dao.ProductDAO;
import com.example.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductDAOImpl implements ProductDAO {
    private List<Product> productList = new ArrayList<>();

    @Override
    public void addProduct(Product product) {
        productList.add(product);
    }

    @Override
    public void updateProduct(Product product) {
        for (Product p : productList) {
            if (p.getProductId() == product.getProductId()) {
                p.setProductName(product.getProductName());
                p.setProductPrice(product.getProductPrice());
                p.setQuantity(product.getQuantity());
                p.setBrand(product.getBrand());
                p.setCategory(product.getCategory());
            }
        }
    }

    @Override
    public void deleteProduct(int productId) {
        productList.removeIf(p -> p.getProductId() == productId);
    }

    @Override
    public Product getProduct(int productId) {
        return productList.stream().filter(p -> p.getProductId() == productId).findFirst().orElse(null);
    }

    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>(productList);
    }

    @Override
    public List<Product> getProductsByPriceRange(double minPrice, double maxPrice) {
        return productList.stream()
                .filter(p -> p.getProductPrice() >= minPrice && p.getProductPrice() <= maxPrice)
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> getProductsByBrand(String brand) {
        return productList.stream()
                .filter(p -> p.getBrand().equalsIgnoreCase(brand))
                .collect(Collectors.toList());
    }
}
