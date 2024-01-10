package samokat;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.CoreMatchers.containsString;

public class OrderPage {
    private final WebDriver driver;
    private final By locName = By.xpath("//input[@placeholder= '* Имя']");
    private final By locFamily = By.xpath("//input[@placeholder= '* Фамилия']");
    private final By locAdress = By.xpath("//input[@placeholder= '* Адрес: куда привезти заказ']");
    private final By locMetro = By.className("select-search");
    private final By locMetroInput = By.className("select-search__input");
    private final By locMetroSelect = By.className("select-search__select");
    private final By locPhoneNumber = By.xpath("//input[@placeholder= '* Телефон: на него позвонит курьер']");
    private final By locNextButton = By.xpath("//button[@class= 'Button_Button__ra12g Button_Middle__1CSJM']");
    private final By locDate = By.xpath("//input[@placeholder= '* Когда привезти самокат']");
    private final By locRentalPeriod0 = By.className("Dropdown-placeholder");
    private final By locRentalPeriod1 = By.className("Dropdown-option");
    private final By locComment = By.xpath("//input[@placeholder= 'Комментарий для курьера']");
    private final By locOrderComplete = By.xpath("//button[@class= 'Button_Button__ra12g Button_Middle__1CSJM']");
    private final By locOrderWindow = By.className("Order_ModalHeader__3FDaJ");
    private final By locOrderYes = By.xpath("//button[text()='Да']");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputName(String name) {
        driver.findElement(locName).sendKeys(name);
    }

    public void inputFamily(String family) {
        driver.findElement(locFamily).sendKeys(family);
    }

    public void inputAdress(String adress) {
        driver.findElement(locAdress).sendKeys(adress);
    }

    public void clickMetro() {
        driver.findElement(locMetro).click();
    }

    public void selectStation(String station) {
        driver.findElement(locMetroInput).sendKeys(station);
        driver.findElement(locMetroSelect).click();
    }

    public void inputPhoneNumber(String phone) {
        driver.findElement(locPhoneNumber).sendKeys(phone);
    }

    public void clickNextButton() {
        driver.findElement(locNextButton).click();
    }

    public void inputDate(String date) {
        driver.findElement(locDate).sendKeys(date);
        driver.findElement(locDate).sendKeys(Keys.ENTER);
    }

    public void chooseRentalPeriod() {
        driver.findElement(locRentalPeriod0).click();
        driver.findElement(locRentalPeriod1).click();
    }

    public void chooseSamokatColor(String color) {
        driver.findElement(By.id(color)).click();
    }

    public void inputComment(String comment) {
        driver.findElement(locComment).sendKeys(comment);
    }

    public void clickOrderComplete() {
        driver.findElement(locOrderComplete).click();
    }

    public void checkOrderCompleteWindow() {
            MatcherAssert.assertThat("No order complete window",
                    driver.findElement(locOrderWindow).getText(),
                    containsString("Хотите оформить заказ?"));
    }

    public void clickOrderYes() {
        driver.findElement(locOrderYes).click();
    }

    public String getLastOrderText(){
        return driver.findElement(locOrderWindow).getText();
    }

    public void makeOrder(String name, String family, String adress, String station, String phone, String date, String color, String comment) {
        inputName(name);
        inputFamily(family);
        inputAdress(adress);
        clickMetro();
        selectStation(station);
        inputPhoneNumber(phone);
        clickNextButton();
        inputDate(date);
        chooseRentalPeriod();
        chooseSamokatColor(color);
        inputComment(comment);
        clickOrderComplete();
        checkOrderCompleteWindow();
        clickOrderYes();
    }

}
