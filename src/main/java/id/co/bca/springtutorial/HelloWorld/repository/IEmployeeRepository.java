package id.co.bca.springtutorial.HelloWorld.repository;

import id.co.bca.springtutorial.HelloWorld.model.EmployeeModel;
import java.util.List;

public interface IEmployeeRepository {
    //ini adalah interfase untuk bikin CRUD ke database
    void create(EmployeeModel employee); //get
    List<EmployeeModel> retrieveAll(); //get all
    EmployeeModel retrieveUnique(EmployeeModel employee); //get one employee
    void update(EmployeeModel employee); //update one employee
    void deleteUnique(EmployeeModel employee); //delete one employee
}
