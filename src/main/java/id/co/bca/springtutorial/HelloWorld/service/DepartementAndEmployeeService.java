package id.co.bca.springtutorial.HelloWorld.service;

import id.co.bca.springtutorial.HelloWorld.model.Departement;
import id.co.bca.springtutorial.HelloWorld.model.EmployeeModel;
import id.co.bca.springtutorial.HelloWorld.repository.DepartementSDJRepository;
import id.co.bca.springtutorial.HelloWorld.repository.EmployeeSDJRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class DepartementAndEmployeeService {

    @Autowired
    DepartementSDJRepository departementSDJRepository;

    @Autowired
    EmployeeSDJRepository employeeSDJRepository;

    //ini ga boleh karena tidak memenuhi kriteria ACID
    public void addEmployeeToDepartement(EmployeeModel employeeModel, int did){
        employeeSDJRepository.save(employeeModel);
        Departement departement = departementSDJRepository.findDepartementById(Integer.valueOf(did));
        departementSDJRepository.save(departement);
        employeeModel.setDepartement(departement);
        employeeSDJRepository.save(employeeModel);
    }

    //pake transactional biar memenuhi kriteria ACID
    @Transactional
    public void addEmployeeToDepartementWithTransactional(EmployeeModel employeeModel, int did){
        //employeeSDJRepository.save(employeeModel);
        Departement departement = departementSDJRepository.findDepartementById(Integer.valueOf((did)));
        departementSDJRepository.save(departement);
        employeeModel.setDepartement(departement);
        employeeSDJRepository.save(employeeModel);
    }
}
