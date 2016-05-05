package PageObjects;

import com.codeborne.selenide.Condition;

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
        $(byText(get("HoverPage.hoversTitle"))).waitUntil(Condition.enabled,4000);
        return this;
    }

}
