package com.codecool.shop.model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;


class BasketTest {
    private Basket basket;
    private ProductCategory category;
    private Supplier supplier;
    private Product product;
    private List<BasketItem> items;
    private BasketItem item;

    @BeforeEach
    void setup() {
        this.basket = new Basket();
        this.category = mock(ProductCategory.class);
        this.supplier = mock(Supplier.class);
        this.product = new Product("", 1.1f, "PLN", "", category, supplier);
        this.items = new ArrayList<>();
        this.item = new BasketItem(product, 1);
    }

    @Test
    public void testSetAndGetItems() {
        items.add(item);
        basket.setItems(items);
        assertEquals(items, basket.getItems());
    }

    @Test
    public void testAddToBasketFailsWhenQuantityLT1() {
        assertThrows(IllegalArgumentException.class, ()-> basket.add(product, -1));
    }

    @Test
    public void testAddFailsIfProductIsNull() {
        assertThrows(NullPointerException.class, ()-> basket.add(null, 1));
    }

    @Test
    public void testGetPriceReturnsAccurateFloat() {
        basket.add(product, 1);
        assertEquals(basket.getPrice(), 1.1f, 0.00000001f);
        // try using big decimal instead of float when counting money
    }

    @Test
    public void testGetPriceNettoReturnsAccurateFloat() {
        basket.add(product, 1);
        assertEquals(basket.getPriceNetto(), 1.1f/ 1.23f, 0.00000001f);
        // try using big decimal instead of float when counting money
    }

    @Test
    public void testDeleteFailsWhenProductIsNull() {
        assertThrows(NullPointerException.class, ()-> basket.delete(null, 1));
    }

    @Test
    public void testDeleteFailsWhenQuantityLT1() {
        assertThrows(IllegalArgumentException.class, ()-> basket.delete(product, -1));
    }

    @Test
    public void testGetItemByIdFailsWhenIdLT0() {
        assertThrows(IllegalArgumentException.class, ()-> basket.getItemById(-1));
    }
}