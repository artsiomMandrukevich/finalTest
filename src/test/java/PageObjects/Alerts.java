package PageObjects;

import com.codeborne.selenide.Condition;

import static Helpers.Locator.get;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

/**
 * Created by User on 04.05.2016.
 */
public class Alerts {

    public Alerts clickLogin(){
        $(byText(get("AlertPage.JSProm"))).click();
        return this;
    }

    public void resultMessage(String alertResult){
        $(get("AlertPage.Result")).shouldHave(text(alertResult));
    }
}
