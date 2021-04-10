package java_selenium01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class day01 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:/Users/Emre Duman/Documents/selenium dependencies/drivers/chromedriver.exe");
        //webdriver ile calısıyoruz. type:chrome.driver,  chromedriver.exe file ının pathi
        //mac kullananlar chromedriver ile pathi bitirir(.exe yazmaz)


        //public interface WebDriver extends SearchContext {
        WebDriver driver=new ChromeDriver();//webdriverdan nesne olusturduk driver olusturduk
        driver.get("https://www.udemy.com");
        driver.navigate().back();//opens blank white page which displayed when driver object executes

        driver.get("https://www.google.com");
        driver.navigate().back();//burada navigate.back(); udemy ı acmaz blank page acılır
        driver.navigate().back();//burada google ı ACMAZ
        driver.navigate().forward();//burada google gitti tekrar
        driver.navigate().to("https://www.amazon.com");//amazona gider
        driver.navigate().refresh();//refresh eder
        driver.manage().window().maximize();//sayfa büyüdü

        driver.navigate().to("https://www.haberler.com/");
        for(int i=0;i<6;i++){
            driver.navigate().back();//haberler-->amazon-->google-->bos sayfa ve loop biter
        }

        Thread.sleep(3000);// throws InterruptedException

        driver.close();//Close the current window, quitting the browser if it's the last window currently open.


        WebDriver driver2;
        driver2=new ChromeDriver();
        driver2.navigate().to("https://www.udemy.com");
        driver2.navigate().back();//google ACILMAZ

        driver2.quit();// Quits this driver, closing every associated window.

        /*
        They do a similar thing but not exactly the same. driver.quit()
        is used to exit the browser, end the session, tabs, pop-ups etc.

        But the when you driver.close(), only the window that has focus is closed.
        It is better to use driver.close() when you are dealing with multiple tabs or windows.
         */


        WebDriver driver3=new ChromeDriver();
        driver3.get("https://www.google.com/");
        driver3.get("https://www.udemy.com/");
        driver3.get("https://www.amazon.com/");
        driver3.get("https://www.haberler.com/");
        for(int i=0; i<4;i++){
            driver3.navigate().back();//amazon-udemy-google-blankpage(driver3 object)
        }
        driver.quit();

    }
}
