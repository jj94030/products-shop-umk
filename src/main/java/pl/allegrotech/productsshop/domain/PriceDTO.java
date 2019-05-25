package pl.allegrotech.productsshop.domain;

import java.math.BigDecimal;

class PriceDTO {

    private BigDecimal amount;
    private Currency currency;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
