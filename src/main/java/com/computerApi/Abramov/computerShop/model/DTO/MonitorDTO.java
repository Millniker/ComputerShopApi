package com.computerApi.Abramov.computerShop.model.DTO;

import com.computerApi.Abramov.computerShop.model.entity.Product;
import com.computerApi.Abramov.computerShop.model.enums.Type;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MonitorDTO {
    private  String seriesNumber;
    private  String manufacturer;
    private  Long price;
    private  Long count;
    private Type type;
    private  Integer diagonal;

    public MonitorDTO() {
    }

    public static MonitorDTO toModel(Product product){
        MonitorDTO monitorDTO = new MonitorDTO();
        monitorDTO.setSeriesNumber(product.getSeriesNumber());
        monitorDTO.setManufacturer(product.getManufacturer());
        monitorDTO.setPrice(product.getPrice());
        monitorDTO.setType(product.getType());
        monitorDTO.setDiagonal(product.getDiagonal());
        return monitorDTO;
    }
}
