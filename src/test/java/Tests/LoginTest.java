package Tests;

import PageObjects.Login;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;

/**
 * Created by User on 03.05.2016.
 */
public class LoginTest {

    @DataProvider
    public Object[][] testData() {
        return new Object[][] {
                new Object[] {"","","Your username is invalid!\n" + "×"},
                new Object[] {"","SuperSecretPassword!","Your username is invalid!\n" + "×"},
                new Object[] {"tomsmith","","Your password is invalid!\n" + "×"},
                new Object[] {"WrongUserName","SuperSecretPassword!","Your username is invalid!\n" + "×"},
                new Object[] {"tomsmith","WrongUserName","Your password is invalid!\n" + "×"},
                new Object[] {"WrongUserName","WrongUserName!","Your username is invalid!\n" + "×"},
        };
    }

//    @BeforeTest
//    public void setup(){
//        open("http://the-internet.herokuapp.com/login");
//    }

    @Test(dataProvider = "testData")
    public void loginTest(String username, String password, String infoMessage) {
        open("http://the-internet.herokuapp.com/login");
        Login loginPage = new Login();

        loginPage.setLogin(username).setPassword(password).clickLogin();
        Assert.assertEquals(loginPage.infoMessage(), infoMessage);
        close();
    }

//    @AfterTest
//    public void closeWindow(){
//        close();
//    }
}
