package StepDefinition;

import Page.RegistrationPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RegistrationSteps {
    protected static WebDriver driver;
    RegistrationPage register;

    @Given("User is on the Registration page")
    public void user_is_on_the_registration_page() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remove-allow-origins=*");
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.get("https://www.way2automation.com/way2auto_jquery/registration.php#load_box");
        driver.manage().window().maximize();
        register = new RegistrationPage(driver);
        System.out.println("Registration page is opened");

    }
    @When("User enters random data entries for the requested fields that meet the required validation")
    public void user_enters_random_data_entries_for_the_requested_fields_that_meet_the_required_validation(){
        register.enterFirstName("Bandile");
        register.enterLastName("Myeni");
        register.selectMaritalStatus();
        register.selectHobby();
        register.selectCountry("India");
        register.selectDateOfBirth("1","1","2014");
        register.enterPhoneNumber("0685113379");
        register.enterUsername("badzmyeni");
        register.enterEmail("badzmyeni@gmail.com");
        register.chooseFile("C:/Users/BandileMyeni/OneDrive - Ocule IT/Desktop/Java Testing Frameworks.gif");
        register.writeAboutYourself("I love myself");
        register.enterPassword("Lwandle01$");
        register.enterConfirmPassword("Lwandle01$");
    }
    @Then("User clicks submit button")
    public void user_clicks_submit_button()  {
        register.clickSubmit();
    }
}
