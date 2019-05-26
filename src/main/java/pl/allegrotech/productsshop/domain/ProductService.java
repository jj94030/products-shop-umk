package pl.allegrotech.productsshop.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.allegrotech.productsshop.infrastructure.ProductModel;
import pl.allegrotech.productsshop.infrastructure.ProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDTO> getAll() {
        return productRepository.findAll().stream()
                .map(ProductConverter::modelToDTO)
                .collect(Collectors.toList());
    }

    public ProductDTO getById(Long id) {
        Optional<ProductModel> productModel = productRepository.findById(id);

        return ProductConverter.modelToDTO(productModel.get());
    }

    public ProductDTO create(ProductDTO request) {
        ProductModel product = ProductConverter.dtoToModel(request, new ProductModel());

        return ProductConverter.modelToDTO(productRepository.save(product));
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public ProductDTO update(ProductDTO request) {
        Optional<ProductModel> productModel = productRepository.findById(request.getId());
        ProductModel productToUpdate = ProductConverter.dtoToModel(request, productModel.get());

        productRepository.save(productToUpdate);

        return ProductConverter.modelToDTO(productToUpdate);
    }
}
