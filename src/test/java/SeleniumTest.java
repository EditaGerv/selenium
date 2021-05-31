import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SeleniumTest {
    @Before // veiksmai kurie bus atliekami pries kiekviena testa
    public void setup(){
        Selenium.setup(); //suranda webdriveri, uzkruana url ir pan.
    }
    @Test
    @Order(1)
    public void searchByKeywordTest(){
        Selenium.search("Baranauskas");
    }
    @Test
    @Order(2)
    public void getResults(){
        Selenium.search("Baranauskas");
        //pirmas parametras bus expected, o antras actual
        Assert.assertEquals(188000, Selenium.getResults());
    }

    @After
    public void close(){
        Selenium.close();
    }
}
