package pl.allegrotech.productsshop.domain;

import pl.allegrotech.productsshop.infrastructure.ProductModel;

class ProductTransformer {

    static ProductDTO modelToDTO(ProductModel model) {
        ProductDTO dto = new ProductDTO();
        dto.setId(model.getId());
        dto.setName(model.getName());
        dto.setDescription(model.getDescription());
        dto.setPrice(PriceTransformer.modelToDTO(model.getPrice()));
        return dto;
    }

    static ProductModel dtoToModel(ProductDTO dto) {
        ProductModel model = new ProductModel();
        model.setName(dto.getName());
        model.setDescription(dto.getDescription());
        return model;
    }
}
