package Tests;

//     Задание 3. Написать тест с наведение мыши для https://the-internet.herokuapp.com/hovers.

import PageObjects.Hover;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static com.codeborne.selenide.Selenide.open;

public class HoverTest {

    @BeforeClass
    public void BeforeTest(){
        open("http://the-internet.herokuapp.com/hovers");
    }

    @Test
    public void hoverTest(){
        Hover hover = new Hover();
        hover.getActions();

        Assert.assertTrue(hover.AssertElemenet());
    }
}
