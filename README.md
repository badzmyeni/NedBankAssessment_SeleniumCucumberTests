# Way2Automation Registration Test Project

## Overview

This project automates the registration process on the Way2Automation website using Selenium WebDriver and Cucumber for BDD (Behavior-Driven Development). The project is structured to allow easy management and scalability of test cases.

## Project Structure

The project consists of the following main components:

1. **Feature File**: Defines the behavior of the registration process in a natural language format.
2. **Page Object Model**: Encapsulates the WebElements and actions for the registration page.
3. **Step Definitions**: Maps the steps from the feature file to the actual Selenium code.
4. **Test Runner**: Configures and runs the Cucumber tests.
5. **pom.xml**: Manages project dependencies and configurations using Maven.

## Feature File

The feature file describes the scenario for a successful registration on the Way2Automation website.

```gherkin
Feature: Registration to Way2automation Website
  As a user I want to do a registration on the Way2automation website so that I can gain access to the website

  Scenario: Successful Registration
    Given User is on the Registration page
    When User enters random data entries for the requested fields that meet the required validation
    Then User clicks submit button

## Page Object Model

package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class RegistrationPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    By txtFirstName = By.xpath("//*[@id=\"register_form\"]/fieldset[1]/p[1]/input");
    By txtLastName = By.xpath("//*[@id=\"register_form\"]/fieldset[1]/p[2]/input");
    By txtPhoneNumber = By.name("phone");
    By txtUsername = By.name("username");
    By txtEmail = By.name("email");
    By txtAboutYourself = By.xpath("//*[@id=\"register_form\"]/fieldset[10]/textarea");
    By txtPassword = By.name("password");
    By txtConfirmPassword = By.name("c_password");
    By btnSubmit = By.xpath("//*[@id=\"register_form\"]/fieldset[13]/input");

    public RegistrationPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterFirstName(String firstName){
        driver.findElement(txtFirstName).sendKeys(firstName);
        System.out.println("First Name is entered");
    }

    public void enterLastName(String lastName){
        driver.findElement(txtLastName).sendKeys(lastName);
        System.out.println("Last Name is entered");
    }

    public void selectMaritalStatus(){
        WebElement mStatus = driver.findElement(By.xpath("//*[@id=\"register_form\"]/fieldset[2]/div/label[2]/input"));
        mStatus.click();
        System.out.println("Marital Status has been checked");
    }

    public void selectHobby(){
        WebElement checkHobby = driver.findElement(By.xpath("//*[@id=\"register_form\"]/fieldset[3]/div/label[1]/input"));
        checkHobby.click();
        System.out.println("Hobby is selected");
    }

    public void selectCountry(String countryName){
        WebElement country = driver.findElement(By.xpath("//*[@id=\"register_form\"]/fieldset[4]/select"));
        Select dropdown = new Select(country);
        dropdown.selectByVisibleText(countryName);
        System.out.println("Country is selected");
    }

    public void selectDateOfBirth(String monthValue, String dayValue, String yearValue) {
        Select selectMonth = new Select(driver.findElement(By.xpath("//*[@id=\"register_form\"]/fieldset[5]/div[1]/select")));
        selectMonth.selectByValue(monthValue);

        Select selectDay = new Select(driver.findElement(By.xpath("//*[@id=\"register_form\"]/fieldset[5]/div[2]/select")));
        selectDay.selectByValue(dayValue);

        Select selectYear = new Select(driver.findElement(By.xpath("//*[@id=\"register_form\"]/fieldset[5]/div[3]/select")));
        selectYear.selectByValue(yearValue);

        System.out.println("Date of Birth is selected");
    }

    public void enterPhoneNumber(String phoneNumber){
        driver.findElement(txtPhoneNumber).sendKeys(phoneNumber);
        System.out.println("Phone Number is entered");
    }
    public void enterUsername(String username){
        driver.findElement(txtUsername).sendKeys(username);
        System.out.println("Username is entered");
    }
    public void enterEmail(String email){
        driver.findElement(txtEmail).sendKeys(email);
        System.out.println("Email is entered");
    }
    public void chooseFile(String filePath){
        WebElement selectProfilePicture = driver.findElement(By.xpath("//*[@id=\"register_form\"]/fieldset[9]/input"));
        selectProfilePicture.sendKeys(filePath);
        System.out.println("File is uploaded");
    }
    public void writeAboutYourself(String aboutYourself){
        driver.findElement(txtAboutYourself).sendKeys(aboutYourself);
        System.out.println("About Yourself is captured");
    }
    public void enterPassword(String password){
        driver.findElement(txtPassword).sendKeys(password);
        System.out.println("Password is entered");
    }
    public void enterConfirmPassword(String confirmPassword){
        driver.findElement(txtConfirmPassword).sendKeys(confirmPassword);
        System.out.println("Confirmation of password has been entered");
    }
    public void clickSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(btnSubmit)).click();
        System.out.println("Submit button has been clicked successfully");
        driver.quit();
    }
}

## Step Definitions

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
        options.addArguments("--remote-allow-origins=*");
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

## Test Runner

package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Feature",
        glue = {"StepDefinition"},
        plugin = {"pretty","html:target/HtmlReports/report.html","json:target/JsonReports/report.json","junit:target/JUnitReports/report.xml"},
        monochrome = true
)
public class TestRunner {
}

## Dependencies POM.xml

<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>org.example</groupId>
    <artifactId>NedBankAssessment_SeleniumCucumberTests</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>11</maven.compiler.source>
        <maven.compiler.target>11</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <!-- https://mvnrepository.com/artifact/io.cucumber/cucumber-java -->
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-java</artifactId>
            <version>7.14.0</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/io.cucumber/cucumber-junit -->
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-junit</artifactId>
            <version>7.14.0</version>
            <scope>test</scope>
        </dependency>

        <!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>4.16.1</version>
        </dependency>


    </dependencies>

</project>
