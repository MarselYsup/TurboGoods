package com.my.turbogoods.models;

import com.my.turbogoods.models.embedded.Address;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.Instant;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@Entity
@Table(name = "orders")
public class OrderEntity extends BaseEntity{

    @Embedded
    private Address address;

    @Column(name = "delivery_date", nullable = false)
    private Instant deliveryDate;

    @ManyToOne
    @JoinColumn(name = "courier_id")
    private CourierEntity courierEntity;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customerEntity;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "order_product", joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id")
    )
    private Set<ProductEntity> products;
}
