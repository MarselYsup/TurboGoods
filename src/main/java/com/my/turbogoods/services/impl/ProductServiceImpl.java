package com.my.turbogoods.services.impl;

import com.my.turbogoods.dto.product.ProductGetDto;
import com.my.turbogoods.dto.product.ProductGetFullDto;
import com.my.turbogoods.mappers.ProductMapper;
import com.my.turbogoods.models.ProductEntity;
import com.my.turbogoods.repositories.ProductRepository;
import com.my.turbogoods.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;

    private final ProductRepository productRepository;

    //TODO add exception handler
    @Override
    public ProductGetFullDto getFullProductInfo(UUID id) {
        return productMapper.toProductGetFullDto(productRepository.findById(id).orElseGet(ProductEntity::new));
    }

    @Override
    public ProductGetDto getProductInfo(UUID id) {
        return productMapper.toProductGetDto(productRepository.findById(id).orElseGet(ProductEntity::new));
    }
}
