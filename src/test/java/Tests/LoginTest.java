package Tests;

import PageObjects.Login;
import org.testng.Assert;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;

//        Задание 1. Написать тесты, покрывающие функциональность логина https://the-internet.herokuapp.com/login (минимум 4 теста)
//        Обязательное использование Selenide, все тесты внутри одного класса, использование Page Object, DDT, Before/After методы


public class LoginTest {

    @DataProvider
    public Object[][] testData() {
        return new Object[][] {
                new Object[] {"","","Your username is invalid!"},
                new Object[] {"","SuperSecretPassword!","Your username is invalid!"},
                new Object[] {"WrongUserName","SuperSecretPassword!","Your username is invalid!"},
                new Object[] {"WrongUserName","WrongUserName!","Your username is invalid!"},
                new Object[] {"tomsmith","","Your username is invalid!"},
                new Object[] {"tomsmith","WrongUserName!","Your username is invalid!"},

        };
    }

    @BeforeClass
    public void BeforeTest(){
        open("http://the-internet.herokuapp.com/login");
    }

    @Test(dataProvider = "testData")
    public void loginTest(String username, String password, String assertinfoMessage) {

        Login loginPage = new Login();
        loginPage.clickLogin();
        loginPage.setLogin(username).setPassword(password).clickLogin();

        Assert.assertTrue(loginPage.AssertInfoMessage(assertinfoMessage));

    }

    @AfterTest
    public void afterTest() {
        close();
    }

}
