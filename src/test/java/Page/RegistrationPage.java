package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {
    private final WebDriver driver;

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
    }

    public void enterFirstName(){
        driver.findElement(txtFirstName).sendKeys("Bandile");
        System.out.println("First Name is entered");
    }
    public void enterLastName(){
        driver.findElement(txtLastName).sendKeys("Myeni");
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
    public void selectCountry(){
        WebElement country = driver.findElement(By.xpath("//*[@id=\"register_form\"]/fieldset[4]/select"));
        Select dropdown = new Select(country);
        dropdown.selectByVisibleText("India");
        System.out.println("Country is selected");
    }
    public void selectDateOfBirth() throws InterruptedException {
        WebElement month = driver.findElement(By.xpath("//*[@id=\"register_form\"]/fieldset[5]/div[1]/select"));
        Select selectMonth = new Select(month);
        selectMonth.selectByValue("1");
        Thread.sleep(2000);

        WebElement day = driver.findElement(By.xpath("//*[@id=\"register_form\"]/fieldset[5]/div[2]/select"));
        Select selectDay = new Select(day);
        selectDay.selectByValue("1");
        Thread.sleep(2000);

        WebElement year = driver.findElement(By.xpath("//*[@id=\"register_form\"]/fieldset[5]/div[3]/select"));
        Select selectYear = new Select(year);
        selectYear.selectByValue("2014");

        System.out.println("Date of Birth is selected");
    }
    public void enterPhoneNumber(){
        driver.findElement(txtPhoneNumber).sendKeys("0685113379");
        System.out.println("PhoneNumber is entered");
    }
    public void enterUsername(){
        driver.findElement(txtUsername).sendKeys("badzmyeni");
        System.out.println("Username is entered");
    }
    public void enterEmail(){
        driver.findElement(txtEmail).sendKeys("badzmyeni@gmail.com");
        System.out.println("Email is entered");
    }
    public void chooseFile(){
        WebElement selectProfilePicture = driver.findElement(By.xpath("//*[@id=\"register_form\"]/fieldset[9]/input"));
        String filePath = "C:/Users/BandileMyeni/OneDrive - Ocule IT/Desktop/Java Testing Frameworks.gif";
        selectProfilePicture.sendKeys(filePath);
        System.out.println("File if uploaded");
    }
    public void writeAboutYourself(){
        driver.findElement(txtAboutYourself).sendKeys("I love my self");
        System.out.println("About Yourself is captured");
    }
    public void enterPassword(){
        driver.findElement(txtPassword).sendKeys("Lwandle01$");
        System.out.println("Password is entered");
    }
    public void enterConfirmPassword(){
        driver.findElement(txtConfirmPassword).sendKeys("Lwandle01$");
        System.out.println("Confirmation of password has been entered");
    }
    public void clickSubmit() throws InterruptedException {
        driver.findElement(btnSubmit).click();
        Thread.sleep(4000);
        System.out.println("Submit button has been clicked successful");
        driver.quit();
    }

}
