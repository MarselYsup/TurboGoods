package com.my.turbogoods.models;

import com.my.turbogoods.models.enums.Category;
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
@Table(name = "category")
public class CategoryEntity extends BaseEntity{

    @Enumerated(EnumType.STRING)
    private Category name;
    @OneToMany(mappedBy = "categoryEntity")
    private Set<ProductEntity> products;
}
