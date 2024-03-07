import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class test1 {
    public static void main(String[] args) {
        String vc = "9XPU439JEGET";
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://pedigreeoffer.com/");
        WebElement voucherCode = driver.findElement(By.id("key"));
        WebElement name = driver.findElement(By.id("name"));
        WebElement email = driver.findElement(By.id("email"));
        WebElement phno = driver.findElement(By.id("mobile"));
        WebElement mode = driver.findElement(By.id("selectedoffer"));
        WebElement upiid = driver.findElement(By.id("upidetails"));
        Select dd = new Select(mode);
        voucherCode.sendKeys(vc);
        name.sendKeys("Suyog Kukde");
        email.sendKeys("kukdesuyog@gmail.com");
        phno.sendKeys("7470989629");
        dd.selectByValue("2");
        upiid.sendKeys("7470989629@paytm");
    }
}
