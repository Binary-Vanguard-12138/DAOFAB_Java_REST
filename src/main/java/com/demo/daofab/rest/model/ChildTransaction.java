package com.demo.daofab.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;


/**
 * Model for Child Transaction
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class ChildTransaction {
    @Id
    private int id;
    private ParentTransaction parentTransaction;
    private int paidAmount;

    public ChildTransaction(int _id, ParentTransaction _parentTransaction, int _paidAmount) {
        this.id = _id;
        this.parentTransaction = _parentTransaction;
        this.paidAmount = _paidAmount;
    }
}
