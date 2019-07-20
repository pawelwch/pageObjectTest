import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.ContactUs;
import page.SignIn;
import page.TopMenu;

public class Main {

    private static WebDriver driver;
    private static TopMenu topMenu;
    private static ContactUs contactUs;
    private static SignIn signIn;

    @BeforeAll
    public static void beforeAll(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        topMenu = new TopMenu(driver);
        contactUs = new ContactUs(driver);
        signIn = new SignIn(driver);
    }

    @BeforeEach
    public void beforeEach(){
        driver.get("http://automationpractice.com/");
    }

    @AfterAll
    public static void afterAll(){
        driver.quit();
    }

    @Test
    public void checkTitle(){
        Assertions.assertThat(driver.getTitle()).isEqualTo("My Store");
    }

    @Test
    public void sendMessageWithoutEmail(){
        topMenu.clickOnContactUsButton();
        contactUs.clickOnSendMessage();
        Assertions.assertThat(contactUs.isAlertDisplayed()).isTrue();
    }

    @Test
    public void signUpWithoutEmail(){
        topMenu.clickOnSignInButton();
        signIn.clickOnCreateAccountButton();

        Assertions.assertThat(signIn.isCreateAccountErrorDisplayed()).isTrue();
    }

    @Test
    public void sendMessageUsMessage(){
        topMenu.clickOnContactUsButton();
        contactUs.selectSubject()
            .enterEmail()
            .enterOrder()
            .enterMessage()
            .clickOnSendMessage();

        Assertions.assertThat(contactUs.isSuccessAlertDisplayed()).isTrue();
    }
}
