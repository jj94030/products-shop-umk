package pl.allegrotech.productsshop.domain;

import pl.allegrotech.productsshop.infrastructure.PriceModel;
import pl.allegrotech.productsshop.infrastructure.ProductModel;

class ProductConverter {

    static ProductDTO modelToDTO(ProductModel model) {
        ProductDTO dto = new ProductDTO();
        dto.setId(model.getId());
        dto.setName(model.getName());
        dto.setDescription(model.getDescription());
        dto.setPrice(PriceConverter.modelToDTO(model.getPrice()));
        return dto;
    }

    static ProductModel dtoToModel(ProductDTO dto, ProductModel model) {
        model.setName(dto.getName());
        model.setDescription(dto.getDescription());
        model.setPrice(PriceConverter.dtoToModel(dto.getPrice(), new PriceModel()));
        return model;
    }
}
