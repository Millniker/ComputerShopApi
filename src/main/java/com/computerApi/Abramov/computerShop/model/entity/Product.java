package com.computerApi.Abramov.computerShop.model.entity;

import com.computerApi.Abramov.computerShop.model.enums.ComputerType;
import com.computerApi.Abramov.computerShop.model.enums.LaptopType;
import com.computerApi.Abramov.computerShop.model.enums.Type;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String seriesNumber;
    private String manufacturer;
    private Long price;
    private Long count;
    @Enumerated(EnumType.STRING)
    private Type type;
    private Integer diagonal;
    private Long amount;
    @Enumerated(EnumType.STRING)
    private ComputerType computerType;
    @Enumerated(EnumType.STRING)
    private LaptopType laptopType;
    public Product() {
    }

    public Product(String seriesNumber, String manufacturer, Long price, Long count, Type type, Integer diagonal, Long amount, ComputerType computerType, LaptopType laptopType) {
        this.seriesNumber = seriesNumber;
        this.manufacturer = manufacturer;
        this.price = price;
        this.count = count;
        this.type = type;
        this.diagonal = diagonal;
        this.amount = amount;
        this.computerType = computerType;
        this.laptopType = laptopType;
    }
}
