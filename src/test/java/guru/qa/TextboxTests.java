package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextboxTests {

    @BeforeAll
    static void setUp() {

        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080 ";
    }


    @Test
    void fillFormTest() {

        String name = "Alex Egorov";

        open("/text-box");

      $("[id=userName]").setValue(name);
      $("[id=userEmail]").setValue("alex@egorov.com");
      $("[id=currentAddress]").setValue("Some street 1");
      $("[id=permanentAddress]").setValue("Another street 2");
      $("[id=submit]").click();

      $("[id=output]").shouldHave(text(name), text("alex@egorov.com"),
              text("Some street 1"), text("Another street 2"));

        $("[id=output] [id=name]").shouldHave(text(name));

        $("[id=output]").$("[id=name]").shouldHave(text(name));

    }
}
