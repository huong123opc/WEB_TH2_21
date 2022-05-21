package com.example.demo.demo.controller;

import com.example.demo.demo.model.Product;
import com.example.demo.demo.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/cart")
public class CartController {
    private ProductRepository productRepository;

    @GetMapping()
    public String GetAllProduct(Model model) {
        List<Product> products = productRepository.findAll();
        products.forEach(System.out::println);

        model.addAttribute("products",products);

        return "cart";
    }
}
