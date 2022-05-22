package guru.qa.tests;

import org.junit.jupiter.api.*;

public class JUnit5Tests {
@BeforeAll
static void initDB() {
    System.out.println("### @BeforeAll");
}


    @BeforeEach
    void openYAPage() {
        System.out.println("###     @BeforeEach");
       // Selenide.open("https://ya.ru");
    }
    @AfterEach
    void close() {
        System.out.println("###     @AfterEach");
      //  WebDriverRunner.closeWindow();
    }

    @AfterAll
    static void cleanDB() {
        System.out.println("### @AfterAll");
    }

    @Test
    void assertTest1() {
        System.out.println("###      @Test 0");
        // ... поиск в новостях
    }

        @Test
        void assertTest2() {
            System.out.println("###      @Test 1");
            // ... поиск в картинках
    }

    @Test
    void assertTest3() {
        System.out.println("###      @Test 2");
        // ... поиск в новостях
    }

    @Test
    void assertTest4() {
        System.out.println("###      @Test 3");
        // ... поиск в новостях
    }
}
