package com.redis.springkafkaapp;

import com.redis.springkafkaapp.entity.Employee;
import com.redis.springkafkaapp.entity.EmployeePrimaryKey;
import com.redis.springkafkaapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CassandraService {

    @Autowired
    EmployeeRepository employeeRepository;

    public void casTest() {
        Employee employee1 = new Employee(
                new EmployeePrimaryKey("seoul", "business", "key"),
                "010-1234-5678"
        );
        employeeRepository.save(employee1);

        Employee employee2 = new Employee(
                new EmployeePrimaryKey("seoul", "business", "joy"),
                "010-8765-4321"
        );
        employeeRepository.save(employee2);

        var result = employeeRepository.findByKeyLocationAndKeyDepartment("seoul", "business");

        result.stream().map(e ->
            String.format("location: %s, department: %s, name: %s, phone: %s", e.key.location, e.key.department, e.key.name, e.phoneNumber)
        ).forEach(System.out::println);
    }
}
