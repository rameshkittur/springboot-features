package com.rameshkittur.Spring.Boot.Features.client;

import com.rameshkittur.Spring.Boot.Features.dto.EmployeeDto;

import java.util.List;

public interface EmployeeClient {

    List<EmployeeDto>getAllEmployee();

    EmployeeDto getEmployeeById(Long id);

    EmployeeDto addEmployee(EmployeeDto employeeDto);
}
