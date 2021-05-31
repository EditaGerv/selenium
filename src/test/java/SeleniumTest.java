//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.TestMethodOrder;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//@TestMethodOrder(MethodOrderer.OrderAnnotation.class) // reikalinga, kad galetume rikiuoti, eiles tvarka daryti, reikia parasyti ranka
public class SeleniumTest {
    @BeforeTest // veiksmai kurie bus atliekami pries kiekviena testa
    public void setup(){
        Selenium.setup(); //suranda webdriveri, uzkruana url ir pan.
    }
    @Test (priority=1)
    public void searchByKeywordTest(){
        Selenium.search("Baranauskas");
    }
    @Test (priority=2)
    public void getResults(){
        Selenium.search("Baranauskas");
        //pirmas parametras bus actual, o antras expected
        Assert.assertEquals(191000, Selenium.getResults());
    }

    @AfterTest
    public void close(){
        Selenium.close();
    }
}
