package PageObjects;

import static Helpers.Locator.get;
import static com.codeborne.selenide.Selenide.$;

/**
 * Created by User on 03.05.2016.
 */
public class Login {

    public Login setLogin(String username){
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

    public String infoMessage(){
        return $(get("LoginPage.infoMessage")).getText();
    }
}
