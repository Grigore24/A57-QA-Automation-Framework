import POM.LoginPage;
import POM.PlaylistPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class RenamePlaylist extends BaseTest {

    @Test
    public void renameNewPlaylist() {
        // double click
        String playlistName = "Sun And Wind";
        LoginPage loginPage = new LoginPage(driver);
        PlaylistPage playlistPage = new PlaylistPage(driver);
        loginPage.login("grigore.crepciuc@testpro.io", "te$t$tudent");
        playlistPage.doubleClickChoosePlaylist();
        playlistPage.enterPlaylistName(playlistName);
        //String newName = playlistPage.getPlaylistName();
        Assert.assertEquals(playlistName, playlistPage.getPlaylistName(), "=== PlaylistNames expected to be equals ===");
    }


}