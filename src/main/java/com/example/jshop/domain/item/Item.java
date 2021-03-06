package com.example.jshop.domain.item;

import com.example.jshop.exception.NotEnoughStockException;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dytpe")
@Getter
@Setter
public abstract class Item {

    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;
    private int price;
    private int quantity;

    public void addStock(int quantity) {
        this.quantity += quantity;
    }

    public void removeStock(int quantity) {
        if (this.quantity < quantity) {
            throw new NotEnoughStockException("NotEnoughStockException");
        }

        this.quantity -= quantity;
    }

}
