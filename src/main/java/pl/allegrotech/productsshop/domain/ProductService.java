package pl.allegrotech.productsshop.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.allegrotech.productsshop.infrastructure.PriceModel;
import pl.allegrotech.productsshop.infrastructure.PriceRepository;
import pl.allegrotech.productsshop.infrastructure.ProductModel;
import pl.allegrotech.productsshop.infrastructure.ProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final PriceRepository priceRepository;

    @Autowired
    public ProductService(ProductRepository productRepository,
                          PriceRepository priceRepository) {
        this.productRepository = productRepository;
        this.priceRepository = priceRepository;
    }

    public List<ProductDTO> getAll() {

        return productRepository.findAll().stream().map(ProductTransformer::modelToDTO).collect(Collectors.toList());
    }

    public ProductDTO getById(Long id) {
        Optional<ProductModel> productModel = productRepository.findById(id);

        return ProductTransformer.modelToDTO(productModel.get());
    }

    public ProductDTO create(ProductDTO request) {
        PriceModel price = priceRepository.save(PriceTransformer.dtoToModel(request.getPrice()));
        ProductModel product = ProductTransformer.dtoToModel(request);
        product.setPrice(price);

        ProductModel response = productRepository.save(product);

        return ProductTransformer.modelToDTO(response);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
