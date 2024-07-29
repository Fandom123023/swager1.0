package pro.sky.spring27.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.spring27.model.Employee;
import pro.sky.spring27.service.EmployeeService;

import pro.sky.spring27.service.EmployeeServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private EmployeeService service ;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }
@GetMapping("/add")
    public Employee add1(String firstName, String lastName) {

        Employee employee =  service.add(firstName, lastName);
        return employee;

    }@GetMapping("/remove")
    public Employee remove1 (String firstName, String lastName){
        return service.remove(firstName,lastName);
    }
    @GetMapping("/find")
    public Employee find (String firstName, String lastName){
        return service.find(firstName, lastName);
    }
    @GetMapping("/all")

    public List<Employee> all (){
        return service.all();
    }

}

