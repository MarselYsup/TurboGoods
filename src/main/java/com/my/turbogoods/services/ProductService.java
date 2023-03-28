package com.my.turbogoods.services;

import com.my.turbogoods.dto.product.ProductGetDto;
import com.my.turbogoods.dto.product.ProductGetFullDto;

import java.util.UUID;

public interface ProductService {
    ProductGetFullDto getFullProductInfo(UUID id);

    ProductGetDto getProductInfo(UUID id);
}
