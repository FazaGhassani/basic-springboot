package id.co.bca.springtutorial.HelloWorld.model;

import org.springframework.stereotype.Component;

@Component
public class Supervisor implements Employee{
    @Override
    public String salary() {
        return "Rp. 8,000,000";
    }
}
