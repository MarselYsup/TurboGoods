package com.my.turbogoods.models;

import com.my.turbogoods.models.embedded.UserInfo;
import com.my.turbogoods.models.enums.Role;
import com.my.turbogoods.models.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "confirm_code", unique = true)
    private String confirmCode;

    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "token_id")
    private RefreshTokenEntity refreshToken;

    @Embedded
    private UserInfo userInfo;
    @OneToOne(mappedBy = "userEntity", cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.REFRESH})
    private CourierEntity courierEntity;
    @OneToOne(mappedBy = "userEntity", cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.REFRESH})
    private CustomerEntity customerEntity;




}
