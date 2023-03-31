package com.my.turbogoods.services.impl;

import com.my.turbogoods.dto.product.ProductListResponse;
import com.my.turbogoods.dto.product.ProductRequest;
import com.my.turbogoods.dto.product.ProductResponse;
import com.my.turbogoods.dto.product.ProductFullResponse;
import com.my.turbogoods.mappers.ProductMapper;
import com.my.turbogoods.models.CategoryEntity;
import com.my.turbogoods.models.ProductEntity;
import com.my.turbogoods.repositories.CategoryRepository;
import com.my.turbogoods.repositories.ProductRepository;
import com.my.turbogoods.services.ProductService;
import com.my.turbogoods.util.consts.PageConst;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;

    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;

    //TODO add exception handler
    @Override
    public ProductFullResponse getFullProductInfo(UUID id) {
        return productMapper.toProductFullResponse(productRepository.findById(id).orElseGet(ProductEntity::new));
    }

    @Override
    public ProductResponse getProductInfo(UUID id) {
        return productMapper.toProductResponse(productRepository.findById(id).orElseGet(ProductEntity::new));
    }

    @Override
    public ProductListResponse getFullProductList(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(
                Objects.isNull(page) ? PageConst.DEFAULT_PAGE : page,
                Objects.isNull(size) ? PageConst.DEFAULT_SIZE : size
                );
        Page<ProductEntity> productEntityPage = productRepository.findAll(pageable);
        return ProductListResponse.builder()
                .productResponseList(productMapper.toProductFullResponseList(productEntityPage.getContent()))
                .currentPage(productEntityPage.getNumber())
                .totalPage(productEntityPage.getTotalPages())
                .build();

    }


    @Override
    public ProductFullResponse saveProduct(ProductRequest productRequest) {
        ProductEntity productEntity = productMapper.toProductEntity(productRequest);
        productEntity.setCategoryEntity(
                categoryRepository.findById(productRequest.category())
                        .orElseThrow(IllegalArgumentException::new)
        );
        return productMapper.toProductFullResponse(productRepository.save(productEntity));
    }

    @Override
    public void deleteProduct(UUID id) {
        productRepository.deleteById(id);
    }

    @Override
    public ProductFullResponse updateProduct(UUID id, ProductRequest productRequest) {
        ProductEntity productEntity = productRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        productEntity.setName(productRequest.name());
        productEntity.setCount(productRequest.count());
        productEntity.setPricePerUnit(productRequest.pricePerUnit());
        productEntity.setCategoryEntity(
                categoryRepository.findById(productRequest.category())
                        .orElseThrow(IllegalArgumentException::new)
        );
        return productMapper.toProductFullResponse(productRepository.save(productEntity));
    }
}
