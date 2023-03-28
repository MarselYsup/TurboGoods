package com.my.turbogoods.dto.product;

import java.math.BigDecimal;

public record ProductGetFullDto(String name, BigDecimal pricePerUnit, Integer count, String category) {
}
