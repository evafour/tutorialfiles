package com.demojpa.demojpa.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = OrderDetail.ORDER_DETAIL)
public class OrderDetail {

    static final String ORDER_DETAIL = "order_detail";

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "item_price")
    private Long itemPrice;

    public OrderDetail(String itemName, Long itemPrice, Order order) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.order=order;
    }
//    @Column(name = "order_fk")
//    private Long orderFk;

    public OrderDetail() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Long getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Long itemPrice) {
        this.itemPrice = itemPrice;
    }

//    public Long getOrderFk() {
//        return orderFk;
//    }
//
//    public void setOrderFk(Long orderFk) {
//        this.orderFk = orderFk;
//    }


    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_fk")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Order order;



    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
//                ", orderFk=" + orderFk +
//                ", order=" + order +
                '}';
    }
}
