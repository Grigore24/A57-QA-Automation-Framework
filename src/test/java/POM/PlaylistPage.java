package POM;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PlaylistPage extends BasePage{
    public PlaylistPage(WebDriver givenDriver) {

        super(givenDriver);
    }
    //LOCATORS
    private By plusBtn = By.cssSelector("[data-testid='sidebar-create-playlist-btn']");
    private By createNewPlaylist = By.cssSelector("[data-testid='playlist-context-menu-create-simple']");
    private By playlistNameInput = By.cssSelector(".create input");
    private By plNameInput = By.cssSelector("[id='songResultsWrapper'] [placeholder='Playlist name']");
    private By checkHeader = By.cssSelector("#playlistWrapper h1");
    private By delPlaylistBtn = By.cssSelector(".btn-delete-playlist");
    public void createNewPlaylist(String playlistName) {
        WebElement newPlaylistNameInput = driver.findElement(plNameInput);
        newPlaylistNameInput.click();
        newPlaylistNameInput.clear();
        newPlaylistNameInput.sendKeys(playlistName);
        // click Enter
        new Actions(driver)
                .keyDown(Keys.ENTER)
                .perform();
        System.out.println(playlistName);
    }
    public String generateRandomPlaylistName(){
        Faker faker = new Faker(new Locale("en-US"));
        String newName = faker.address().country();
        return newName;
    }
    public void createNewPlaylistUsingPlusBtn(String playlistName) {
        WebElement plusButton = wait.until(ExpectedConditions.visibilityOfElementLocated(plusBtn));
        plusButton.click();

        WebElement presNewPlaylistBtn = wait.until(ExpectedConditions.elementToBeClickable(createNewPlaylist));
        presNewPlaylistBtn.click();

        WebElement inputPlaylistName = wait.until(ExpectedConditions.elementToBeClickable(playlistNameInput));
        inputPlaylistName.click();
        inputPlaylistName.clear();
        inputPlaylistName.sendKeys(playlistName);
        // click Enter
        new Actions(driver)
                .keyDown(Keys.ENTER)
                .perform();
    }
    public void checkPlayListHeader(String playlistName) {
        WebElement playlistHeader = waitUntilVisible(checkHeader);
        wait.until(ExpectedConditions
                .textToBePresentInElement(playlistHeader, playlistName));
    }
    public void clickDeletePlaylistBtn() {
        WebElement deletePlaylistBtn = waitUntilClickable(delPlaylistBtn);
        deletePlaylistBtn.click();
    }
    public List<String> getPlaylistNames() {
        List<WebElement> playlists = driver.findElements(By.cssSelector("#playlists a"));
        // get playlist names from playlist elements
        List<String> playlistNames = new ArrayList<>();

        for (int i = 0; i < playlists.size(); i++) {
            String playlistName = playlists.get(i).getText();
            playlistNames.add(playlistName);
        }
        System.out.println(playlistNames);
        return playlistNames;
    }

}