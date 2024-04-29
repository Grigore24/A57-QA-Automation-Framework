import POM.BasePage;
import POM.LoginPage;
import POM.PlaylistPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
public class CreatePlaylist extends BaseTest {
    @Test
    public void createPlaylistUsePlusBtn() {
        LoginPage loginPage = new LoginPage(driver);
        PlaylistPage playlistPage = new PlaylistPage(driver);
        BasePage basepage = new BasePage(driver);
        String playlist = playlistPage.generateRandomPlaylistName();
        loginPage.login("grigore.crepciuc@testpro.io", "te$t$tudent");
        // CREATE PLAYLIST
        // click Plus btn
        // click Create new playlist
        // Add playlist name
        playlistPage.createNewPlaylistUsingPlusBtn(playlist);
        // check playlist name in header
        playlistPage.checkPlayListHeader(playlist);
        // verify banner
        Assert.assertTrue(basepage.IsSuccesBannerDisplayed());
    }
}
