package id.co.bca.springtutorial.HelloWorld.service;

import id.co.bca.springtutorial.HelloWorld.model.EmployeeModel;
import id.co.bca.springtutorial.HelloWorld.repository.EmployeeSDJRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceJPA implements IEmployeeService{
    @Autowired
    EmployeeSDJRepository sdjRepository;
    @Override
    public void insert(EmployeeModel employee) {
        sdjRepository.save(employee);
    }

    @Override
    public void update(EmployeeModel employee) {
        sdjRepository.save(employee);
    }

    @Override
    public void delete(EmployeeModel employee) {
        sdjRepository.deleteById(employee.getId());
    }

    @Override
    public EmployeeModel findEmployee(EmployeeModel employee) {
        return sdjRepository.findEmployeeModelById(employee.getId());
    }

    @Override
    public List<EmployeeModel> allEmployees() {
        return sdjRepository.findAllByOrderByLastName();
    }

    @Override
    public List<EmployeeModel> allEmployeesPage(int page, int size) {
        Pageable pageable = PageRequest.of(page,size);
        return sdjRepository.findAll(pageable).getContent();
    }
}
