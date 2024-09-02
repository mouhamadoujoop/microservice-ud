    package net.momodev.departementservice.service.impl;

    import net.momodev.departementservice.dto.DepartmentDto;
    import net.momodev.departementservice.entity.Department;
    import net.momodev.departementservice.repository.DepartmentRepository;
    import net.momodev.departementservice.service.DepartmentService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    @Service
    public class DepartmentServiceImpl implements DepartmentService {
        @Autowired
        private DepartmentRepository departmentRepository;
        @Override
        public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
            // convert department dto to department jpa entity
            Department department = new Department(
                    departmentDto.getId(),
                    departmentDto.getDepartmentName(),
                    departmentDto.getDepartmentDescription(),
                    departmentDto.getDepartmentCode()
            );
            Department  savedDepartment = departmentRepository.save(department);
            DepartmentDto savedDepartmentDto = new DepartmentDto(
                savedDepartment.getId(),
                    savedDepartment.getDepartmentName(),
                    savedDepartment.getDepartmentDescription(),
                    savedDepartment.getDepartmentCode()
            );
            return savedDepartmentDto;
        }
        @Override
        public DepartmentDto getDepartmentByCode(String departmentCode) {

            Department department = departmentRepository.findByDepartmentCode(departmentCode);
            DepartmentDto departmentDto = new DepartmentDto(
                    department.getId(),
                    department.getDepartmentName(),
                    department.getDepartmentDescription(),
                    department.getDepartmentCode()
            );

            return departmentDto;
        }

    }
