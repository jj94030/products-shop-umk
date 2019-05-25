package pl.allegrotech.productsshop.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<PriceModel, Long> {
}
