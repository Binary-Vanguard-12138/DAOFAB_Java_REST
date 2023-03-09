package com.demo.daofab.rest.service;

import com.demo.daofab.rest.dto.model.ParentTransactionDto;

import java.util.ArrayList;
import java.util.List;

/**
 * Interface for parent transaction service
 */
public interface ParentTransactionService {
    List<ParentTransactionDto> getParentTransactions(int pageSize, int pageNumber, boolean sortById);
}
