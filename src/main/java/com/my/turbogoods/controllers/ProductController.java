package com.my.turbogoods.controllers;

import com.my.turbogoods.dto.product.ProductListResponse;
import com.my.turbogoods.dto.product.ProductRequest;
import com.my.turbogoods.dto.product.ProductResponse;
import com.my.turbogoods.dto.product.ProductFullResponse;
import com.my.turbogoods.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping("/turbo/v1/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping( produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ProductListResponse getListFullProductInfo(@RequestParam(name = "page", required = false) Integer page,
                                                      @RequestParam(name = "size", required = false) Integer size) {
        return productService.getFullProductList(page, size);
    }
    @GetMapping(value = "/{product-id}/full", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ProductFullResponse getFullProductInfo(@PathVariable("product-id") UUID id) {
        return productService.getFullProductInfo(id);
    }


    @GetMapping(value = "/{product-id}", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ProductResponse getProductInfo(@PathVariable("product-id") UUID id) {
        return productService.getProductInfo(id);
    }
    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ProductFullResponse saveProduct(@RequestBody ProductRequest productRequest) {
        return productService.saveProduct(productRequest);
    }

    @PutMapping(value = "/{product-id}",consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ProductFullResponse saveProduct(@RequestBody ProductRequest productRequest,
                                           @PathVariable("product-id") UUID id) {
        return productService.updateProduct(id, productRequest);
    }

    @DeleteMapping("/{product-id}")
    public ResponseEntity<?> removeProduct(@PathVariable("product-id") UUID id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
