package pro.sky.spring27.service;

import org.springframework.stereotype.Service;
import pro.sky.spring27.exception.EmployeeAlreadyAddedException;
import pro.sky.spring27.exception.EmployeeNotFoundException;
import pro.sky.spring27.exception.EmployeeStorageFullException;
import pro.sky.spring27.model.Employee;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static final int COUNT_EMPLOYEE = 9;
    private List<Employee> workers = new ArrayList<>();

    /**
     * добавляет сотрудника
     * @param firstName имя сотрудника
     * @param lastName фамилия
     * @return добавленного сотрудника
     */
    @Override
    public Employee add(String firstName, String lastName) {
        if (workers.size() >= COUNT_EMPLOYEE) {
            throw new EmployeeStorageFullException("слишком много сотрудников");
        }

        Employee employee = new Employee(firstName, lastName);
        if (workers.contains(employee)) {
            throw new EmployeeAlreadyAddedException("уже имеется в коллекции");
        }
        workers.add(employee);
        return employee;
    }

    @Override
    public List<Employee> all() {
        return workers;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (workers.contains(employee)) {
            workers.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundException("сотрудник не найден");

    }

        @Override
        public Employee find (String firstName, String lastName){
            Employee employee = new Employee(firstName, lastName);
            if (workers.contains(employee)) {
                return employee;
            }
            throw new EmployeeNotFoundException("сотрудник не найден");
    }

}
