package com.my.turbogoods.services;

import com.my.turbogoods.dto.product.ProductFullResponse;
import com.my.turbogoods.dto.product.ProductListResponse;
import com.my.turbogoods.dto.product.ProductResponse;
import com.my.turbogoods.dto.product.ProductRequest;

import java.util.UUID;

public interface ProductService {
    ProductFullResponse getFullProductInfo(UUID id);

    ProductResponse getProductInfo(UUID id);

    ProductListResponse getFullProductList(Integer page, Integer size);

    ProductFullResponse saveProduct(ProductRequest productRequest);

    void deleteProduct(UUID id);

    ProductFullResponse updateProduct(UUID id, ProductRequest productRequest);

}
