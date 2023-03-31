package com.my.turbogoods.dto.product;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductFullResponse(UUID id, String name, BigDecimal pricePerUnit, Integer count, String category) {
}
