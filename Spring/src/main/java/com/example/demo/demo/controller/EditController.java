package com.example.demo.demo.controller;


import com.example.demo.demo.model.Product;
import com.example.demo.demo.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping
public class EditController {

    private ProductService productService;

    @GetMapping("/editProduct")
    public String ShowDeleteProductView(@RequestParam(name = "productCode") String code, Model model){
        System.out.println(code);
        Product product = productService.getProduct(code);
        model.addAttribute("product",product );
        return "editProduct";
    }

    @PostMapping("/edit")
    public String editProduct(@RequestParam(name = "productCode") String code, @RequestParam(name = "productDescription") String des, @RequestParam(name = "productPrice") String price){
        System.out.println("edit");
        productService.edit(code, des, price);
        return "redirect:/cart";
    }

}
