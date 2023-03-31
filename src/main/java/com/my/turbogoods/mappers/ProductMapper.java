package com.my.turbogoods.mappers;

import com.my.turbogoods.dto.product.ProductFullResponse;
import com.my.turbogoods.dto.product.ProductRequest;
import com.my.turbogoods.dto.product.ProductResponse;
import com.my.turbogoods.models.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ProductMapper {
    @Mapping(target = "category", source = "categoryEntity.name")
    ProductFullResponse toProductFullResponse(ProductEntity productEntity);

    @Mapping(target = "category", source = "categoryEntity.name")
    ProductResponse toProductResponse(ProductEntity productEntity);

    ProductEntity toProductEntity(ProductRequest productRequest);

    List<ProductFullResponse> toProductFullResponseList(List<ProductEntity> productEntityList);

}
