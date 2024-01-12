//import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.MatcherAssert;
//import org.junit.After;
//import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import samokat.MainPage;
import samokat.OrderPage;
import static org.hamcrest.CoreMatchers.containsString;

@RunWith(Parameterized.class)
public class CheckOrder extends BaseTest {

    // private WebDriver driver;
    private final int id;
    private final String name;
    private final String family;
    private final String adress;
    private final String station;
    private final String phone;
    private final String date;
    private final String color;
    private final String comment;

    public CheckOrder (int id, String name, String family, String adress, String station, String phone, String date, String color, String comment) {
        this.id = id;
        this.name = name;
        this.family = family;
        this.adress = adress;
        this.station = station;
        this.phone = phone;
        this.date = date;
        this.color = color;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getOrder() {
        return new Object[][]{
                {1, "Иван", "Поддубный", "ул. Ленина, д.13", "Сокол", "+79245679843", "08.01.2024", "grey", "Позвонить за 30 минут до выезда"},
                {2, "Анна", "Семенович", "ул. Мосфильмовская, д.5", "Технопарк", "+79142826644", "10.01.2024", "black", "Позвонить за 30 минут до выезда"},
        };
    }

    @Test
    public void positiveCheckOrder() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickOrder(id);
        OrderPage orderPage = new OrderPage(driver);

        orderPage.makeOrder(name, family, adress, station, phone, date, color, comment);

        MatcherAssert.assertThat("Нет окна (Заказ оформлен)",
                orderPage.getLastOrderText(), containsString("Заказ оформлен"));
    }

}
