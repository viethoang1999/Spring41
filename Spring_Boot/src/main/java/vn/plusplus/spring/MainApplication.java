package vn.plusplus.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        System.out.println("Staring Spring Boot Application");
        SpringApplication.run(MainApplication.class,args);
        System.out.println("Stared Spring Boot Application");
    }
}
