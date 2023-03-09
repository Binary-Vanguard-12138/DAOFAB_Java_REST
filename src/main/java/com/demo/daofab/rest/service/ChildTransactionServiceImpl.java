package com.demo.daofab.rest.service;

import com.demo.daofab.rest.dto.mapper.ChildTransactionMapper;
import com.demo.daofab.rest.dto.mapper.ParentTransactionMapper;
import com.demo.daofab.rest.dto.model.ChildTransactionDto;
import com.demo.daofab.rest.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation for Child transaction service
 */
@Component
public class ChildTransactionServiceImpl implements ChildTransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    /**
     *
     * @param sortById
     * @return List of all ChildTransactionDto objects
     */
    @Override
    public List<ChildTransactionDto> getAllChildTransaction(boolean sortById) {
        return transactionRepository.getAllChildTransaction(sortById)
                .stream().map(childTransaction -> ChildTransactionMapper.toChildTransactionDto(childTransaction))
                .collect(Collectors.toList());
    }

}
