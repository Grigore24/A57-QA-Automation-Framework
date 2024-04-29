import POM.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestRegistrationLink extends BaseTest {
    @Test
    public void testRegistrationNavigation(){
        LoginPage loginPage = new LoginPage(driver);
        String expectedRegistrationUrl = "https://qa.koel.app/registration";
        loginPage.findRegistrationLink();
        Assert.assertEquals(driver.getCurrentUrl(), expectedRegistrationUrl);

    }

}