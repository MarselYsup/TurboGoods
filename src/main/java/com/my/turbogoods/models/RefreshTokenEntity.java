package com.my.turbogoods.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@Entity
@Table(name = "refresh_token")
public class RefreshTokenEntity extends BaseEntity{

    @Column(name = "expired_time", nullable = false)
    private Instant expiredTime;

    @OneToOne(mappedBy = "refreshToken", fetch = FetchType.LAZY)
    private UserEntity userAccount;
}