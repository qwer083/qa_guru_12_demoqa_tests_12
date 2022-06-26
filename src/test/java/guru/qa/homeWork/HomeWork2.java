package guru.qa.homeWork;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;


public class PracticeFormPageObject {


    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
    }


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