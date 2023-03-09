package com.demo.daofab.rest.dto.mapper;

import com.demo.daofab.rest.dto.model.ParentTransactionDto;
import com.demo.daofab.rest.model.ParentTransaction;

/**
 * Mapper class for mapping ParentTransaction to ParentTransactionDto
 */
public class ParentTransactionMapper {
    public static ParentTransactionDto toParentTransactionDto(ParentTransaction parentTransaction) {
        return new ParentTransactionDto().setId(parentTransaction.getId())
                .setReceiver(parentTransaction.getReceiver())
                .setSender(parentTransaction.getSender())
                .setTotalAmount(parentTransaction.getTotalAmount())
                .setTotalPaidAmount(parentTransaction.getTotalPaidAmount());
    }
}
