package com.demo.daofab.rest.dto.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * ParentJsonDto is used for reading from Parent.json using ObjectMapper
 */
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@ToString
public class ParentJsonDto {
    private int id;
    private String sender;
    private String receiver;
    private int totalAmount;
}
