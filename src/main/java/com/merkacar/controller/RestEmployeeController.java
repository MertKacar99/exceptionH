package com.merkacar.controller;

import com.merkacar.dto.DtoEmployee;

public interface RestEmployeeController {
   DtoEmployee findEmployeeById(Long id);
}
