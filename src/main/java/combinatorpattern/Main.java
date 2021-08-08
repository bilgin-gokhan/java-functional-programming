package combinatorpattern;

import combinatorpattern.CustomerRegistrationValidator.ValidationResult;

import java.time.LocalDate;

import static combinatorpattern.CustomerRegistrationValidator.isAnAdult;
import static combinatorpattern.CustomerRegistrationValidator.isPhoneNumberValid;

public class Main {

    public static void main(String[] args) {
        Customer customer = new Customer(
                "Alice",
                "alicexyz.com",
                "+082947529845",
                LocalDate.of(2000, 1, 1)
        );

        System.out.println(new CustomerValidatorService().isValid(customer));

        // Using combinator pattern
        ValidationResult result = CustomerRegistrationValidator
                .isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAnAdult())
                .apply(customer);

        System.out.println(result);

        if (result != ValidationResult.SUCCESS) {
            throw new IllegalStateException(result.name());
        }
    }
}
