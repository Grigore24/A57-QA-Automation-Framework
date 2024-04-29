import POM.LoginPage;
import POM.SongsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaySong extends BaseTest {
    @Test
    public void playNewSong() {
        LoginPage loginPage = new LoginPage(driver);
        SongsPage songsPage = new SongsPage(driver);
        loginPage.login("grigore.crepciuc@testpro.io", "te$t$tudent");
        songsPage.pressOnPlayBtn();
        //songsPage.isPauseBtnDisplayed();
        //WebElement pauseBtn = waitUntilPresence(By.cssSelector("[data-testid='pause-btn']"));
        //driver.findElement(By.cssSelector("[data-testid='pause-btn']"));
        //wait.until(ExpectedConditions
        //   .presenceOfElementLocated(By.cssSelector("[data-testid='pause-btn']")));
        //(By.cssSelector("[data-testid='pause-btn']"));
        Assert.assertTrue(songsPage.isPauseBtnDisplayed());
        //WebElement equalizer = waitUntilVisible(By.cssSelector("[alt='Sound bars']"));
        Assert.assertTrue(songsPage.isEqualizerDisplayed());
    }

}