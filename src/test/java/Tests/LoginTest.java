package Tests;

import PageObjects.Login;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

//        Задание 1. Написать тесты, покрывающие функциональность логина https://the-internet.herokuapp.com/login (минимум 4 теста)
//        Обязательное использование Selenide, все тесты внутри одного класса, использование Page Object, DDT, Before/After методы


public class LoginTest {

    @DataProvider
    public Object[][] testData() {
        return new Object[][] {
                new Object[] {"","","Your username is invalid!\n" + "×"},
                new Object[] {"","SuperSecretPassword!","Your username is invalid!\n" + "×"},
                new Object[] {"WrongUserName","SuperSecretPassword!","Your username is invalid!\n" + "×"},
                new Object[] {"WrongUserName","WrongUserName!","Your username is invalid!\n" + "×"},
                new Object[] {"tomsmith","","Your username is invalid!\n" + "×"},
                new Object[] {"tomsmith","WrongUserName!","Your username is invalid!\n" + "×"},

        };
    }

    @BeforeTest
    public void BeforeTest(){
        open("http://the-internet.herokuapp.com/login");
    }

    @Test(dataProvider = "testData")
    public void loginTest(String username, String password, String AssertinfoMessage) {
        Login loginPage = new Login();
        loginPage.setLogin(username).setPassword(password).clickLogin();

        Assert.assertEquals(loginPage.AssertInfoMessage(), AssertinfoMessage);

    }

    @AfterTest
    public void afterTest() {
        open("http://the-internet.herokuapp.com/");
    }
}
