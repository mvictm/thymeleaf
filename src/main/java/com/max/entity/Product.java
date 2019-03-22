package com.max.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Max
 */

@Data
@NoArgsConstructor
public class Product {
    private int id;
    private String name;
    private BigDecimal price;
    private boolean inStock;
    private List<Comment> commentList = new ArrayList<Comment>();

    public Product(int id, String name, boolean inStock, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.inStock = inStock;
    }
}
