package id.co.bca.springtutorial.HelloWorld.controller;

import id.co.bca.springtutorial.HelloWorld.config.Api;
import id.co.bca.springtutorial.HelloWorld.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("")
public class HelloController {

    //buat Logger
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    //memanggil message dari application.properties
    @Value("${spring.message}")
    private String message;

    //manggil interface employee karena sudah di anotasi @Component
    @Autowired
    @Qualifier("supervisor")
    Employee employee;

    @Autowired
    Api api;

    @GetMapping("/hello")
    public @ResponseBody String hello(){
        return "Hello World!";
    }

    @GetMapping("/hell-o")
    public @ResponseBody String helloo(){
        return "Hell-o >:)";
    }

    @GetMapping("/salary")
    public @ResponseBody String salary(){
        return employee.salary();
    }

    @GetMapping("/message")
    public @ResponseBody String message(){
        return message;
    }

    @GetMapping("/api")
    public @ResponseBody String api(){
        LOGGER.info("Calling Get Method /api");
        return api.getDataType();
    }
}
