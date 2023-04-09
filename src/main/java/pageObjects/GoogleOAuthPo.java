package pageObjects;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class GoogleOAuthPo extends AbsIntegrationPage{
    String password = "Enter your password";
    public GoogleOAuthPo() {
        super.emailAddress = "Email or phone";
        super.submitButton = "Next";
    }

    public void setPassword(Page page, String passwordValue) {
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName(password)).fill("0123456789");
    }

    public void clickGoogleNextButton(Page page) {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(super.submitButton)).click();
    }

}
