package models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import pages.constants.GenderTitle;
import pages.constants.SignupCountry;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class SignupInfo {
    private String password;
    private String dateOfBirth;
    private String firstName;
    private String lastName;
    private String company;
    private String address;
    private String state;
    private String city;
    private String phoneNumber;
    private String zipcode;
    private SignupCountry country;
    private GenderTitle genderTitle;

    public LocalDate getDateOfBirth() {
        return LocalDate.parse(dateOfBirth);
    }
}
