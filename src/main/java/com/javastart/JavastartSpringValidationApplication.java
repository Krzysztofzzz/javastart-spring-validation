package com.javastart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.time.LocalDate;
import java.util.Set;

@SpringBootApplication
public class JavastartSpringValidationApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(JavastartSpringValidationApplication.class, args);
        Validator validator = context.getBean(Validator.class);
        Person person = new Person(
                "Jan",
                "Kowalski",
                "87041277815",
                LocalDate.of(1987, 4, 12),
                "jan@kowalski.xyz",
                "Qwerty87",
                "https://kowalski.xyz"
        );
        Set<ConstraintViolation<Person>> constraintViolations = validator.validate(person);
        if (!constraintViolations.isEmpty()) {
            System.out.println("Obiekt jest nieprawidłowy. Złamane ograniczenia:");
            for (ConstraintViolation<Person> violation : constraintViolations) {
                System.out.printf(" > %s %s (%s)\n",
                        violation.getPropertyPath(),
                        violation.getMessage(),
                        violation.getInvalidValue());
            }
        }else {
            System.out.println("Dane osobowe są poprawne.");
        }
    }
}

