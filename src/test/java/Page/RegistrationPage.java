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
        System.out.println("LastName is entered");
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
        System.out.println("PhoneNumber is entered");
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
        System.out.println("File if uploaded");
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
        System.out.println("Submit button has been clicked successful");
        driver.quit();
    }

}
