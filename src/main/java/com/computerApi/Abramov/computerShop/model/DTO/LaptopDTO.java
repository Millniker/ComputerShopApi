package com.computerApi.Abramov.computerShop.model.DTO;

import com.computerApi.Abramov.computerShop.model.entity.Product;
import com.computerApi.Abramov.computerShop.model.enums.LaptopType;
import com.computerApi.Abramov.computerShop.model.enums.Type;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LaptopDTO {
    private  String seriesNumber;
    private  String manufacturer;
    private  Long price;
    private  Long count;
    private Type type;
    private LaptopType laptopType;

    public LaptopDTO() {
    }

    public static LaptopDTO toModel(Product product){
        LaptopDTO laptopDTO = new LaptopDTO();
        laptopDTO.setSeriesNumber(product.getSeriesNumber());
        laptopDTO.setManufacturer(product.getManufacturer());
        laptopDTO.setPrice(product.getPrice());
        laptopDTO.setType(product.getType());
        laptopDTO.setLaptopType(product.getLaptopType());
        return laptopDTO;
    }
}
