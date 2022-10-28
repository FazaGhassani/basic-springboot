package id.co.bca.springtutorial.HelloWorld.controller;

import id.co.bca.springtutorial.HelloWorld.model.EmployeeModel;
import id.co.bca.springtutorial.HelloWorld.repository.EmployeeSDJRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class RestEmployeeController {

    @Autowired
    private EmployeeSDJRepository employeeSDJRepository;
    //disini ga pake EmployeeRepoHybernate, EmployeeRepoImplWithJDBCTemplate dan RmployeeRepoJDBCBasic
    //contoh disini juga ga ada service karena tidak ada custom query / custom code
    //kalau rest API cuman pake Model (employeemodel), EmployeeSDJRepository (Repository), dan controller (RestEmployeeController)
    @PreAuthorize("hasAnyAuthority('admin')")
    @GetMapping("/employeesTest")
    @ResponseStatus(HttpStatus.OK)
    public String findallT() {
        return "hallo";
    }

    @GetMapping("/employees")
    @ResponseStatus(HttpStatus.OK)
    public List<EmployeeModel> findall() {
        return employeeSDJRepository.findAll();
    }

    @GetMapping("/employees/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeModel findEmployeeModelById(@PathVariable("id") int id){
        return employeeSDJRepository.findEmployeeModelById(id);
    }

    @PostMapping("/employees")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeModel addEmployee(@RequestBody EmployeeModel employeeModel){
        return employeeSDJRepository.save(employeeModel);
    }

    @PutMapping("/employees/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeModel updateEmployee(@RequestBody EmployeeModel employeeModel, @PathVariable("id") int id){
        employeeModel.setId(id);
        return employeeSDJRepository.save(employeeModel);
    }

    @DeleteMapping("/employees/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteEmployee(@PathVariable("id") int id){
        employeeSDJRepository.deleteById(id);
    }

}