package com.demo.daofab.rest.controller.v1.api;

import com.demo.daofab.rest.dto.model.ChildTransactionDto;
import com.demo.daofab.rest.dto.model.ParentTransactionDto;
import com.demo.daofab.rest.dto.response.Response;
import com.demo.daofab.rest.service.ChildTransactionService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/child")
@Api(value = "daofab-rest", description = "Manipulating child transaction information in DAOFAB")
public class ChildTransactionController {
    @Autowired
    private ChildTransactionService childTransactionService;

    /**
     * @method: GET
     * @route: /api/v1/child/
     */
    @GetMapping("/")
    public Response getAllParentTransaction() {
        List<ChildTransactionDto> childTransactionDtos = childTransactionService.getAllChildTransaction(true);
        if (childTransactionDtos.isEmpty()) {
            return Response.notFound().setErrors("No child transaction found");
        } else {
            return Response.ok().setPayload(childTransactionDtos);
        }
    }
}
