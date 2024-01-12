package samokat;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    private final WebDriver driver;
    private final String locOrderButtonTop = ".//button[@class='Button_Button__ra12g']";
    private final String locOrderButtonBottom = ".//div[@class='Home_FinishButton__1_cWm']/button";

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openMainPage() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    public void clickQuestionHeader(By questionHeader) {
        WebElement element = driver.findElement(questionHeader);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(questionHeader));
        element.click();
    }

    public String getQuestionHeaderText(By questionHeader) {
        WebElement element = driver.findElement(questionHeader);
        return element.getText();
    }

    public String getQuestionBodyText(By questionBody) {
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(questionBody));
        return driver.findElement(questionBody).getText();
    }

    public By getQuestionHeaderTextLoc(String textQuestionHeader) {
        return By.xpath("//div[text()='" + textQuestionHeader + "']");
    }

    public By getQuestionBodyTextLoc(String textQuestionBody) {
        return By.xpath("//div[p[contains(text(),'" + textQuestionBody + "')]]");
    }

    public void clickOrder(int id) {

        if (id == 1) {
            driver.findElement(By.xpath(locOrderButtonTop)).click();
        } else {
            WebElement element = driver.findElement(By.xpath(locOrderButtonBottom));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            driver.findElement(By.xpath(locOrderButtonBottom)).click();
        }
    }
}
