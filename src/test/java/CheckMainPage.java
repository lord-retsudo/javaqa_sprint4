import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import samokat.MainPage;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CheckMainPage {

    private WebDriver driver;

    @Before
    public void initMainPage() {
      //  WebDriverManager.firefoxdriver().clearDriverCache().setup();
      //  driver = new FirefoxDriver();

        String chromeDriverPath = "C:\\selenium_drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        //WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    private final String questionHeader;
    private final String textQuestionHeader;
    private final String questionBody;
    private final String textQuestionBody;

    public CheckMainPage(String questionHeader, String textQuestionHeader, String questionBody, String textQuestionBody) {
        this.questionHeader = questionHeader;
        this.textQuestionHeader = textQuestionHeader;
        this.questionBody = questionBody;
        this.textQuestionBody = textQuestionBody;
    }

    @Parameterized.Parameters
    public static Object[][] getQuestions() {
        //Сгенерируй тестовые данные (свою учётку и несколько случайных)
        return new Object[][] {
                { "accordion__heading-0", "Сколько это стоит? И как оплатить?", "accordion__panel-0", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                { "accordion__heading-1", "Хочу сразу несколько самокатов! Так можно?", "accordion__panel-1",
                        "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                { "accordion__heading-2", "Как рассчитывается время аренды?","accordion__panel-2",
                        "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                { "accordion__heading-3", "Можно ли заказать самокат прямо на сегодня?", "accordion__panel-3", "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                { "accordion__heading-4", "Можно ли продлить заказ или вернуть самокат раньше?", "accordion__panel-4", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                { "accordion__heading-5", "Вы привозите зарядку вместе с самокатом?", "accordion__panel-5", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                { "accordion__heading-6", "Можно ли отменить заказ?", "accordion__panel-6", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                { "accordion__heading-7", "Я жизу за МКАДом, привезёте?", "accordion__panel-7", "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }

    @Test
    public void checkTextOfQuestionsPanel() {

        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickQuestionHeader(questionHeader);
        assertEquals(textQuestionHeader, mainPage.getQuestionHeaderText(questionHeader));
        assertEquals(textQuestionBody, mainPage.getQuestionBodyText(questionBody));
    }

    @After
    public void teardown() {
        driver.quit();
    }

}
