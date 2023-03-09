package com.demo.daofab.rest.repository;

import com.demo.daofab.rest.dto.model.*;
import com.demo.daofab.rest.model.ChildTransaction;
import com.demo.daofab.rest.model.ParentTransaction;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

@Component
public class TransactionRepository {
    private static boolean initialized = false;
    private static ArrayList<ChildTransaction> childTransactions = new ArrayList<ChildTransaction>();
    private static ArrayList<ParentTransaction> parentTransactions = new ArrayList<ParentTransaction>();

    private static ParentTransaction getParentTransactionById(int id) {
        return parentTransactions.stream().filter(parentTransaction -> id == parentTransaction.getId()).findFirst().orElse(null);
    }
    /**
     * Load 2 JSON files into array of 2 models.
     * Called only once when loading
     */
    private static void initialize() {
        if (false == initialized) {
            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            try {
                /**
                 * Load Parent.json to ParentTransaction model without childTransactions field
                 */
                ClassPathResource parentTransactionResource = new ClassPathResource("json/Parent.json");
                ParentJsonDataDto parentJsonDataDto = mapper.readValue(parentTransactionResource.getInputStream(), ParentJsonDataDto.class);
                for (ParentJsonDto parentJsonDto : parentJsonDataDto.getData()) {
                    parentTransactions.add(new ParentTransaction(parentJsonDto.getId(), parentJsonDto.getSender(), parentJsonDto.getReceiver(), parentJsonDto.getTotalAmount()));
                }

                /**
                 * Load Child.json to ChildTransaction,
                 * filling childTransactions field in ParentTransaction object and parentTransaction in ChildTransaction object
                 */
                ClassPathResource childTransactionResource = new ClassPathResource("json/Child.json");
                ChildJsonDataDto childJsonDataDto = mapper.readValue(childTransactionResource.getInputStream(), ChildJsonDataDto.class);
                for (ChildJsonDto childJsonDto : childJsonDataDto.getData()) {
                    ParentTransaction parentTransaction = getParentTransactionById(childJsonDto.getParentId());
                    if (null != parentTransaction) {
                        ChildTransaction childTransaction = new ChildTransaction(
                                childJsonDto.getId(),
                                parentTransaction,
                                childJsonDto.getPaidAmount());
                        childTransactions.add(childTransaction);
                        parentTransaction.addChildTransaction(childTransaction);
                    }
                }
            } catch (IOException e) {
                /**
                 * Failed to load JSON files, fatal error, need to shut down
                 */
                System.exit(0);
            }
            initialized = true;
        }
    }

    public static ArrayList<ParentTransaction> getParentTransactions(int pageSize, int pageNumber, boolean sortById) {
        initialize();
        ArrayList<ParentTransaction> parentTransactionArrayList = new ArrayList<>(parentTransactions); // Copy the originally loaded parent data
        if (sortById) {
            // Sort by id if sortById is set to true
            parentTransactionArrayList.sort(Comparator.comparing(ParentTransaction::getId));
        }
        /**
         * apply Math.min() to avoid overflow
         */
        return new ArrayList<>(parentTransactionArrayList.subList(
                Math.min(pageSize * pageNumber, parentTransactionArrayList.size() - 1),
                Math.min(pageSize * (1 + pageNumber), parentTransactionArrayList.size() - 1)));
    }

    public ArrayList<ChildTransaction> getAllChildTransaction(boolean sortById) {
        initialize();
        return childTransactions;
    }
}
