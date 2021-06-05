import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Selenium {
    public static final String SEND_BUTTON_BY_XPATH = "//*[@id=\"form\"]/form/p[1]/button[1]"; //susikuriame globalu mygtuko kintamaji, kad galetume ji naudoti keliose vietose = mygtuko search kelias
    public static final String DELETE_BUTTON_BY_XPATH = "//*[@id=\"form\"]/form/p[1]/button[4]";
    public static final String EDIT_BUTTON_BY_XPATH = "//*[@id=\"form\"]/form/p[1]/button[2]";
    public static final String GOOD_MESSAGE_BY_XPATH = "/html/body/div[2]";

    private static WebDriver browser; //susikuriame, apsirasome globalu kintamaji. private - nes uz klases ribu sio kintamojo nenaudosime
    public static void main(String [] args){ //main - visada bus viena f-ja, paleidziamoji. String'o (eiluciu) masyvas, args - issitraukti is vartotojo parametrus, duomenis. Static- nereikia kurits klases objekto, kad galetume panaudoti sita objekta. main - visada public ir static. Jei norime is main kreiptis i kitas f-jas, jos irgi privalo buti static
        System.out.println("Selenium + maven + jUnit");
        //setup();
        //getMessage();
        //createRecord();
        //deleteRecord();
        //editRecord();
        //close();
    }

    public static void setup(){
        System.setProperty("webdriver.chrome.driver", "src/webdrivers/chromedriver90.exe");
        browser = new ChromeDriver();
        browser.get("http://kitm.epizy.com/filmai.php");
    }

    public static String getMessage(){
        WebElement message = browser.findElement(By.xpath(GOOD_MESSAGE_BY_XPATH));
        String messageStr = message.getText(); //istraukiamas tekstas
        return messageStr;
    }

    public static void createRecord(String fieldTitle, String fieldGenre, String fieldActors, String fieldDirector, String fieldDuration){
        WebElement titleField = browser.findElement(By.xpath("//*[@id=\"form\"]/form/input[2]"));
        titleField.sendKeys(fieldTitle);
        WebElement genreField = browser.findElement(By.xpath("//*[@id=\"form\"]/form/input[3]"));
        genreField.sendKeys(fieldGenre);
        WebElement actorsField = browser.findElement(By.xpath("//*[@id=\"form\"]/form/input[4]"));
        actorsField.sendKeys(fieldActors);
        WebElement directorField = browser.findElement(By.xpath("//*[@id=\"form\"]/form/input[5]"));
        directorField.sendKeys(fieldDirector);
        WebElement durationField = browser.findElement(By.xpath("//*[@id=\"form\"]/form/input[6]"));
        durationField.sendKeys(fieldDuration);

        WebElement send = browser.findElement(By.xpath(SEND_BUTTON_BY_XPATH));
        JavascriptExecutor executor = (JavascriptExecutor)browser;
        executor.executeScript("arguments[0].click();",send);
    }

    public static void deleteRecord(String fieldId){
        WebElement idField = browser.findElement(By.xpath("//*[@id=\"form\"]/form/input[1]"));
        idField.sendKeys(fieldId);

        WebElement delete = browser.findElement(By.xpath(DELETE_BUTTON_BY_XPATH));
        JavascriptExecutor executor = (JavascriptExecutor)browser;
        executor.executeScript("arguments[0].click();",delete);
    }

    public static void editRecord(String fieldId, String fieldTitle, String fieldGenre, String fieldActors, String fieldDirector, String fieldDuration){
        WebElement idField = browser.findElement(By.xpath("//*[@id=\"form\"]/form/input[1]"));
        idField.sendKeys(fieldId);
        WebElement titleField = browser.findElement(By.xpath("//*[@id=\"form\"]/form/input[2]"));
        titleField.sendKeys(fieldTitle);
        WebElement genreField = browser.findElement(By.xpath("//*[@id=\"form\"]/form/input[3]"));
        genreField.sendKeys(fieldGenre);
        WebElement actorsField = browser.findElement(By.xpath("//*[@id=\"form\"]/form/input[4]"));
        actorsField.sendKeys(fieldActors);
        WebElement directorField = browser.findElement(By.xpath("//*[@id=\"form\"]/form/input[5]"));
        directorField.sendKeys(fieldDirector);
        WebElement durationField = browser.findElement(By.xpath("//*[@id=\"form\"]/form/input[6]"));
        durationField.sendKeys(fieldDuration);

        WebElement edit = browser.findElement(By.xpath(EDIT_BUTTON_BY_XPATH));
        JavascriptExecutor executor = (JavascriptExecutor)browser;
        executor.executeScript("arguments[0].click();",edit);
    }

    public static void close(){
        browser.close();

    }
}