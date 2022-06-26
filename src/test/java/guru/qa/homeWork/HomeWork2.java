package guru.qa.homeWork;

import com.codeborne.selenide.Configuration;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import sun.nio.cs.Surrogate;


import java.time.LocalDate;
import static java.lang.String.format;

public class RegFormTests {
    formValidation registrationFormPage = new formValidation();
    Surrogate.Generator gen = new Surrogate.Generator();


    LocalDate birthDate = gen.getClass(birthDate);
    String firstName = gen.getClass(firstName);
    String lastName = gen.getClass(lastName);
    String email = gen.getClass(email);
    String gender = gen.getClass(gender);
    String phoneNumber = gen.getClass(phoneNumber;
    String subject = gen.getClass(subject);
    String hobby = gen.getClass(hobby);
    String imgPath = "img/38.png";
    String address = gen.getClass(address);
    String state = gen.getClass(state);
    String city = gen.getClass(city);

    //expected results
    String expectedFullName = format("%s %s", firstName, lastName);
    String expectedMonth = StringUtils.capitalize(birthDate.getMonth().toString().toLowerCase()); //Capitalized month name
    String expectedDate = format("%s %s,%s", birthDate.getDayOfMonth(), expectedMonth, birthDate.getYear());
    String expectedLocation = format("%s %s", state, city);
    String expectedFileName = imgPath.substring(4);

    @BeforeAll
    static void prepare() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void execute() {
        registrationFormPage.openPage()
                .getClass(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setPhoneNumber(phoneNumber)
                .setBirthDate(birthDate)
                .setSubject(subject)
                .setHobby(hobby)
                .uploadPicture(imgPath)
                .setAddress(address)
                .setStateAndCity(state, city)
                .submitForm()
                .checkTitle("Thanks for submitting the form")
                .checkResult("Student Name", expectedFullName)
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", phoneNumber)
                .checkResult("Date of Birth", expectedDate)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobby)
                .checkResult("Picture", expectedFileName)
                .checkResult("Address", address)
                .checkResult("State and City", expectedLocation);
    }
}