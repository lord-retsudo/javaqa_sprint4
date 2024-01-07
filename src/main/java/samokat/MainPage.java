package samokat;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    private final WebDriver driver;
    private final String orderButtonTop = ".//button[@class='Button_Button__ra12g']";
    private final String orderButtonBottom = ".//div[@class='Home_FinishButton__1_cWm']/button";

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openMainPage() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    public void clickQuestionHeader(String questionHeader) {
        WebElement element = driver.findElement(By.id(questionHeader));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(By.id(questionHeader)));
        element.click();
    }

    public String getQuestionHeaderText(String questionHeader) {
        WebElement element = driver.findElement(By.id(String.valueOf(questionHeader)));
        return element.getText();
    }

    public String getQuestionBodyText(String questionBody) {
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(By.id(questionBody)));
        return driver.findElement(By.id(questionBody)).getText();
    }

    public void clickOrder(int id) {

        if (id == 1) {
            driver.findElement(By.xpath(orderButtonTop)).click();
        } else {
            WebElement element = driver.findElement(By.xpath(orderButtonBottom));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            driver.findElement(By.xpath(orderButtonBottom)).click();
        }
    }
}
