package samokat;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.CoreMatchers.containsString;

public class OrderPage {
    private final WebDriver driver;
    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputName(String name) {
        driver.findElement(By.xpath("//input[@placeholder= '* Имя']")).sendKeys(name);
    }

    public void inputFamily(String family) {
        driver.findElement(By.xpath("//input[@placeholder= '* Фамилия']")).sendKeys(family);
    }

    public void inputAdress(String adress) {
        driver.findElement(By.xpath("//input[@placeholder= '* Адрес: куда привезти заказ']")).sendKeys(adress);
    }

    public void clickMetro() {
        driver.findElement(By.className("select-search")).click();
    }

    public void selectStation(String station) {
        driver.findElement(By.className("select-search__input")).sendKeys(station);
        driver.findElement(By.className("select-search__select")).click();
    }

    public void inputPhoneNumber(String phone) {
        driver.findElement(By.xpath("//input[@placeholder= '* Телефон: на него позвонит курьер']")).sendKeys(phone);
    }

    public void clickNextButton() {
        driver.findElement(By.xpath("//button[@class= 'Button_Button__ra12g Button_Middle__1CSJM']")).click();
    }

    public void inputDate(String date) {
        driver.findElement(By.xpath("//input[@placeholder= '* Когда привезти самокат']")).sendKeys(date);
        driver.findElement(By.xpath("//input[@placeholder= '* Когда привезти самокат']")).sendKeys(Keys.ENTER);
    }

    public void chooseRentalPeriod() {
        driver.findElement(By.className("Dropdown-placeholder")).click();
        driver.findElement(By.className("Dropdown-option")).click();
    }

    public void chooseSamokatColor(String color) {
        driver.findElement(By.id(color)).click();
    }

    public void inputComment(String comment) {
        driver.findElement(By.xpath("//input[@placeholder= 'Комментарий для курьера']")).sendKeys(comment);
    }

    public void clickOrderComplete() {
        driver.findElement(By.xpath("//button[@class= 'Button_Button__ra12g Button_Middle__1CSJM']")).click();
    }

    public void checkOrderCompleteWindow() {
            MatcherAssert.assertThat("No order complete window",
                    driver.findElement(By.className("Order_ModalHeader__3FDaJ")).getText(),
                    containsString("Хотите оформить заказ?"));
    }

    public void clickOrderYes() {
        driver.findElement(By.xpath("//button[text()='Да']")).click();
    }

    public String getLastOrderText(){
        return driver.findElement(By.className("Order_ModalHeader__3FDaJ")).getText();
    }

}
