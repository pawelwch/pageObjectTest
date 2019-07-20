package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ContactUs extends PageObject{

    public ContactUs(WebDriver driver){
        super(driver);
    }

    @FindBy(css = "div.alert") private WebElement errorAlert;
    @FindBy(id = "id_contact") private WebElement subjectSelect;
    @FindBy(id = "email") private WebElement emailInput;
    @FindBy(id = "id_order") private WebElement idOrderInput;
    @FindBy(id = "message") private WebElement messageInput;
    @FindBy(id = "submitMessage") private WebElement submitMessageButton;
    @FindBy(css = "p.alert-success") private WebElement successAlert;

    public ContactUs selectSubject(){
        new Select(subjectSelect).selectByIndex(1);
        return this;
    }

    public ContactUs enterEmail(){
        emailInput.sendKeys("test@test.com");
        return this;
    }

    public ContactUs enterMessage(){
        messageInput.sendKeys("Hello from message!");
        return this;
    }

    public ContactUs enterOrder(){
        idOrderInput.sendKeys("123123");
        return this;
    }

    public ContactUs clickOnSendMessage(){
        submitMessageButton.click();
        return this;
    }

    public WebElement getErrorAlert(){
        return errorAlert;
    }

    public boolean isSuccessAlertDisplayed(){
        return successAlert.isDisplayed();
    }

    public boolean isAlertDisplayed(){
        return getErrorAlert().isDisplayed();
    }
}
