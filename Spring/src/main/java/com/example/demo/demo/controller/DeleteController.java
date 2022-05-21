package com.example.demo.demo.controller;


import com.example.demo.demo.model.Product;
import com.example.demo.demo.repository.ProductRepository;
import com.example.demo.demo.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("")
@AllArgsConstructor
public class DeleteController {
    private ProductService productService;

    @GetMapping("/deleteProduct")
    public String ShowDeleteProductView(@RequestParam(name = "productCode") String code, Model model){
        System.out.println(code);
        Product product = productService.getProduct(code);
        model.addAttribute("product",product );
        return "deleteProduct";
    }

    @PostMapping("/delete")
    public String editProduct(@RequestParam(name = "code") String code){
        productService.delete(code);
        return "redirect:/cart";
    }

}
