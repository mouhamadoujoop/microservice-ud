package net.momodev.employeeservice.controller;

import lombok.AllArgsConstructor;
import net.momodev.employeeservice.dto.APIResponseDto;
import net.momodev.employeeservice.dto.EmployeeDto;
import net.momodev.employeeservice.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
public class EmployeeController {
    private EmployeeService employeeService;
    // Build Save Employee REST API
    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }


    @GetMapping("{id}")
   public ResponseEntity<APIResponseDto> getEmployee(@PathVariable("id") Long employeeId){
      APIResponseDto apiResponseDto = employeeService.getEmployeeById(employeeId);
     return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
    }

}

//    // Build Get Employee REST API
//    @GetMapping("{id}")
//    public ResponseEntity<APIResponseDto> getEmployee(@PathVariable("id") Long employeeId) {
//        try {
//            APIResponseDto apiResponseDto = employeeService.getEmployeeById(employeeId);
//            return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
    //}