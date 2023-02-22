package com.computerApi.Abramov.computerShop.model.DTO;

import com.computerApi.Abramov.computerShop.model.enums.ComputerType;
import com.computerApi.Abramov.computerShop.model.enums.LaptopType;
import com.computerApi.Abramov.computerShop.model.enums.Type;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductEditDto {
    private  String seriesNumber;
    private  String manufacturer;
    private  Long price;
    private  Long count;
    private Type type;
    private  Integer diagonal;
    private  Long amount;
    private ComputerType computerType;
    private LaptopType laptopType;

    public ProductEditDto() {
    }

    public ProductEditDto(String seriesNumber, String manufacturer, Long price, Long count, Type type, Integer diagonal, Long amount, ComputerType computerType, LaptopType laptopType) {
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
