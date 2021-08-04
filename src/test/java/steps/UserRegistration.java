package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import tests.TestBase;


public class UserRegistration {

    HomePage homePage;


    @Given("^The user is in the home page$")
    public void the_user_is_in_the_home_page() throws Throwable {
        homePage = new HomePage(TestBase.driver);
        homePage.openRegisterPage();
    }

    @When("^I click on register link$")
    public void i_click_on_register_link() throws Throwable {
        System.out.println("When");
    }

    @When("^I entered the user data$")
    public void i_entered_the_user_data() throws Throwable {
        System.out.println("When 2");

    }

    @Then("^The registration page is displayed successfully$")
    public void the_registration_page_is_displayed_successfully() throws Throwable {
        System.out.println("Then");

    }
}