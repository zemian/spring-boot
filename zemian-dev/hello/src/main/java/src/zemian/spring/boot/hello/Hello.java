package zemian.spring.boot.hello;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.beans.factory.annotation.*;

@EnableAutoConfiguration
public class Hello implements CommandLineRunner  {
    Hello helloBean() {
        return new Hello();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Hello.class, args);
    }
    
    @Autowired
    private Hello hello;
    
    @Override
    public void run(String ... args) {
        hello.sayHello();
    }
    
    public void sayHello() {
        System.out.println("Hello World!!!");
    }
}