package TestP.model;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class Nav {

    public void goToFormsPage(){
        $(By.xpath("(//*[@class='avatar mx-auto white'])[2]")).click();
    }

    public void goToForm(){
        $(By.xpath("//*[@class='text'][contains(.,'Practice Form')]")).click();
    }
}
