package com.example.client;

import com.example.model.Product;
import com.example.service.ProductService;
import com.example.service.impl.ProductServiceImpl;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductService productService = new ProductServiceImpl();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nProduct Management System");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Get Product");
            System.out.println("5. Get All Products");
            System.out.println("6. Get Products By Price Range");
            System.out.println("7. Get Products By Brand");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID: ");
                    int addId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter Product Name: ");
                    String addName = scanner.nextLine();
                    System.out.print("Enter Product Price: ");
                    double addPrice = scanner.nextDouble();
                    System.out.print("Enter Product Quantity: ");
                    int addQuantity = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter Product Brand: ");
                    String addBrand = scanner.nextLine();
                    System.out.print("Enter Product Category: ");
                    String addCategory = scanner.nextLine();
                    productService.addProduct(new Product(addId, addName, addPrice, addQuantity, addBrand, addCategory));
                    System.out.println("Product added successfully!");
                    break;
                case 2:
                    System.out.print("Enter Product ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter new Product Name: ");
                    String updateName = scanner.nextLine();
                    System.out.print("Enter new Product Price: ");
                    double updatePrice = scanner.nextDouble();
                    System.out.print("Enter new Product Quantity: ");
                    int updateQuantity = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter new Product Brand: ");
                    String updateBrand = scanner.nextLine();
                    System.out.print("Enter new Product Category: ");
                    String updateCategory = scanner.nextLine();
                    productService.updateProduct(new Product(updateId, updateName, updatePrice, updateQuantity, updateBrand, updateCategory));
                    System.out.println("Product updated successfully!");
                    break;
                case 3:
                    System.out.print("Enter Product ID to delete: ");
                    int deleteId = scanner.nextInt();
                    productService.deleteProduct(deleteId);
                    System.out.println("Product deleted successfully!");
                    break;
                case 4:
                    System.out.print("Enter Product ID to fetch: ");
                    int getId = scanner.nextInt();
                    Product product = productService.getProduct(getId);
                    System.out.println("Product details: " + product);
                    break;
                case 5:
                    List<Product> products = productService.getAllProducts();
                    System.out.println("All Products:");
                    products.forEach(System.out::println);
                    break;
                case 6:
                    System.out.print("Enter minimum price: ");
                    double minPrice = scanner.nextDouble();
                    System.out.print("Enter maximum price: ");
                    double maxPrice = scanner.nextDouble();
                    List<Product> productsByPriceRange = productService.getProductsByPriceRange(minPrice, maxPrice);
                    System.out.println("Products in price range:");
                    productsByPriceRange.forEach(System.out::println);
                    break;
                case 7:
                    System.out.print("Enter brand name: ");
                    String brand = scanner.nextLine();
                    List<Product> productsByBrand = productService.getProductsByBrand(brand);
                    System.out.println("Products by brand:");
                    productsByBrand.forEach(System.out::println);
                    break;
                case 8:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}
