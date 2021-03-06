package com.codecool.shop.model;


public class BasketItem extends BaseModel{
    private Product product;
    private Integer quantity;

    public BasketItem(Product product, Integer quantity){
        super("","");
        this.setProduct(product);
        this.setQuantity(quantity);
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getPrice() {
        double roundOff = Math.round(product.getDefaultPrice() * quantity * 100.0) / 100.0;
        return (float) roundOff;
    }
}
