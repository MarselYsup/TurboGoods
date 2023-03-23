package com.my.turbogoods.models.embedded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
@Embeddable
public class UserInfo {


    @Column(name = "first_name", columnDefinition = "varchar(100)", nullable = false)
    @Length(min = 2, max = 100)
    private String firstName;

    @Column(name = "last_name", columnDefinition = "varchar(100)")
    @Length(min = 2, max = 100)
    private String lastName;
    @Column(name = "phone_number", columnDefinition = "varchar(20)")
    private String phoneNumber;



}
