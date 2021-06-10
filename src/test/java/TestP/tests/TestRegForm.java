package TestP.tests;
import TestP.model.Nav;
import TestP.model.RegForm;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class TestRegForm {

    Nav nav = new Nav();
    private RegForm regForm;

    @BeforeSuite
    public void setup() {
        regForm = open("https://demoqa.com/", RegForm.class);
        nav.goToFormsPage();
        nav.goToForm();
    }


    @Test(groups="positive")
    public void fillTheForm(){
        regForm.register("Andriy", "Prokopchyk", "2223332233");
    }

    @Test(groups="negative")
    public void requiredFields(){
        regForm.requiredFields();
    }

}
