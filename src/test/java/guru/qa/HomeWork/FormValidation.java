package guru.qa.HomeWork;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FormValidation {

    @BeforeAll
    static void prepare() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void execute() {
        LocalDate birth = LocalDate.of(1986, 10, 13);
        String firstName = "Anna";
        String lastName = "Ivanova";
        String email = "Anna@mail.ru";
        String gender = "Female";
        String phoneNumber = "41541563";
        String subject = "English";
        String hobby = "Reading";
        String imgPath = "img.jpg/test.png";
        String address = "NCR, Noida, 153126";
        String state = "NCR";
        String city = "Noida";
        String month = birth.getMonth().toString().charAt(0)                 //получаем из даты название месяца
                + birth.getMonth().toString().substring(1).toLowerCase();
        SelenideElement stateCity = $("#stateCity-wrapper");        //переменная для часто используемого селектора
        ArrayList<SelenideElement> actions = new ArrayList<>();              // коллекция селекторов для обёртки stateCity
        actions.add(stateCity.$(byText("Select State")));
        actions.add(stateCity.$(byText(state)));
        actions.add(stateCity.$(byText("Select City")));
        actions.add(stateCity.$(byText(city)));


        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(phoneNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(String.valueOf(birth.getYear()));
        $("[aria-label$='" + month + " " + birth.getDayOfMonth() + "th, " + birth.getYear() + "']").click();
        $("#subjectsInput").setValue(subject).pressEnter();
        $("#hobbiesWrapper").$(byText(hobby)).click();
        $("#uploadPicture").uploadFromClasspath(imgPath);
        $("#currentAddress").setValue(address);
        for (SelenideElement selenideElement : actions) {
            selenideElement.click();
        }
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(
                text(firstName + " " + lastName),
                text(email),
                text(gender),
                text(phoneNumber),
                text(birth.getDayOfMonth() + " " + month + "," + birth.getYear()),
                text(subject),
                text(hobby),
                text(imgPath.substring(4)),
                text(address),
                text(state + " " + city)
        );
    }
}
