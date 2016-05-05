package PageObjects;

import com.codeborne.selenide.Condition;

import static Helpers.Locator.get;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

/**
 * Created by User on 03.05.2016.
 */
public class Login {

    public Login setLogin(String username){
        $(get("LoginPage.loginInput")).waitUntil(Condition.enabled,4000);
        $(get("LoginPage.loginInput")).setValue(username);
        return this;
    }

    public Login setPassword(String password){
        $(get("LoginPage.passwordInput")).setValue(password);
        return this;
    }

    public Login clickLogin(){
        $(get("LoginPage.loginButton")).click();
        return this;
    }

    public String AssertInfoMessage(){
        return $(get("LoginPage.infoMessage")).getText();
    }
}
