package team.pages;


import team.utilities.Drivers;
import team.utilities.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;


public abstract class BasePage {



    public BasePage() {

        PageFactory.initElements(Drivers.get(), this);
    }




    /**
     * This method will navigate user to the specific module in vytrack application.
     * For example: if tab is equals to Activities, and module equals to Calls,
     * Then method will navigate user to this page: http://qa2.vytrack.com/call/
     *
     * @param tab
     * @param module
     */
    public void navigateToModule(String tab, String module) {
        String tabLocator = "//span[normalize-space()='" + tab + "' and contains(@class, 'title title-level-1')]";
        String moduleLocator = "//span[normalize-space()='" + module + "' and contains(@class, 'title title-level-2')]";
        try {
            Utils.waitForClickablility(By.xpath(tabLocator), 5);
            WebElement tabElement = Drivers.get().findElement(By.xpath(tabLocator));
            new Actions(Drivers.get()).moveToElement(tabElement).pause(200).doubleClick(tabElement).build().perform();
        } catch (Exception e) {
            Utils.clickWithWait(By.xpath(tabLocator), 5);
        }
        try {
            Utils.waitForPresenceOfElement(By.xpath(moduleLocator), 5);
            Utils.waitForVisibility(By.xpath(moduleLocator), 5);
            Utils.scrollToElement(Drivers.get().findElement(By.xpath(moduleLocator)));
            Drivers.get().findElement(By.xpath(moduleLocator)).click();
        } catch (Exception e) {
//            BrowserUtils.waitForStaleElement(Driver.get().findElement(By.xpath(moduleLocator)));
            Utils.clickWithTimeOut(Drivers.get().findElement(By.xpath(moduleLocator)),  5);
        }
    }

}
