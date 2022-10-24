package id.co.bca.springtutorial.HelloWorld.service;

import id.co.bca.springtutorial.HelloWorld.model.EmployeeModel;

import java.util.List;

public interface IEmployeeService {
    void insert (EmployeeModel employee);
    void update (EmployeeModel employee);
    void delete (EmployeeModel employee);
    EmployeeModel findEmployee(EmployeeModel employee);
    List<EmployeeModel> allEmployees();
    List<EmployeeModel> allEmployeesPage(int page, int size);
}
