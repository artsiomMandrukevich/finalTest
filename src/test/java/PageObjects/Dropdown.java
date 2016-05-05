package PageObjects;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.WebElement;

import static Helpers.Locator.get;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

/**
 * Created by User on 05.05.2016.
 */
public class Dropdown {

    public WebElement getSelect(){
        $(byText(get("DropdownPage.dropdownlist"))).waitUntil(Condition.enabled,4000);
        return $(get("DropdownPage.dropdown")).toWebElement();
    }
}
