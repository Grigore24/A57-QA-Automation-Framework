import POM.BasePage;
import POM.LoginPage;
import POM.PlaylistPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeletePlaylist extends BaseTest {

    @Test
    public void deleteNewPlaylist() {
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
        // delete playlist
        playlistPage.clickDeletePlaylistBtn();
        // verify banner
        Assert.assertTrue(basepage.IsSuccesBannerDisplayed());
        // refresh page
        basepage.refreshPage();
        // get all playlist elements
        // List<String> playlistNames = playlistPage.getPlaylistNames();
        // assert playlist was deleted
        Assert.assertFalse(playlistPage.getPlaylistNames()
                .contains(playlistPage.generateRandomPlaylistName()));
    }

}