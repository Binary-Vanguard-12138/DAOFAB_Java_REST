package com.demo.daofab.rest.dto.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * ChildJsonDataDto is a temporary class which is used for reading "data" element from Parent.json using ObjectMapper
 */
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@ToString
public class ParentJsonDataDto {
    private ParentJsonDto[] data;
}
