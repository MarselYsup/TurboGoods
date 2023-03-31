package com.my.turbogoods.dto.product;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductRequest(String name, BigDecimal pricePerUnit, Integer count, UUID category) {
}
