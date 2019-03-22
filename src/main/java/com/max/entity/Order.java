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
public class Order {
    private Integer id;
    private Calendar date;
    private Customer customer;
}
