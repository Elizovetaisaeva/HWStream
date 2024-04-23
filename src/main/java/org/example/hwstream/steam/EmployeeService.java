package org.example.hwstream.steam;


import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


@Service
public class EmployeeService {
    private static final int SIZE_LIMIT = 5;
    private final Map<String, Employee> employees = new HashMap<>(SIZE_LIMIT);

    public Collection<Employee> getAll() {
        return employees.values();
    }


    public Employee add(String firstName, String lastNaime) {
        Employee employee = new Employee(firstName,lastNaime);
        if (employees.size() >= SIZE_LIMIT) {
            throw new EmployeeStorageIsFullException();
        }
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }

    public Employee find(String firstName, String lastNaime) {
        Employee employee = employees.get(createKey(firstName, lastNaime));
        return employee;

    }

    public Employee remove(String firstName, String lastNaime) {
        return employees.remove(createKey(firstName, lastNaime));


    }

    private String createKey(String firstName, String lastNaime) {
        return firstName + " " + lastNaime;
    }
}

