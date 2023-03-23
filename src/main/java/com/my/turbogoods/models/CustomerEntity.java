package com.my.turbogoods.models;

import com.my.turbogoods.models.embedded.Address;
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
@Table(name = "customer")
public class CustomerEntity extends BaseEntity{

    @Column(precision = 10, scale = 2)
    private BigDecimal total;

    @Embedded
    private Address address;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @OneToMany(mappedBy = "customerEntity")
    private Set<OrderEntity> orders;
}
