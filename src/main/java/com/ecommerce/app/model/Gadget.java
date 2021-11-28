package com.ecommerce.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "gadgets")
public class Gadget {

    @Id
    private Integer id;

    private String brand;

    private String category;

    private String name;

    private  String description;

    private double price;

    private  boolean availability = true;

    private int quantity;

    private String photography;
}
