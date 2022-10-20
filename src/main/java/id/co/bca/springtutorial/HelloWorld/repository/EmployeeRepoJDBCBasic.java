package id.co.bca.springtutorial.HelloWorld.repository;

import id.co.bca.springtutorial.HelloWorld.datasource.MySQLDataSource;
import id.co.bca.springtutorial.HelloWorld.model.EmployeeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

//beans
@Repository
public class EmployeeRepoJDBCBasic implements IEmployeeRepository{

    @Autowired
    MySQLDataSource mySQLDataSource;

    @Override
    public void create(EmployeeModel employee) {
        mySQLDataSource.insertEmployee(employee);
    }

    @Override
    public List<EmployeeModel> retrieveAll() {
        return mySQLDataSource.getAllEmployee();
    }

    @Override
    public EmployeeModel retrieveUnique(EmployeeModel employee) {
        return null;
    }

    @Override
    public void update(EmployeeModel employee) {

    }

    @Override
    public void deleteUnique(EmployeeModel employee) {

    }
}
