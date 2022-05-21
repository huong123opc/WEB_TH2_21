package com.example.demo.demo.controller;

import com.example.demo.demo.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/addProduct")
@AllArgsConstructor
public class AddController {
    private ProductService addProductService;

    @GetMapping
    public String AddProductView() {
        System.out.println("bg");
        return "addProduct";
    }

    @PostMapping
    public void AddProduct(
            @RequestParam(value = "productCode", required = false) String code,
            @RequestParam(value = "productDescription", required = false) String des,
            @RequestParam(value = "productPrice", required = false) String price
        ) {

        addProductService.addProduct(code,des,price);
    }
}
