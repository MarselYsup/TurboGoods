package com.my.turbogoods.dto.product;

import lombok.Builder;

import java.util.List;

@Builder
public record ProductListResponse(List<ProductFullResponse> productResponseList, Integer totalPage, Integer currentPage) {
}
