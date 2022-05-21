package com.example.demo.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.text.NumberFormat;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product  {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;
    private String description;
    private double price;


	@Override
    public String toString() {
        return String.format("%s|%s|%s", code, description, price);
    }

}
