package guru.qa.homeWork;


import com.github.javafaker.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.formValidation.*

import java.util.List;

import static java.lang.String.format;
import static utils.RandomUtils.*


public class PracticeFormTest extends formValidation {

    Faker faker = new Faker();
    formValidation registrationForm = new formValidation();

    
   
    String fistName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            fullName = format("%s %s", fistName, lastName),
            gender = faker.getClass(gender),
            email = faker.internet().emailAddress(),
            mobile = faker.getClass(10),
            birthDay = faker.getClass(birthDay),
            birthYear = faker.getClass(birthYear),
            birthMonth = faker.getClass(birthMonth),
            address = faker.address().fullAddress(),
            state = "NCR",
            city = "Noida";

    @Test
    @DisplayName("Fill and submit registration form")
    void fillSubmitCloseRegistrationForm() {
        registrationForm.openPage()
                .setFirstName(fistName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setPhoneNumber(mobile)
                .setDateOfBirth(birthDay, birthMonth, birthYear)
                .setSubjectsWithAutocomplete(subject)
                .setHobbies(hobbie)
                .setPicture("img/38.png")
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .submit()
                .checkTableHeaderHasText("Thanks for submitting the form")
                .checkTableRowHasText("Student Name", fullName)
                .checkTableRowHasText("Student Email", email)
                .checkTableRowHasText("Gender", gender)
                .checkTableRowHasText("Mobile", mobile)
                .checkTableRowHasText("Date of Birth", birthDay + " " + birthMonth + "," + birthYear)
                .checkTableRowHasText("Subjects", String.join(", ", subjectsFull))
                .checkTableRowHasText("Hobbies", String.join(", ", hobbies))
                .checkTableRowHasText("Picture", "cat.png")
                .checkTableRowHasText("Address", address)
                .checkTableRowHasText("Mobile", mobile)
                .checkTableRowHasText("State and City", state + " " + city)
                .closeModal()
                .checkModalClosed();
    }
}}