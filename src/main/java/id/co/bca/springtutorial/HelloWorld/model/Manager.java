package id.co.bca.springtutorial.HelloWorld.model;

import org.springframework.stereotype.Component;

@Component
public class Manager implements Employee{
    @Override
    public String salary() {
        return "Rp. 16,000,000";
    }
}
