import com.shaft.driver.SHAFT;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class usertest {

    SHAFT.GUI.WebDriver driver;
    usersubscription user;
    String actualcurrency;
    int actualprice;



@BeforeMethod
    public void browsersetup(){
    driver=new SHAFT.GUI.WebDriver();
    driver.browser().navigateToURL("https://subscribe.stctv.com/sa-ar");
    user=new usersubscription(driver);


}


   @Test
    public void validatesaudiuser() {

       if (user.choosesaudicountry()) {
           actualcurrency = user.validateperminumcurrencytype();
           String expectedcurrency = "ريال سعودي/الشهر";
           Assert.assertEquals(actualcurrency, expectedcurrency);
           actualprice = user.validatesuaidandbahrianperminumprice();
           int expectedprice = 15;
           Assert.assertEquals(actualprice, expectedprice);
           String basicsubscription=user.verifybasicuser();
           Assert.assertEquals(basicsubscription,"اشترك الآن مجاناً");
           String perminumsubscription=user.verifyperminumuser();
           Assert.assertEquals(perminumsubscription,"ابدأ تجربتك المجانية");
       }
   }



       @Test
       public void validatekwauiateuser () {

           if (user.choosekwauitcountry()) {
               actualcurrency = user.validateperminumcurrencytype();
               String expectedcurrency = "دينار كويتي/الشهر";
               Assert.assertEquals(actualcurrency, expectedcurrency);
               double actualprice=Double.valueOf(user.validatekwuaitprice());
               double expectedprice = 2.5;
               Assert.assertEquals(actualprice, expectedprice);
               String basicsubscription=user.verifybasicuser();
               Assert.assertEquals(basicsubscription,"اشترك الآن مجاناً");
               String perminumsubscription=user.verifyperminumuser();
               Assert.assertEquals(perminumsubscription,"ابدأ تجربتك المجانية");
           }
       }


       @Test
       public void validatebahrianuser () {

           if (user.choosebahrincountry()) {
               actualcurrency = user.validateperminumcurrencytype();
               String expectedcurrency = "دينار بحريني/الشهر";
               Assert.assertEquals(actualcurrency, expectedcurrency);
               actualprice = user.validatesuaidandbahrianperminumprice();
               int expectedprice = 3;
               Assert.assertEquals(actualprice, expectedprice);
               String basicsubscription=user.verifybasicuser();
               Assert.assertEquals(basicsubscription,"اشترك الآن مجاناً");
               String perminumsubscription=user.verifyperminumuser();
               Assert.assertEquals(perminumsubscription,"ابدأ تجربتك المجانية");
           }
       }


   }
