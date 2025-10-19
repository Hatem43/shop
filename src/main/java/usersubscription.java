import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class usersubscription {

    SHAFT.GUI.WebDriver driver;

    By saudiperminumcurrency = By.xpath("//i[contains(text(),'ريال سعودي/الشهر')]");
    By kwauitperminumcurrency = By.xpath("//i[contains(text(),'دينار كويتي/الشهر')]");
    By baherianperminumcurrency = By.xpath("//i[contains(text(),'دينار بحريني/الشهر')]");
    By country = By.xpath("//button[@class='button_inverse__ueyEl button_button-head__d88cp button_button__3jnva header-country-switch']");
    By saudicountry = By.xpath("//*[@id=\"sa-country-flag\"]");
    By kwuaitcountry = By.xpath("//div[@id='kw-country-flag']");
    By bahrincountry = By.xpath("//*[@id=\"bh-country-flag\"]");
    By saudiperminum = By.xpath("//*[@id=\"wrapper\"]/div[1]/div/div/div[2]/div[4]/div/b");
    By kuwaitperminum = By.xpath("//*[@id=\"wrapper\"]/div[1]/div/div/div[2]/div[4]/div/b");
    By bahrenperminum = By.xpath("//*[@id=\"wrapper\"]/div[1]/div/div/div[2]/div[4]/div/b");
    By basicuser=By.xpath("//strong[contains(text(),'بيسك')]");
    By perminumuser=By.xpath("//strong[contains(text(),'بريميوم')]");
    By basicsubscribe=By.xpath("//a[contains(text(),'اشترك الآن مجاناً')]");
    By perminumsubscribe=By.xpath("//a[contains(text(),'ابدأ تجربتك المجانية')]");


    boolean saudiain = false;
    boolean kwatian = false;
    boolean bahrian = false;
    String basice="";
    String perminume="";

    public usersubscription(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public boolean choosesaudicountry() {
        driver.element().click(country);
        driver.element().click(saudicountry);
        saudiain = true;
        return saudiain;
    }

    public boolean choosekwauitcountry() {
        driver.element().click(country);
        driver.element().click(kwuaitcountry);
        kwatian = true;
        return kwatian;

    }

    public boolean choosebahrincountry() {
        driver.element().click(country);
        driver.element().click(bahrincountry);
        bahrian = true;
        return bahrian;

    }

    public String verifybasicuser(){
        String basic=driver.element().getText(basicuser);

        if(basic.equalsIgnoreCase("بيسك")){
             basice=driver.element().getText(basicsubscribe);
        }
        return basice;
    }

    public String verifyperminumuser(){
        String perminum=driver.element().getText(perminumuser);

        if (perminum.equalsIgnoreCase("بريميوم")){
            perminume=driver.element().getText(perminumsubscribe);
        }
        return perminume;
    }


    public String validateperminumcurrencytype() {

        String actualcurrency = "";


        if (saudiain) {

            actualcurrency = driver.element().getText(saudiperminumcurrency);
        } else if (kwatian) {
            actualcurrency = driver.element().getText(kwauitperminumcurrency);

        } else if (bahrian) {
            actualcurrency = driver.element().getText(baherianperminumcurrency);
        }

        return actualcurrency;
    }


    public int validatesuaidandbahrianperminumprice() {

        int price = 0;

        if (saudiain) {
            price = Integer.parseInt(driver.element().getText(saudiperminum));
        } else if (bahrian) {

            price = Integer.parseInt(driver.element().getText(bahrenperminum));
        }

        return price;

    }

    public double validatekwuaitprice() {

        double kwuaitprice=0.0;

        if (kwatian) {

            kwuaitprice = Double.parseDouble(driver.element().getText(kuwaitperminum));
        }
        return kwuaitprice;
    }
}
