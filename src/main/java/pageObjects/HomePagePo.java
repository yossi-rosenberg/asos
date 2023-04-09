package pageObjects;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.junit.Assert;

public class HomePagePo {
    String urlAddress = "http://asos.com";
    String shopManName = "SHOP MEN";
    String myAccountName = "My Account";
    String joinName = "Join";

    public HomePagePo(Page page) {
    }

    //TODO Move to abstract page
    public void validatePage(Page page) {
        Assert.assertTrue(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(shopManName)).isVisible());
    }
    public void clickJoin(Page page) {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(myAccountName)).hover();
        page.getByText(joinName).click();
    }
    public void navigateToPage(Page page) {
        page.navigate(urlAddress);
    }
}
