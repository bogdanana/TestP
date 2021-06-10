package TestP.model;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.impl.PageObjectFactory;
import com.sun.tools.javah.Gen;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.codeborne.selenide.Selenide.$;

public class RegForm{

    @FindBy(id = "firstName")
    public SelenideElement FirstName;

    @FindBy(id = "lastName")
    public SelenideElement LastName;

    @FindBy(xpath = "//*[@class='custom-control-label'][contains(.,'Male')]")
    public SelenideElement Gender;

    @FindBy(id = "userNumber")
    public SelenideElement UserNumber;

    @FindBy(id = "submit")
    public SelenideElement Submit;

    @FindBy(xpath = "//*[@class='modal-title h4'][contains(.,'Thanks for submitting the form')]")
    public SelenideElement SuccessModal;

    public void setFirstName(String name) {
        $(FirstName).setValue(name);
    }

    public void setLastName(String surname) {
        $(LastName).setValue(surname);
    }

    public void setUserNumber(String number) {
        $(UserNumber).setValue(number);
    }

    public void setGender(){
        $(Gender).click();
    }

    public void submit(){
        $(Submit).scrollIntoView(true).click();
    }

    public void successModal(){
        $(SuccessModal).should(Condition.appear);
    }


    public void register(String firstName, String lastName, String userNumber) {
        setFirstName(firstName);
        setLastName(lastName);
        setGender();
        setUserNumber(userNumber);
        submit();
        successModal();
    }

    public void requiredFields(){
        Selenide.refresh();
        submit();
        FirstName.scrollIntoView(true).shouldHave(Condition.cssValue("border-color", "rgb(220, 53, 69)"));
        LastName.shouldHave(Condition.cssValue("border-color", "rgb(220, 53, 69)"));
        Gender.shouldHave(Condition.cssValue("color", "rgba(220, 53, 69, 1)"));
        UserNumber.shouldHave(Condition.cssValue("border-color", "rgb(220, 53, 69)"));
    }

}
