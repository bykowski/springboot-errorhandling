package pl.bykowski.springbooterrorhandling;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleApi {

    @GetMapping("/sayHello")
    public String sayHello(@RequestParam String name) {
        if (name.length() <= 1) {
            throw new IncorrectNameException();
        }
        return "Hello " + name;
    }
}



