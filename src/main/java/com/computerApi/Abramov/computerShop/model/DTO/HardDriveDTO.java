package com.computerApi.Abramov.computerShop.model.DTO;

import com.computerApi.Abramov.computerShop.model.entity.Product;
import com.computerApi.Abramov.computerShop.model.enums.Type;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HardDriveDTO {
    private  String seriesNumber;
    private  String manufacturer;
    private  Long price;
    private  Long count;
    private Type type;
    private  Long amount;

    public HardDriveDTO() {
    }

    public static HardDriveDTO toModel(Product product){
        HardDriveDTO hardDriveDTO = new HardDriveDTO();
        hardDriveDTO.setSeriesNumber(product.getSeriesNumber());
        hardDriveDTO.setManufacturer(product.getManufacturer());
        hardDriveDTO.setPrice(product.getPrice());
        hardDriveDTO.setType(product.getType());
        hardDriveDTO.setAmount(product.getAmount());
        return hardDriveDTO;
    }
}
