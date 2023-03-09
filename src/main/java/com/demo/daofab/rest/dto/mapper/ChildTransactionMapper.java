package com.demo.daofab.rest.dto.mapper;

import com.demo.daofab.rest.dto.model.ChildTransactionDto;
import com.demo.daofab.rest.dto.model.ParentTransactionDto;
import com.demo.daofab.rest.model.ChildTransaction;
import com.demo.daofab.rest.model.ParentTransaction;

/**
 * Mapper class for mapping ChildTransaction to ChildTransactionDto
 */
public class ChildTransactionMapper {
    public static ChildTransactionDto toChildTransactionDto(ChildTransaction childTransaction) {
        ParentTransaction parentTransaction = childTransaction.getParentTransaction();
        return new ChildTransactionDto().setId(childTransaction.getId())
                .setPaidAmount(childTransaction.getPaidAmount())
                .setReceiver(parentTransaction.getReceiver())
                .setSender(parentTransaction.getSender())
                .setTotalAmount(parentTransaction.getTotalAmount());
    }
}
