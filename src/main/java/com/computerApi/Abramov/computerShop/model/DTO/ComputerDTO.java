package com.computerApi.Abramov.computerShop.model.DTO;

import com.computerApi.Abramov.computerShop.model.entity.Product;
import com.computerApi.Abramov.computerShop.model.enums.ComputerType;
import com.computerApi.Abramov.computerShop.model.enums.Type;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComputerDTO {
    private  String seriesNumber;
    private  String manufacturer;
    private  Long price;
    private  Long count;
    private Type type;
    private ComputerType computerType;

    public ComputerDTO() {
    }
    public static ComputerDTO toModel(Product product){
        ComputerDTO computerDTO = new ComputerDTO();
        computerDTO.setSeriesNumber(product.getSeriesNumber());
        computerDTO.setManufacturer(product.getManufacturer());
        computerDTO.setPrice(product.getPrice());
        computerDTO.setType(product.getType());
        computerDTO.setComputerType(product.getComputerType());
        return computerDTO;
    }
}
