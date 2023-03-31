package com.my.turbogoods.dto.product;

import java.util.UUID;

public record ProductResponse(UUID id, String name, String category) {
}
