package id.co.bca.springtutorial.HelloWorld.service;

import id.co.bca.springtutorial.HelloWorld.model.EmployeeModel;
import id.co.bca.springtutorial.HelloWorld.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

//class ini digunakan untuk menghubungkan antara controller ke jpa dan database
@Service
public class EmployeeService {
    @Autowired
    @Qualifier("employeeRepoImplWithJDBCTemplate") //kalau pake employeeRepoImplWithJDBCTemplate lebih simple jadi ga butuh
    private IEmployeeRepository iEmployeeRepository;
    //@Qualifier("employeeRepoJDBCBasic")

    //tambahan method insert untuk insert di database
    //disini bisa tambah untuk ngejagain data biar yang masuk ke db sudah clean
    //atau bikin query complex
    public void insertEmployee(EmployeeModel employee){
        iEmployeeRepository.create(employee);
    }

    public List<EmployeeModel> allEmployees(){
        return iEmployeeRepository.retrieveAll();
    }
}
