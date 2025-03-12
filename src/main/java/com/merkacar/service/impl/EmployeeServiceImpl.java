package com.merkacar.service.impl;

import com.merkacar.dto.DtoDepartmant;
import com.merkacar.dto.DtoEmployee;
import com.merkacar.exception.BaseException;
import com.merkacar.exception.ErrorMessage;
import com.merkacar.exception.MessageType;
import com.merkacar.model.Employee;
import com.merkacar.repository.EmployeeRepository;
import com.merkacar.service.IEmployeeService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor

public class EmployeeServiceImpl implements IEmployeeService {
    private final EmployeeRepository employeeRepository;
    @Override
    public DtoEmployee findEmployeeById(Long id) {
        DtoEmployee dtoEmployee = new DtoEmployee();
        DtoDepartmant dtoDepartmant = new DtoDepartmant();
        Optional<Employee> optional = employeeRepository.findById(id);
        if(optional.isEmpty()) {
            throw  new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST,id.toString()));
        }
        Employee employee = optional.get();
//        dtoDepartmant.setId(employee.getDepartment().getId());
//        dtoEmployee.setId(employee.getId());
//        dtoEmployee.setName(employee.getName());
//        dtoEmployee.setDepartment(dtoDepartmant);
        BeanUtils.copyProperties(employee, dtoEmployee);
        BeanUtils.copyProperties(employee.getDepartment(), dtoDepartmant);
        dtoEmployee.setDepartment(dtoDepartmant);
        return dtoEmployee;

    }
}
