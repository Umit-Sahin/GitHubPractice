package team.step_definitions;
import team.pages.LoginPage;
import team.utilities.ConfigurationReader;
import team.utilities.Drivers;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        String url = ConfigurationReader.get("url");
        Drivers.get().get(url);
    }

    @When("the user enters the verified information")
    public void the_user_enters_the_verified_information() {
//        String username = ConfigurationReader.get("username");
//        String password = ConfigurationReader.get("password");

        LoginPage loginPage = new LoginPage();
//        loginPage.login(username, password);
        loginPage.login();
    }

    @Then("the user should be able to login")
    public void the_user_should_be_able_to_login() throws InterruptedException {
        Thread.sleep(2000);
        String actualTitle = Drivers.get().getTitle();
        Assert.assertEquals("Files - Meetsky - QA", actualTitle);

    }

    @When("the the user logged in {string} and {string}")
    public void the_the_user_logged_in_and(String username, String password) {
        LoginPage loginPage = new LoginPage();
        loginPage.login(username,password);
    }

    @Then("the user should see the message {string}")
    public void the_user_should_see_the_message(String expectedMessage) {
        Assert.assertEquals(expectedMessage,new LoginPage().errorMsg.getText());
    }


}
