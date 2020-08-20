package miscalleneous;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class MultipleWindow {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jaishan\\Desktop\\webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebDriverWait w = new WebDriverWait(driver, 5);

        driver.get("https://www.tutorialspoint.com/index.htm");
        System.out.println("Before Switching:");
        System.out.println(driver.getTitle());
        driver.findElement(By.xpath("//a[@title='Tools - Online Development and Testing Tools']")).click();

        Set<String> ids= driver.getWindowHandles(); // to bring out all the windows open
        Iterator<String> it = ids.iterator(); // iterate method to the steps in the set of data structure
        String parentId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId);
        System.out.println("After switching: ");
        System.out.println(driver.getTitle());

        driver.switchTo().window(parentId); // To switch back to parent window
        System.out.println("After switching back to parent: ");
        System.out.println(driver.getTitle());



    }
}
