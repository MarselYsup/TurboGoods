package com.my.turbogoods.models;

import com.my.turbogoods.models.enums.CourierType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@Entity
@Table(name = "courier")
public class CourierEntity extends BaseEntity{

    @Column(name = "courier_type")
    @Enumerated(EnumType.STRING)
    private CourierType courierType;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;
    @OneToMany(mappedBy = "courierEntity")
    private Set<OrderEntity> orders;

}
