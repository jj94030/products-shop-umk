package pl.allegrotech.productsshop.domain;

import pl.allegrotech.productsshop.infrastructure.PriceModel;

class PriceConverter {

    static PriceDTO modelToDTO(PriceModel model) {
        PriceDTO dto = new PriceDTO();
        dto.setAmount(model.getAmount());
        dto.setCurrency(model.getCurrency());
        return dto;
    }

    static PriceModel dtoToModel(PriceDTO dto, PriceModel model) {
        model.setAmount(dto.getAmount());
        model.setCurrency(dto.getCurrency());
        return model;
    }
}
