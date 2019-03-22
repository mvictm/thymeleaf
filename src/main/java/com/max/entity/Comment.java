package com.max.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Max
 */

@Data
@AllArgsConstructor
public class Comment {
    private final Integer id;
    private final String text;
}
