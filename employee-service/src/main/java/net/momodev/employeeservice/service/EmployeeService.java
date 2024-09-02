package net.momodev.employeeservice.service;

import net.momodev.employeeservice.dto.APIResponseDto;
import net.momodev.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    APIResponseDto getEmployeeById(Long employeeId);
}
