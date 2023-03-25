package com.my.turbogoods.controllers;

import com.my.turbogoods.dto.product.ProductGetDto;
import com.my.turbogoods.dto.product.ProductGetFullDto;
import com.my.turbogoods.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping("/turbo/v1/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping(value = "/{product-id}/full", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ProductGetFullDto getFullProductInfo(@PathVariable("product-id") UUID id) {
        return productService.getFullProductInfo(id);
    }


    @GetMapping(value = "/{product-id}", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ProductGetDto getProductInfo(@PathVariable("product-id") UUID id) {
        return productService.getProductInfo(id);
    }
}
