package com.merkacar.controller.impl;

import com.merkacar.controller.RestEmployeeController;
import com.merkacar.dto.DtoEmployee;
import com.merkacar.service.IEmployeeService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/api/employee")
@RequiredArgsConstructor
public class RestEmployeeControllerImpl implements RestEmployeeController {
    private final IEmployeeService employeeService;


    @GetMapping("/list")
    @Override
    public DtoEmployee findEmployeeById(@RequestHeader Long id) {
        return employeeService.findEmployeeById(id);
    }
}
