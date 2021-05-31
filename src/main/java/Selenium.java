import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Selenium {
    public static final String SEARCH_BUTTON_BY_XPATH = "//*[@id=\"sb_form_go\"]";
    private static WebDriver browser; //susikuriame globalu kintamaji klase viduje
    public static void main(String[] args) { //masyvas eiluciu, args - issitraukti is vartotojo parametrus
        System.out.println("Selenium + maven + jUnit");
       // setup();
       // search("Baranauskas");
       // getResults();
       // close();
    }

    public static void setup() {
        //sujungiamas kodas su narsykle, driveriai sujungia
        System.setProperty("webdriver.chrome.driver", "src/webdrivers/chromedriver90.exe"); //nesvarbu koks vartotoja syra prisijunges prie sistemos

        browser = new ChromeDriver();
        browser.get("http://bing.com"); // atidarys narsykle
    }

    public static void search(String keyword){
        //kiekviena elementa is internetinio puslapio issitraukiame pagal jo unikalu identifikatoriu - id, name className
        //zemiau surandamas ew elementas is psl pagal unikalu identifikatoriu. Siuo atveju tai paieskos laukas, oi kuri reikes ivesti zodi baranauskas
        WebElement searchField = browser.findElement(By.id("sb_form_q"));
        searchField.sendKeys(keyword); //suradus elementa puslapyje, i ji irasomas raktinis zodis baranauskas
        //searchField.sendKeys(Keys.ENTER); // irasius paieskos raktini zodi, paieska vykdoma paspaudus enter mygtuka
        //Mygtuko paspaudimas (paieska vykdoma paspaudus mygtuka)
        //1 . veikiantis variantas naudojant JavascriptExecutor
        WebElement ele = browser.findElement(By.xpath(SEARCH_BUTTON_BY_XPATH));
        JavascriptExecutor executor = (JavascriptExecutor) browser; //naudojama klase JavasriptExecutor, is browser issitraukiame ta elementa
        executor.executeScript("arguments[0].click();", ele); // vykdyk skripta, kreipiames i kintamaji arguments, paspaudziam elementa kuri nurodome - ele

        /*
        //2. neveikia kur naudojamas Javascript
        WebDriverWait wait2 = new WebDriverWait(browser, 2); // sukuriamas Webdriver objektas, laukia iki 2 sec kol atsidarys psl
        wait2.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(SEARCH_BUTTON_BY_XPATH)));
        browser.findElement(By.xpath(SEARCH_BUTTON_BY_XPATH)).click();

        //3. neveikia kur naudojamas Javascript
        WebDriverWait wait1 = new WebDriverWait(browser, 10);
        WebElement element1 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath(SEARCH_BUTTON_BY_XPATH)));
        element1.click();
        */

       // System.out.println("Baranausko paieskos rezultatu skaicius lygus "+ resultInt);
        //asertequal metodas patiktrins sita salyga(nereik ifu), mes terminalo neziuresim, tik i ikoneles zalia, raudona
      /* if (resultInt > 50000) {
            System.out.println(keyword+" yra populiarus");
        } else {
            System.out.println(keyword+" nera populiarus");
        }*/
    }

    public static int getResults(){
//Atlikus paieska perziurimas paieskos rezultatu we elementas
        WebElement result2 = browser.findElement(By.xpath("//*[@id=\"b_tween\"]/span"));
        String resultStr = result2.getText() //konvertuojame rezultata
                .replaceAll("[a-zA-z]", "")
                .replaceAll("[ ,]", "");
        //konvertuojame is string i int
        int resultInt = Integer.parseInt(resultStr);
        return resultInt;
    }

    public static void close(){
        browser.close(); // uzdaro narsykles langa automatiskai
    }
}


