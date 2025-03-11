package com.merkacar.dto;

import com.merkacar.model.Department;
import lombok.Data;

@Data
public class DtoEmployee {
    private Long id;
    private String name;
    private DtoDepartmant department;
}
