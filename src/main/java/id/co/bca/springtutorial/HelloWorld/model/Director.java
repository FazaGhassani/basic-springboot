package id.co.bca.springtutorial.HelloWorld.model;

import org.springframework.stereotype.Component;

@Component
public class Director implements Employee{

    @Override
    public String salary() {
        return "Rp. 32,000,000";
    }

}
