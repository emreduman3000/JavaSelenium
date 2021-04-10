package java_selenium01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.xml.namespace.QName;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class BasicNavigation {
    //Selenium web tabanlı uygulamaları browser üzerinden test etmemizi saglar.
    public static void main(String[] args) throws InterruptedException
    {
        System.setProperty("webdriver.chrome.driver","C:/Users/Emre Duman/Documents/selenium dependencies/drivers/chromedriver.exe");
        WebDriver driver2 = new ChromeDriver();//I CREATED AN OBJECT FROM ChromeDriver CLASS if ı dont use this object a blank webpage will be opened

       /*
        WebDriver driver = new ChromeDriver();//I CREATED AN OBJECT FROM ChromeDriver Class - polimorphism

        //WebDriverManager.chromedriver().setup();

            driver.get("https://www.google.com");//It will open
            driver.get("https://www.amazon.com");//Then, web page will open amazon
            Thread.sleep(5000);// wait 5000 milisecond-5second throws InterruptedException ekledim
            driver.close();//close the browser - close current page
            //driver.quit();//close the browser - close all pages


        driver.get("https://www.udemy.com");//udemy opens
        driver.navigate().to("https://www.amazon.com");//go to amazon
        driver.navigate().back();//back to udemy
        driver.navigate().forward();//forward to amazon
        driver.navigate().refresh();//refresh the last opened webpage
        driver.manage().window().maximize();
        driver.manage().window().fullscreen();
        driver.close();//close the last opened webpage- amazon/ udemy remains
        driver.quit();//close all subsequent pages (close amazon and udemy as well)
    */
    }

}

class verifyTitleTEST {
    public static void main(String[] args) throws InterruptedException {

    //region Description

        System.setProperty("webdriver.chrome.driver","C:/Users/Emre Duman/Documents/selenium dependencies/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        driver.manage().window().fullscreen();//sinema modu (carpı falan dahi olmaz yukarda)
        Thread.sleep(3000);

        String actualTitle=driver.getTitle();//html tag : <title> Google </title>
        //inspect  +  ctrl+F  +  //title
        //hover over web tab to see title
        System.out.println(actualTitle);//Google
        String expectedTitle="Google";

        if(actualTitle.equals(expectedTitle))//String.equals(String)
            System.out.println("pass");
        else
            System.out.println("fail"+"\n"+
                    "Actual Title:"+actualTitle+"\n"+
                    "Expected Title:"+expectedTitle);

        expectedTitle="google";
        System.out.println(actualTitle.equals(expectedTitle) ? "Pass" : "fail"+"\n"+
                "Actual Title:"+actualTitle+"\n"+
                "Expected Title:"+expectedTitle);

        driver.close();//ı closed the page
//endregion
    }
}

class verifyURLTitle {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:/Users/Emre Duman/Documents/selenium dependencies/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        System.out.println(driver.getCurrentUrl());//https://www.google.com/ - this url is printed on console

        String actualURL = "https://www.google.com/";
        String expectedURL = "https://www.google.com";

        System.out.println(actualURL.equals(expectedURL) ? "Pass" : "Fail" + "\n" +
                "Actual Title:" + actualURL + "\n" +
                "Expected Title:" + expectedURL);
        /*
            Fail
            Actual Title:https://www.google.com/
            Expected Title:https://www.google.com
         */

        driver.close();
    }
}

class reviewDAY02 {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:/Users/Emre Duman/Documents/selenium dependencies/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.youtube.com");


        String actualYOUTUBEtitle=driver.getTitle();//Youtube
        String expectedYOUTUBEtitle="youtube";
        boolean x=actualYOUTUBEtitle.equals(expectedYOUTUBEtitle);//false

        System.out.println( x ? "It is equal" : "It is not equal"+"\n"+
                "Actual Youtube Title:"+actualYOUTUBEtitle+"\n"+
                "Expected Youtube Title:"+expectedYOUTUBEtitle);
        /*result
            It is not equal
            Actual Youtube Title:YouTube
            Expected Youtube Title:youtube
         */


        String actualYOUTUBEurl = driver.getCurrentUrl();//https://www.youtube.com/
        String expectedYOUTUBEurl="youtube";
        boolean x2=actualYOUTUBEurl.contains(expectedYOUTUBEurl);//true

        System.out.println( x2 ? "It contains " : "It doesn't contain" + "\n" +
                "Actual Youtube URL:" + actualYOUTUBEurl +"\n"+
                "Expected Youtube URL:"+expectedYOUTUBEurl);
        /*result
            It contains
         */


        driver.navigate().to("https://www.amazon.com");
        driver.navigate().back();//back to Youtube
        driver.navigate().refresh();//refresh Youtube
        driver.navigate().forward();//forward to Amazon
        driver.manage().window().maximize();//maximize Amazon web page


        String actualAMAZONtitle=driver.getTitle();//Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more
        String expectedAMAZONtitle="Amazon";
        boolean x3=actualAMAZONtitle.contains(expectedAMAZONtitle);//true
        System.out.println( x3 ? "It contains" : "It doesn't contains,"+ "\n" +
                "Actual Amazon Title:"+actualAMAZONtitle + "\n" +
                "Expected Amazon Title:"+expectedAMAZONtitle);
        /*result
            It contains
         */

        String actualAMAZONurl=driver.getCurrentUrl();
        String expectedAMAZONurl="https://www.amazon.com";
        boolean x4=actualAMAZONurl.equals(expectedAMAZONurl);

        System.out.println( x4 ? "It is equal" : "It is not equal,"+ "\n" +
                "Actual Amazon URL:" + actualAMAZONurl+ "\n" +
                "Expected Amazon URL:"+ expectedAMAZONurl);
        /*result
            It is not equal,
            Actual Amazon URL:https://www.amazon.com/
            Expected Amazon URL:https://www.amazon.com
         */

        //driver.close();//close onlt last opened web page
        driver.quit();//It closes all subsequent opened web pages
    }
}

class day03 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:/Users/Emre Duman/Documents/selenium dependencies/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://a.testaddressbook.com/sign_in");


         /*
            driver.findElement(By.name("session[email]"));
            driver.findElement(By.className("form-group row"));
            driver.findElement(By.linkText(""));//email textbox için linkText yok
            driver.findElement(By.partialLinkText(""));//email textbox için partialLinkText yok
            driver.findElement(By.tagName(""));//bu mantıklı değil bu tagname ile bir sürü element  vardır
            driver.findElement(By.xpath(""));//birden fazla syntax ı vardır
            driver.findElement(By.cssSelector(""));//
        */

        System.out.println(driver.findElement(By.linkText("Sign up")).getText());//Sign up
        System.out.println(driver.findElement(By.partialLinkText("n up")).getText());//Sign up
        System.out.println(driver.findElement(By.partialLinkText("n up")).isDisplayed());//true
        System.out.println(driver.findElement(By.partialLinkText("n up")).getLocation());//(357, 298)
        System.out.println(driver.findElement(By.partialLinkText("n up")).getSize());//(54, 24)

        WebElement emailTextBox = driver.findElement(By.id("session_email"));//An element is located only once , like in this line
        emailTextBox.sendKeys("testtechproed@gmail.com");//sendKeys() method send the text which is inside of double quote into textbox on webPage

        WebElement passwordTextBox = driver.findElement(By.id("session_password"));
        passwordTextBox.sendKeys("Test1234!");

        WebElement signInButton = driver.findElement(By.name("commit"));
        signInButton.click();//click() method is used to click indicated button automatically.
        driver.manage().window().maximize();
        //websitesinde right cilick+inspect+mouse tıkla sonra textbox ya da bir elemente tıkla - onla alakalı kodlar cıkıcak
        //name'e ya da id'ye yada class'a double click + ctrl+c  sonra ctrl+f yap araa butonuna cıktı ctrl+v yap
        //name tek bir elemente mi ait görebiliriz

        //user ıd'nin testtechproed@gmail.com verify edin
        //<span class="navbar-text" data-test="current-user">testtechproed@gmail.com</span>
        WebElement userID=driver.findElement(By.className("navbar-text"));

        System.out.println("USER ID WEBELEMENT: "+userID);//hashcode'u -reference'ı verir -
        // [[ChromeDriver: chrome on WINDOWS (7cdd4801843dce1fa04088b90bd97102)] -> class name: navbar-text]

        System.out.println("USER ID TEXT: "+userID.getText());//ELEMET'İN GÖRÜNEN METNINI VERIR -
        // USER ID TEXT: testtechproed@gmail.com

        String actualUserID=userID.getText();
        String expectedUserID="testtechproed@gmail.com";
        boolean x=actualUserID.equals(expectedUserID);

        System.out.println( x ? "It is equal\n" : "It is not equal,"+ "\n" +
                "ActualUserID:" + actualUserID+ "\n" +
                "ExpectedUserID:"+ expectedUserID +"\n");


        //Addresses and Sign Out textlerinin displayed edildiğini verify et

        //<a class="nav-item nav-link" data-test="addresses" href="/addresses">Addresses</a>
        WebElement addressLinkTest=driver.findElement(By.linkText("Addresses"));
        System.out.println("reference of addressLink:"+addressLinkTest);
        //reference of addressLink:[[ChromeDriver: chrome on WINDOWS (5860a7bfd87dc2afbf0a6f019b5fbaca)] -> link text: Addresses]
        System.out.println("text of addressLink:"+addressLinkTest.getText()+"\n");
        //text of addressLink:Addresses

        String actualAddressLink=addressLinkTest.getText();
        String expectedAddressLink="Addresses";
        boolean x2=actualAddressLink.equals(expectedAddressLink);

        System.out.println( x2 ? "It is equal\n" : "It is not equal,"+ "\n" +
                "ActualAddressLink:" + actualAddressLink+ "\n" +
                "ExpectedAddressLink:"+ expectedAddressLink);


        //<a class="nav-item nav-link" data-test="sign-out" rel="nofollow" data-method="delete" href="/sign_out">Sign out</a>
        //“Sign Out” textlerinin görüntülendiğini( displayed) doğrulayin(verify).
        //public interface WebElement extends SearchContext, TakesScreenshot
        WebElement signOutLink = driver.findElement(By.linkText("Sign out"));
        String actualSignOutLinkText = signOutLink.getText();
        String expectedSignOutLinkText = "Sign Out";

        if(actualSignOutLinkText.equals(expectedSignOutLinkText)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("ACTUAL SIGN OUT TEXT : "+actualSignOutLinkText);//Sign out
            System.out.println("EXTECTED SIGN OUT TEXT : "+expectedSignOutLinkText);//Sign Out
        }



       // driver.quit();//It closes all subsequent opened web pages

        //By.partialLinkText();
        //ADDRESSES link
        WebElement addressPartialLink = driver.findElement(By.partialLinkText("Address"));
        String actualAddressPartialLinkText = addressPartialLink.getText();
        System.out.println("actualAddressPartialLinkText :"+ actualAddressPartialLinkText);//Addresses
        //Sign out link
        WebElement signOutPartialLink = driver.findElement(By.partialLinkText("ign ou"));
        String actualSignOutPartialLink = signOutPartialLink.getText();
        System.out.println("actualSignOutPartialLink :"+actualSignOutPartialLink);//Sign out



        //Sayfadaki toplam link sayisini bulun ve bu linkleri konsolda yazdirin.
        //findElement(); metodu yalnizca tek bir elementi locate icin kullanilir. String return eder.
        //findElements(); metodu birden fazla element return eder. List<WebElement>

        List<WebElement> listOfWebElement = driver.findElements(By.tagName("a"));
        System.out.println("Bu web sayfasinda "+listOfWebElement.size()+" tane link vardir.");
        //Bu web sayfasinda 3 tane link vardir.

        //linkleri tek tek yazdırın
        //3 tane link elementi var.  1. elementin indexini 0 alırız

        System.out.println("1. WEB ELEMENT:" + listOfWebElement.get(0));
        //1. elementin konsolda yazdırılması. 1. element için index 0 alınır
        //1. WEB ELEMENT:[[ChromeDriver: chrome on WINDOWS (5860a7bfd87dc2afbf0a6f019b5fbaca)] -> tag name: a]

        System.out.println("1.link text:"+listOfWebElement.get(0).toString());
        //1.link text:[[ChromeDriver: chrome on WINDOWS (05d8015f2f66b3da5b626e545e8bd1e5)] -> tag name: a]


        System.out.println("2.link text:"+listOfWebElement.get(1).getText());//2.link text:Addresses
        //   "//a[2]"
        System.out.println("3.link text:"+listOfWebElement.get(2).getText());//3.link text:Sign out
        //   "//a[3]"


        for (WebElement i: listOfWebElement) {
            System.out.println(i.getText());
        }
        /*
        Home
        (current)
        Addresses
        Sign out
         */

        List<WebElement> allLinksInThePage= driver.findElements(By.className("nav-item nav-link"));
        System.out.println(allLinksInThePage.size());

       //List<WebElement> allLinksInThePage1= driver.findElements(By.cssSelector("//a[@class='nav-item']"));//ERROR
        List<WebElement> allLinksInThePage1= driver.findElements(By.xpath("//a[@class='nav-item nav-link']"));
        System.out.println(allLinksInThePage1.size());//2

        List<WebElement> allLinksInThePage2= driver.findElements(By.xpath("//a[contains(@class, 'nav-item')]"));
        System.out.println(allLinksInThePage2.size());//3
        System.out.println(allLinksInThePage2);
        //[[[ChromeDriver: chrome on WINDOWS (d01baa0e6018e45eb0c22587f23a2823)] -> xpath: //a[contains(@class, 'nav-item')]], [[ChromeDriver: chrome on WINDOWS (d01baa0e6018e45eb0c22587f23a2823)] -> xpath: //a[contains(@class, 'nav-item')]], [[ChromeDriver: chrome on WINDOWS (d01baa0e6018e45eb0c22587f23a2823)] -> xpath: //a[contains(@class, 'nav-item')]]]

        List<WebElement> allLinksInThePage3= driver.findElements(By.cssSelector("a[class='nav-item.nav-link']"));
        System.out.println(allLinksInThePage3.size());//0

        List<WebElement> allLinksInThePage4= driver.findElements(By.cssSelector("a[class='nav-item nav-link']"));
        System.out.println(allLinksInThePage4.size());//2

        List<WebElement> allLinksInThePage5= driver.findElements(By.cssSelector("a[class='nav-item']"));
        System.out.println(allLinksInThePage5.size());//0

        //CTRL+F diyip locatorları yazınca gösterir,göstermiyorsa yanlıstır
        for (WebElement i: allLinksInThePage2)
        {
            System.out.println(i.getText());
            //Home
            //(current)
            //Addresses
            //Sign out
        }



    }
}

class day04_GoogleSearchTest {
    public static void main(String[] args)
    {
        //a.google web sayfasına gidin. https://www.google.com/
        System.setProperty("webdriver.chrome.driver","C:/Users/Emre Duman/Documents/selenium dependencies/drivers/chromedriver.exe");
        WebDriver driver =new ChromeDriver();
        driver.get("https://www.google.com/");

        //b. Search(ara) “city bike”
        WebElement googleSearchBox = driver.findElement(By.name("q"));
        googleSearchBox.sendKeys("city bike");
        googleSearchBox.submit();

        //c. Google'da görüntülenen ilgili sonuçların sayısını yazdırın
        WebElement allResults = driver.findElement(By.id("result-stats"));
        System.out.println(allResults.getText());//About 4,690,000,000 results

        //d. “Shopping” e tıklayın.
        driver.findElement(By.linkText("Images")).click();

        //e. Sonra karşınıza çıkan ilk sonucun resmine tıklayın.
        driver.findElement(By.className("s0Fsx")).click();
    }
}

class day04_Locators_xpath {
    public static void main(String[] args)
    {
        //Kullanici http://a.testaddressbook.com/sign_in adresine gitsin.
        System.setProperty("webdriver.chrome.driver","C:/Users/Emre Duman/Documents/selenium dependencies/drivers/chromedriver.exe");
        WebDriver driver =new ChromeDriver();
        driver.get("http://a.testaddressbook.com/sign_in");

        //email text box'i absolute xpath kullanarak locate edin
        WebElement emailTextBox = driver.findElement(By.xpath("html/body/div/div/div/div/form/div[1]/input"));
        emailTextBox.sendKeys("testtechproed@gmail.com");  //Kullanici adini giriniz =>> Username : testtechproed@gmail.com

        //password text boxi relative xpath kullanarak locate edin
        WebElement passwordTextBox = driver.findElement(By.xpath("//input[@type='password']"));
        // (//input[@class="form-control"])[1] == //input[@class="form-control"]
        //cssSelector()'de böyle yapılmaz
        passwordTextBox.sendKeys("Test1234!");  //passwordu giriniz =>> Password : Test1234!

        //Locate signin button
        WebElement signinButton = driver.findElement(By.xpath("//input[@value='Sign in']"));
        signinButton.click();  //sign in düğmesini tıklayın
        driver.manage().window().maximize();
        //Ardından, beklenen(expected) user id  testtechproed@gmail.com dogrulayin(verify)
        //user id locate

        //*[.='text name']
        //<span class="navbar-text" data-test="current-user">testtechproed@gmail.com</span>
        WebElement userID = driver.findElement(By.xpath("//*[.='testtechproed@gmail.com']"));
        String actualUserID = userID.getText();
        String expectedUserId = "testtechproed@gmail.com";
        if(actualUserID.equals(expectedUserId)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("ACTUAL USER ID : "+actualUserID);
            System.out.println("EXPECTED USER ID : "+expectedUserId);
        }
        //Addresses ve Sign Out metinlerinin görüntülendiğini(isDisplayed) doğrulayin.

        //tagName[.='text name']
        WebElement addressLink = driver.findElement(By.xpath("//a[.='Addresses']"));
        System.out.println("ADDRESSES LINK TEXT :"+ addressLink.getText());


        //Sayfadaki toplam link sayısını bulun ve konsolda yazdirin
        List<WebElement> listOfLinkElements= driver.findElements(By.tagName("a"));
        System.out.println(listOfLinkElements.size());

        System.out.println("**********LINKS ON THE WEBPAGE*************");
        for (WebElement i:listOfLinkElements) {
            System.out.println(i.getText());
        }

        //Sayfadan çıkış yapın(Sign Out)

        WebElement sigOutLink=driver.findElement(By.xpath("//a[.='Sign out']"));
        System.out.println("SIGN OUT LINK TEST:"+sigOutLink.getText());
        sigOutLink.click();
        driver.close();






         /*
            8 tane locater vardir.
            By.id
            By.name
            By.classname
            By.tagName
            By.linkName
            By.partialLinkName



          */

          /*
            By.css

            By.cssSelector() method
            Css selector xpath'e benzer. Üç ana tip kullanılır
            <input type="email" class="form-control" placeholder="Email" data-test="email" name="session[email]" id="session_email">

            ● css = “tagName[attribute name='value']”
            ○ driver.findElement(By.cssSelector("input[name='session[email]']"));

            ● css="tagName#id value" or just css="#id value"=>yalnızca id value ile çalışır
            ○ driver.findElement(By.cssSelector("input#session_email"));

            ● css="tagName.class value" or just css=".class value"=>yalnızca class value ile çalışır
            ○ driver.findElement(By.cssSelector("input.form-control"));

           */


        /*

            XPATH
            1. Absolute xpath:
            Root elementten başlıyoruz.
            Her adımda parenttan childa gitmek zorundayız.
            / kullanırız .
            Bu yontem yaygın değil.
            Kısa olduğundan relative xpath kullanmayı tercih edin.

            html/body/div/div/div/div/form/div[1]/input => Bu, email text box için absolute xpath yoludur.
            //*[@style='font-size: 24px;']//br --> absolute path

            (//*[starts-with(@class, 'elementor')])[3]/div[2]//ins[contains(@class,'a')]/ins//iframe[@id='aswift_5']

              (//*[starts-with(@class, 'elementor')])[3] -->içice de olsa yanyana da olsa gösterir
              div/div/div[2]  --> sadece yanyanayssa gösterir, içiçeyi göstermez
         */



        /*

            Şimdi bu elemanı bulmak için locator kullanabiliriz.
            WebElement emailBox = driver.findElement(By.xpath("html/body/div/div/div/div/form/div[1]/input"));
            ===================================
            2.Relative xpath:
            Relative xpath'i bulurken, ortadaki herhangi bir yerden başlayabiliriz.
            Yani root elementten başlamak zorunda değiliz.
            // Kullanırız .
            1. //tag[@attibute ='value']; => belirli tag, belirli attribute, belirli attribute value ‘’ içinde olmalı, "" değil
            <input type="email" class="form-control" placeholder="Email" data-test="email" name="session[email]"
            id="session_email">
            ornek: //input[@type='email'];
            //input[@class='form-control']
            --------------------------------------------------------------
            <span class="navbar-text" data-test="current-user">testtechproed@gmail.com</span>
            2. //tagName[.='text name']; => belirli bir tag, herhangi bir attribute, belirli bir text
            ornek: //span[.='testtechproed@gmail.com'];
            -------------------------------------------------------------
            3.//*[.='text name']; => herhangi bir tag, herhangi bir attribute, belirli bir text
            ornek: //*[.='testtechproed@gmail.com'];
            ------------------------------------------------------------
            4.//*[(text()='text name')];
            ornek: //*[(text()='testtechproed@gmail.com')];
            ------------------------------------------------------------
            5.//*[contains(text(),'text name parcasi')];
            ornek: //*[contains(text(),'testtechproed@gmail')]
            -------------------------------------------------------------
            6. //tag[@attribute1='value 1' or attribute2='value2']
            <input type="email" class="form-control" placeholder="Email" data-test="email" name="session[email]"
            id="session_email">
            ornek: //input[@type='email' or name='session[email]'];


         */




        //3) OR & AND kullanma
        //Xpath=//*[@type=’submit’ or @name=’btnReset’]
        //Xpath=//input[@type=’submit’ and @name=’btnLogin’]


        //4) Starts-with Fonksiyonu:
        //Id=” message12″
        //Xpath=//label[starts-with(@id,’message’)]


        //5) Text():
        //Xpath=//td[text()=’UserID’]


        //ALL TYPES OF USAGE OF XPATH LOCATOR
        //http://www.barisekici.com/2020/01/19/xpath-kullanimi/


    }
}

class day05_cssSelector {
    public static void main(String[] args)
    {
        //Kullanici http://a.testaddressbook.com/sign_in adresine gitsin.
        System.setProperty("webdriver.chrome.driver","C:/Users/Emre Duman/Documents/selenium dependencies/drivers/chromedriver.exe");
        WebDriver driver =new ChromeDriver();
        driver.get("http://a.testaddressbook.com/sign_in");

        //email text box'i cssSelector kullanarak locate edin
        WebElement emailTextBox = driver.findElement(By.cssSelector("input[type='email']"));
        emailTextBox.sendKeys("testtechproed@gmail.com");  //Kullanici adini giriniz =>> Username : testtechproed@gmail.com

        //password text boxi cssSelector kullanarak locate edin
        WebElement passwordTextBox = driver.findElement(By.cssSelector("input#session_password"));
        passwordTextBox = driver.findElement(By.cssSelector("input[name='session[password]']"));
        passwordTextBox.sendKeys("Test1234!");  //passwordu giriniz =>> Password : Test1234!

        WebElement signInButton = driver.findElement(By.cssSelector("input[data-test='submit']"));
        signInButton.click();
        /*
            "tag[attribute='value']"
            "tag#idName"
            #idName
            "tag.className"
            .className
         */

    }



}

class day05_checkbox {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:/Users/Emre Duman/Documents/selenium dependencies/drivers/chromedriver.exe");
        WebDriver driver =new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/checkboxes");

        WebElement checkBox1=driver.findElement(By.cssSelector("input[type='checkbox']"));
        checkBox1=driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        checkBox1=driver.findElement(By.xpath("//*[@type='checkbox']"));//buna [1] yazmaadım olur çünkü ilk bu var

        //CTRL+F -->
        //   (//input[@type='checkbox'])[1] works
        //   //input[@type='checkbox'][1] works

        if(!checkBox1.isSelected())
            checkBox1.click();
        else
            System.out.println("CheckBox 1 is already checked!!!");

        WebElement checkBox2=driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
        if(checkBox2.isEnabled())
            checkBox2.click();
        else
            System.out.println("CheckBox 2 is already checked!!!");

        if(checkBox2.isDisplayed())
            checkBox2.click();
        else
            System.out.println("CheckBox 2 is already checked!!!");

    }
}

class day06_facebook
{
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:/Users/Emre Duman/Documents/selenium dependencies/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");

/*
        driver.findElement(By.id("u_0_2")).click();
        driver.findElement(By.id("u_c_b")).sendKeys("emry");
        driver.findElement(By.id("u_c_d")).sendKeys("dmnyyy");
        driver.findElement(By.id("u_c_g")).sendKeys("deneme@gmail.com");
        driver.findElement(By.id("password_step_input")).sendKeys("Password!");
*/

        //sıgn up
        WebElement  Text=driver.findElement(By.xpath("//div[@class='_5iyx']"));
        System.out.println(Text.getText());

        WebElement signUpText=driver.findElement(By.xpath("//div[@class='mbs _52lq fsl fwb fcb']"));
        System.out.println(signUpText.getText());

        WebElement nameTextBox=driver.findElement(By.xpath("//input[@name='firstname']"));
        nameTextBox.sendKeys("firstname");

        WebElement surnameTextBox=driver.findElement(By.cssSelector("#u_0_o"));
        surnameTextBox.sendKeys("lastname");

        WebElement phoneORemail=driver.findElement(By.cssSelector("#u_0_r"));
        phoneORemail.sendKeys("test@gmail.com");

        WebElement phoneORemailRepeat=driver.findElement(By.id("u_0_u"));
        phoneORemailRepeat.sendKeys("test@gmail.com");

        WebElement passwordd=driver.findElement(By.id("password_step_input"));
        passwordd.sendKeys("password1234");

        WebElement day=driver.findElement(By.id("day"));
        day.sendKeys("29");
        WebElement month=driver.findElement(By.id("month"));
        month.sendKeys("march");
        WebElement year=driver.findElement(By.id("year"));
        year.sendKeys("1997");


        WebElement femaleRadioButton = driver.findElement(By.cssSelector("#u_0_6"));
        femaleRadioButton.click();

        WebElement maleRadioButton = driver.findElement(By.cssSelector("#u_0_7"));
        maleRadioButton.click();

        WebElement privateRadioButton = driver.findElement(By.cssSelector("#u_0_8"));
        privateRadioButton.click();

        if (!maleRadioButton.isSelected()) {   //true
            maleRadioButton.click();
        } else {
            System.out.println("Male seçeneği zaten seçili");
        }


        WebElement singUpButton=driver.findElement(By.id("u_0_12"));
        singUpButton.click();

        //sign ın
        WebElement email=driver.findElement(By.xpath("//input[@name='email']"));
        email.sendKeys("test@gmail.com");

        WebElement password=driver.findElement(By.xpath("//input[@name='pass']"));
        password.sendKeys("password1234");

        WebElement submitButton=driver.findElement(By.id("u_0_4"));
        submitButton.click();





    }
}