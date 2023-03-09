package com.demo.daofab.rest.service;

import com.demo.daofab.rest.dto.model.ChildTransactionDto;

import java.util.ArrayList;
import java.util.List;

/**
 * Interface for Child transaction service
 */
public interface ChildTransactionService {
    List<ChildTransactionDto> getAllChildTransaction(boolean sortById);
}
