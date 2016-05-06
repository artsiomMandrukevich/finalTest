package PageObjects;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static Helpers.Locator.get;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

/**
 * Created by User on 05.05.2016.
 */
public class Hover {

    public Hover getActions(){
        $(byText(get("HoverPage.hoversTitle"))).waitUntil(Condition.enabled,4000);
        $(get("HoverPage.avatar")).hover();
        return this;
    }

    public boolean AssertElemenet(){
        $(By.xpath(get("HoverPage.user1text"))).waitUntil(Condition.enabled,4000);
        return $(By.xpath(get("HoverPage.user1text"))).find("div a").exists();
    }
}


