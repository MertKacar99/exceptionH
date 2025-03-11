package com.merkacar.service;

import com.merkacar.dto.DtoEmployee;
import com.merkacar.model.Employee;

public interface IEmployeeService {
    public DtoEmployee findEmployeeById(Long id);

}
