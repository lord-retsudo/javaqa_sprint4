//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.junit.After;
//import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import samokat.MainPage;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CheckMainPage extends BaseTest {

    // private WebDriver driver;

    // private final String questionHeader;
    private final String textQuestionHeader;
    // private final String questionBody;
    private final String textQuestionBody;

    public CheckMainPage(String textQuestionHeader, String textQuestionBody) {
        //this.questionHeader = questionHeader;
        this.textQuestionHeader = textQuestionHeader;
        //this.questionBody = questionBody;
        this.textQuestionBody = textQuestionBody;
    }

    @Parameterized.Parameters
    public static Object[][] getQuestions() {

        return new Object[][] {
                {"Сколько это стоит? И как оплатить?", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {"Хочу сразу несколько самокатов! Так можно?", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {"Как рассчитывается время аренды?", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {"Можно ли заказать самокат прямо на сегодня?", "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {"Можно ли продлить заказ или вернуть самокат раньше?", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {"Вы привозите зарядку вместе с самокатом?", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {"Можно ли отменить заказ?", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {"Я жизу за МКАДом, привезёте?", "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }

    @Test
    public void checkTextOfQuestionsPanel() {

        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();

        By questionHeader = mainPage.getQuestionHeaderTextLoc(textQuestionHeader);
        By questionBody = mainPage.getQuestionBodyTextLoc(textQuestionBody);

        // System.out.println(textQuestionHeader + ": " + textQuestionBody);
        // System.out.println(questionHeader + ": " + questionBody);

        mainPage.clickQuestionHeader(questionHeader);
        assertEquals(textQuestionHeader, mainPage.getQuestionHeaderText(questionHeader));
        assertEquals(textQuestionBody, mainPage.getQuestionBodyText(questionBody));
    }
}
