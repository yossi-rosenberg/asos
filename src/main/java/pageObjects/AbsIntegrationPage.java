package pageObjects;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public abstract class AbsIntegrationPage extends AbsPagePo{
    String emailAddress;

    String submitButton;

    public void insertEmailAddress(Page page,String value) {
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName(emailAddress)).fill(value);
    }
    public void clickSubmitButton(Page page) {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(submitButton)).click();
    }
}
