package Tests;

import PageObjects.Alerts;
import org.openqa.selenium.Alert;
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


    @Test(dataProvider = "testData")
    public void alertTest(String alertMessage) throws InterruptedException {

        open("https://the-internet.herokuapp.com/javascript_alerts");

        Alerts alertpage = new Alerts();
        alertpage.clickLogin();

        Alert alert = switchTo().alert();
        alert.sendKeys(alertMessage);
        alert.accept();

        alertpage.resultMessage(alertMessage);

        close();
    }
}
