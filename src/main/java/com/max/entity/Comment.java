package com.max.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by 1 on 20.03.2019.
 */

@Data
@AllArgsConstructor
public class Comment {
    private final Integer id;
    private final String text;
}
