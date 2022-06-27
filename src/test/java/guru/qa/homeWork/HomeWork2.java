package guru.qa.homeWork;


import com.github.javafaker.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.formValidation.*;

import static java.lang.String.format;
import static utils.RandomUtils.*;


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
    <RegistrationFormPage>
    void fillFormTest() {
        RegistrationFormPage registrationFormPage = new RegistrationFormPage();
        registrationFormPage.openPage()
                .setFirstName()
                .setLastName()
                .setUserEmail()
                .setGender()
                .setUserNumber()
                .setBirthDay()
                .setSubject()
                .setHobby()
                .uploadPicture()
                .setAddress()
                .setState()
                .setCity()
                .submit()
                .checkResult();

    }
}