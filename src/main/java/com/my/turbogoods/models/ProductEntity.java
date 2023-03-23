package com.my.turbogoods.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@Entity
@Table(name = "product")
public class ProductEntity extends BaseEntity{

    @Column(nullable = false)
    private String name;

    @Column(name = "price_per_unit", precision = 8, scale = 2)
    private BigDecimal pricePerUnit;
    @Column(nullable = false)
    private Integer count;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity categoryEntity;

    @ManyToMany(mappedBy = "products")
    private Set<OrderEntity> orders;

}
