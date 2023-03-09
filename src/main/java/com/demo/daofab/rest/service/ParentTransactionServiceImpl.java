package com.demo.daofab.rest.service;

import com.demo.daofab.rest.dto.mapper.ParentTransactionMapper;
import com.demo.daofab.rest.dto.model.ParentTransactionDto;
import com.demo.daofab.rest.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Implementation for parent transaction service
 */
@Component
public class ParentTransactionServiceImpl implements ParentTransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    /**
     *
     * @param pageSize
     * @param pageNumber
     * @param sortById
     * @return List of some ParentTransactionDto objects indicated by pageSize and pageNumber
     */
    @Override
    public List<ParentTransactionDto> getParentTransactions(int pageSize, int pageNumber, boolean sortById) {
        return transactionRepository.getParentTransactions(pageSize, pageNumber, sortById)
                .stream().map(parentTransaction -> ParentTransactionMapper.toParentTransactionDto(parentTransaction))
                .collect(Collectors.toList());
    }
}
