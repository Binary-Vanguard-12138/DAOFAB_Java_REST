package com.demo.daofab.rest.dto.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * ChildJsonDto is used for reading from Child.json using ObjectMapper
 */
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@ToString
public class ChildJsonDto {
    private int id;
    private int parentId;
    private int paidAmount;
}
