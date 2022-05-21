package com.example.demo.demo.service;

import com.example.demo.demo.model.Product;
import com.example.demo.demo.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class ProductService {
    private ProductRepository productReposity;

    public void addProduct(String code, String des, String price) {
        Product product = new Product();
        product.setCode(code);
        product.setDescription(des);
        product.setPrice(Double.parseDouble(price));
        System.out.println(product);

        productReposity.save(product);

    }
    @Transactional
    public void delete(String code) {
        productReposity.deleteProductByCode(code);
    }

    public void edit(String code, String des, String price) {
        Product product = productReposity.findProductByCode(code);

        product.setCode(code);
        product.setDescription(des);
        product.setPrice(Double.parseDouble(price));
        System.out.println(product);

        productReposity.save(product);
    }

    public Product getProduct(String code) {
        return productReposity.findProductByCode(code);
    }
}
