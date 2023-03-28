package com.my.turbogoods.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;

import java.time.Instant;
import java.util.UUID;



@MappedSuperclass
@SuperBuilder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
abstract class BaseEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(updatable = false)
    private Instant created;
    @Column(insertable = false)
    private Instant updated;

    @PrePersist
    public void onCreate() {
        created = Instant.now();
    }
    @PreUpdate
    public void onUpdate() {
        updated = Instant.now();
    }

}
