package com.javastart;

import com.javastart.model.Equipment;
import com.javastart.model.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@SpringBootApplication
public class JavastartSpringValidationApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(JavastartSpringValidationApplication.class, args);
        Validator validator = context.getBean(Validator.class);
        Product product1 = new Product("Dell XPS 15", "Laptop 15 calowy z 2021 roku", "PL1354243");
        Set<ConstraintViolation<Product>> productConstraintViolations = validator.validate(product1);
        if (!productConstraintViolations.isEmpty()) {
            System.out.println("Nieprawidłowy produkt. Złamane ograniczenia:");
            productConstraintViolations.stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
        }
        Equipment equipment1 = new Equipment("iPhone 13", "KARNOW123", "EQg3986");
        Set<ConstraintViolation<Equipment>> equipmentConstraintViolation = validator.validate(equipment1);
        if (!equipmentConstraintViolation.isEmpty()) {
            System.out.println("Nieprawidłowe wyposażenie. Złamane ograniczenia:");
            equipmentConstraintViolation.stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
        }
    }
}
