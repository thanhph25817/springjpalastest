package com.example.demo;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long  id;
    @Column(name = "customername")
    private String customerName;
    @Column(name = "productname")
    private String productName;
    @Column(name = "quantity")
    private int quantity;
}
