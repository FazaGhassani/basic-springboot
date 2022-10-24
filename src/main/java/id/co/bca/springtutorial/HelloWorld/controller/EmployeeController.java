package id.co.bca.springtutorial.HelloWorld.controller;

import id.co.bca.springtutorial.HelloWorld.model.EmployeeModel;
import id.co.bca.springtutorial.HelloWorld.service.DepartementAndEmployeeService;
import id.co.bca.springtutorial.HelloWorld.service.EmployeeService;
import id.co.bca.springtutorial.HelloWorld.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("employee") //jadinya localhost:8080/employee/...
public class EmployeeController {

    //@Autowired
    //EmployeeService employeeService; //manggil service di controller

    //kalau pake SJD, pakenya yang ini
    @Autowired
    @Qualifier("employeeServiceJPA")
    private IEmployeeService employeeService; //manggil service yang JPA

    @Autowired
    private DepartementAndEmployeeService departementAndEmployeeService;

    @GetMapping("/add")
    public String addEmployee(@RequestParam("firstname") String firstname,
                              @RequestParam("lastname") String lastname,
                              @RequestParam("email") String email){
        EmployeeModel employeeModel = new EmployeeModel();
        employeeModel.setId(0);
        employeeModel.setFirstName(firstname);
        employeeModel.setLastName(lastname);
        employeeModel.setEmail(email);
        //employeeService.insertEmployee(employeeModel); //kalau pake controller EmployeeService employeeService
        employeeService.insert(employeeModel);
        return null;
    };

    @GetMapping("/getAll")
    public @ResponseBody List<EmployeeModel> findall(){
        return employeeService.allEmployees();
    }

    @GetMapping("/allpage")
    public @ResponseBody List<EmployeeModel> findAllPage(@RequestParam("page") int page, @RequestParam("size") int size){
        return employeeService.allEmployeesPage(page,size);
    }

    @GetMapping("/add-ed")
    public String addEmployee(@RequestParam("firstname") String firstname
        , @RequestParam("lastname") String lastname
        , @RequestParam("email") String email
        , @RequestParam("did") int did){
        EmployeeModel model = new EmployeeModel();
        model.setId(0);
        model.setFirstName(firstname);
        model.setLastName(lastname);
        model.setEmail(email);
        model.setDepartement(null);
        // yang tidak menggunakan @Transactional, tidak berkaidah ACID
        //departementAndEmployeeService.addEmployeeToDepartement(model, did);

        //menggunakan @Transactional, berkaidah ACID
        departementAndEmployeeService.addEmployeeToDepartementWithTransactional(model, did);
        return "redirect:/employee/all";
    }

}
