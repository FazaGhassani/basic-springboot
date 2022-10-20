package id.co.bca.springtutorial.HelloWorld.controller;

import id.co.bca.springtutorial.HelloWorld.model.EmployeeModel;
import id.co.bca.springtutorial.HelloWorld.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("employee") //jadinya localhost:8080/employee/...
public class EmployeeController {

    @Autowired
    EmployeeService employeeService; //manggil service di controller

    @GetMapping("/add")
    public String addEmployee(@RequestParam("firstname") String firstname,
                              @RequestParam("lastname") String lastname,
                              @RequestParam("email") String email){
        EmployeeModel employeeModel = new EmployeeModel();
        employeeModel.setId(0);
        employeeModel.setFirstName(firstname);
        employeeModel.setLastName(lastname);
        employeeModel.setEmail(email);
        employeeService.insertEmployee(employeeModel);
        return null;
    };

    @GetMapping("/getAllEmployee")
    public @ResponseBody List<EmployeeModel> findall(){
        return employeeService.allEmployees();
    }
}
