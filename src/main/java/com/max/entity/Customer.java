package com.max.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Calendar;

/**
 * @author Max
 */

@NoArgsConstructor
@Getter @Setter
public class Customer {
    private Integer id;
    private String name;
    private Calendar calendar;
}
