package generalstore.utils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class ReusableMethods {

    public static void bekle(int second){
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            System.out.println("Bekleme yapilamadi");
            throw new RuntimeException(e);
        }
    }

    public static void clickGesture(AndroidDriver driver, WebElement element){
        driver.executeScript("mobile: clickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId()
        ));
    }

    public static void clickGesture(AndroidDriver driver, int x, int y){
        driver.executeScript("mobile: clickGesture", ImmutableMap.of(
                "x", x,
                "y", y
        ));
    }


    public static void doubleClickGesture(AndroidDriver driver, WebElement element){
        driver.executeScript("mobile: doubleClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId()
        ));
    }

    public static void doubleClickGesture(AndroidDriver driver, int x, int y){
        driver.executeScript("mobile: doubleClickGesture", ImmutableMap.of(
                "x", x,
                "y", y
        ));
    }

    public static void longClickGesture(AndroidDriver driver, WebElement element){
        driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId()
        ));
    }

    public static void longClickGesture(AndroidDriver driver, WebElement element, int milisecond){
        driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "duration", milisecond
        ));
    }

    public static void longClickGesture(AndroidDriver driver, int x, int y){
        driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
                "x", x,
                "y", y
        ));
    }

    public static void longClickGesture(AndroidDriver driver, int x, int y, int milisecond){
        driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
                "x", x,
                "y", y,
                "duration", milisecond
        ));
    }

    public static void dragGesture(AndroidDriver driver, WebElement element, int endX, int endY){
        driver.executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "endX", endX,
                "endY", endY
        ));
    }


    public static void dragGesture(AndroidDriver driver, int startX, int startY, int endX, int endY){
        driver.executeScript("mobile: dragGesture", ImmutableMap.of(
                "startX", startX,
                "startY", startY,
                "endX", endX,
                "endY", endY
        ));
    }

    public static void swipeGesture(AndroidDriver driver, WebElement element, String direction, double percent, int speed){
        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", direction,
                "percent", percent,
                "speed", speed
        ));
    }

    public static void scrollGesture(AndroidDriver driver, WebElement element, String direction, double percent, int speed){
        driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", direction,
                "percent", percent,
                "speed", speed
        ));
    }

    //Visible Wait
    public static void visibleWait(AndroidDriver driver, WebElement element, int sayi) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sayi));
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    public static void raporuAc(){
        // Rapor dosyasının tam yolu
        String raporYolu = System.getProperty("user.dir") + "\\raporlar\\CucumberRapor.html";

        try {
            // Google Chrome'un çalıştırılması
            String chromePath = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
            String command = chromePath + " " + raporYolu;
            Process process = Runtime.getRuntime().exec(command);

            // İşlemi bekleyin
            process.waitFor();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }


}
