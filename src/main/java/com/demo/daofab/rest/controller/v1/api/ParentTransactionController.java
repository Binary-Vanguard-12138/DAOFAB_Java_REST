package com.demo.daofab.rest.controller.v1.api;

import com.demo.daofab.rest.dto.model.ParentTransactionDto;
import com.demo.daofab.rest.dto.response.Response;
import com.demo.daofab.rest.service.ParentTransactionService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/parent")
@Api(value = "daofab-rest", description = "Manipulating parent transaction information in DAOFAB")

public class ParentTransactionController {
    private static final String DEFAULT_PAGE_SIZE = "2";
    private static final String DEFAULT_PAGE_NUMBER = "0";
    private static final String DEFAULT_SORT_BY_ID = "true";
    @Autowired
    private ParentTransactionService parentTransactionService;

    /**
     * @method GET
     * @route /api/v1/parent/
     * @param pageSize
     * @param pageNumber
     * @param sortById
     * @return
     */
    @GetMapping("/")
    public Response getAllParentTransaction(@RequestParam(value = "pageSize", required = true, defaultValue = DEFAULT_PAGE_SIZE) Integer pageSize,
                                            @RequestParam(value = "pageNumber", required = false, defaultValue = DEFAULT_PAGE_NUMBER) Integer pageNumber,
                                            @RequestParam(value = "sortById", required = false, defaultValue = DEFAULT_SORT_BY_ID) Boolean sortById) {
        List<ParentTransactionDto> parentTransactionDtos = parentTransactionService.getParentTransactions(pageSize, pageNumber, sortById);
        if (parentTransactionDtos.isEmpty()) {
            return Response.notFound().setErrors(String.format("No parent transactions on pageNumber = %d, pageSize = %d", pageNumber, pageSize));
        } else {
            return Response.ok().setPayload(parentTransactionDtos);
        }
    }
}
