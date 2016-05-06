package Tests;

import PageObjects.Alerts;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;


//        Задание 4. **Написать тесты для работы с алертами
//        https://the-internet.herokuapp.com/javascript_alerts. Ожидаю 5 тестов – нажал, что-то ввёл – увидел сообщение на странице. J

public class AlertTest {


    @DataProvider
    public Object[][] testData() {
        return new Object[][] {
                new Object[] {"123456789"},
                new Object[] {"qwertyqwe"},
                new Object[] {"asdfghasd"},
                new Object[] {"zxcvbnzxc"},
                new Object[] {"qwe123asd"},
        };
    }


    @BeforeClass
    public void BeforeTest(){
        open("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @Test(dataProvider = "testData")
    public void alertTest(String alertMessage) {
        String AssertalertMessage = "You entered: " + alertMessage;

        Alerts alertpage = new Alerts();
        alertpage.clickLogin();
        Alert alert = switchTo().alert();
        alert.sendKeys(alertMessage);
        alert.accept();

        Assert.assertEquals(alertpage.AssertresultMessage(), AssertalertMessage);
    }
}
