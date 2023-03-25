package com.my.turbogoods.mappers;

import com.my.turbogoods.dto.product.ProductGetDto;
import com.my.turbogoods.dto.product.ProductGetFullDto;
import com.my.turbogoods.models.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ProductMapper {
    @Mapping(target = "category", source = "categoryEntity.name")
    ProductGetFullDto toProductGetFullDto(ProductEntity productEntity);

    @Mapping(target = "category", source = "categoryEntity.name")
    ProductGetDto toProductGetDto(ProductEntity productEntity);
}
