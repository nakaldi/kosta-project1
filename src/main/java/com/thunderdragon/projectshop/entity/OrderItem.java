package com.thunderdragon.projectshop.entity;

import com.thunderdragon.projectshop.constant.OrderStatus;
import com.thunderdragon.projectshop.exception.OutOfStockException;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class OrderItem {

    @Id  @GeneratedValue
    @Column(name="order_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name="item_id")
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name="order_id")
    private Order order;

    private int orderPrice; //주문가격

    private int count; //수량

//    private LocalDateTime regTime; //삭제
//
//    private LocalDateTime updateTime; //삭제


    public static OrderItem createOrderItem(Item item,int count)  {
        OrderItem orderItem=new OrderItem();
        orderItem.setItem(item);
        orderItem.setCount(count);
        orderItem.setOrderPrice(item.getPrice());

        item.removeStock(count);
        return orderItem;
    }
    public int getTotalPrice(){
        return orderPrice*count;
    }

    public void cancel(){
        this.getItem().addStock(count);
    }
}