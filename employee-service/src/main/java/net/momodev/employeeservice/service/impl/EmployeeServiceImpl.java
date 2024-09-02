package net.momodev.employeeservice.service.impl;

import lombok.AllArgsConstructor;
import net.momodev.employeeservice.dto.APIResponseDto;
import net.momodev.employeeservice.dto.DepartmentDto;
import net.momodev.employeeservice.dto.EmployeeDto;
import net.momodev.employeeservice.entity.Employee;
import net.momodev.employeeservice.repository.EmployeeRepository;
import net.momodev.employeeservice.service.APIClient;
import net.momodev.employeeservice.service.EmployeeService;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl  implements EmployeeService {
    private EmployeeRepository employeeRepository;
//    private RestTemplate restTemplate;
//    private WebClient webClient;
    private APIClient apiClient;
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getDepartmentCode()

        );
        Employee saveEmployee = employeeRepository.save(employee);
        EmployeeDto savedEmployeeDto = new EmployeeDto(
                saveEmployee.getId(),
                saveEmployee.getFirstName(),
                saveEmployee.getLastName(),
                saveEmployee.getEmail(),
                saveEmployee.getDepartmentCode()

        );
        return savedEmployeeDto;
    }
    @Override

    public APIResponseDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).get();

//        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/"+ employee.getDepartmentCode(),
//             DepartmentDto.class);
//
//        DepartmentDto departmentDto = responseEntity.getBody();
//        DepartmentDto departmentDto = webClient.get()
//                .uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode())
//                .retrieve()
//                .bodyToMono(DepartmentDto.class)
//                .block();
     DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());

                 //Create the EmployeeDto
        EmployeeDto employeeDto = new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartmentCode()

        );
                //Create the APIResponseDto
        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);
        return apiResponseDto;
    }



}
