package org.example.beans;

import java.util.Objects;

public class Goods extends Object {
    private final Long goodsId;
    private String goodsName;
    private Integer price;

    public Goods() {
        this.goodsId = 1L;
    }

    public Goods(String goodsName, int price) {
        this();
        this.goodsName = goodsName;
        this.price = price;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return String.format("상품번호: %d, 상품명: %s, 상품가격:%d", goodsId, goodsName, price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Goods goods = (Goods) o;
        return Objects.equals(goodsId, goods.goodsId) && Objects.equals(goodsName, goods.goodsName) && Objects.equals(price, goods.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(goodsId, goodsName, price);
    }
}
