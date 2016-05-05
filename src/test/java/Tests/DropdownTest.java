package Tests;

import PageObjects.Dropdown;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;


//        Задание 2. Расширяем проект, добавляем тесты для выпадающих списков
//        - https://the-internet.herokuapp.com/dropdown. Первый тест, выбираем
//        опцию по тексту Option 1, после выбора проверяем, что выбрано значение “1” (НЕ ТЕКСТ!!!).
//        Второй тест, выбираем опцию по значению “2”, после проверяем, что выбрана опция с текстом “Option 2”.

public class DropdownTest {


    @BeforeTest
    public void BeforeTest(){
        open("http://the-internet.herokuapp.com/dropdown");
    }

    @Test
    public void dropdowntTest() throws InterruptedException {
        Dropdown  dropdown = new Dropdown();
        Select select = new Select(dropdown.getSelect());

        select.selectByVisibleText("Option 1");
        Assert.assertEquals(select.getFirstSelectedOption().getAttribute("value"),"1");

        select.selectByVisibleText("Option 2");
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"Option 2");
    }
}
