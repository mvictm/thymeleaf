package com.max.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by 1 on 21.03.2019.
 */

@AllArgsConstructor
@Getter @Setter
public class User {
    private final String firstName;
    private final String lastName;
    private final int age;

    public String getName() {
        return firstName + " " + lastName;
    }
}
