package pageObjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.junit.Assert;

import java.text.ParseException;

public class SignUpPagePo extends AbsPagePo {
    String emailAddress = "EMAIL ADDRESS";
    String firstName = "FIRST NAME";
    String lastName = "LAST NAME";
    String password = "PASSWORD";
    String selectAllContactPreferences = "Select all contact preferences";
    String googleIntegration = "google GOOGLE";
    String appleIntegration = "apple APPLE";
    String facebookIntegration = "facebook FACEBOOK";

    String emptyEmailError =  "Oops! You need to type your email here";

    String wrongInputEmailError = "Email fail! Please type in your correct email address";

    String emptyFirstNameError = "We need your first name – it’s nicer that way";

    String emptyLastNameError = "Last name, too, please!";

    String emptyPasswordError = "Hey, we need a password here";
    String shortPasswordError = "Erm, you need 10 or more characters";

    String emptyDob = "Enter your full date of birth";

    String tooYoungError = "Oops. Looks like you're too young to use ASOS.";
    String sleepsToGoError = "sleeps to go!";

    String wrongInputEmail = "t345fgbht^&@4";

    String wrongInputPassword = "012345678";

    public SignUpPagePo(Page page) {
    }

    //TODO Move to abstract page (WITH AriaRole AS ENUM PARAM ,impl no not require here since autoWait
    public void validatePage(Page page) {

    }
    public void signup(Page page,Boolean checkAllContactPreferences) {
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName(emailAddress)).fill("Honey@Honeybook.com");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName(firstName)).fill("Honey");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName(lastName)).fill("Book");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName(password)).fill("0123456789");
        super.setDateOfBirth(page,"5","9","1985");
        if(checkAllContactPreferences)
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(selectAllContactPreferences)).click();
    }

    public void signUpAllFieldsEmptyValidationFlow(Page page) {
        Assert.assertTrue(page.getByText(emptyFirstNameError).isVisible());
        Assert.assertTrue(page.getByText(emptyLastNameError).isVisible());
        Assert.assertTrue(page.getByText(emptyEmailError).isVisible());
        Assert.assertTrue(page.getByText(emptyPasswordError).isVisible());
        Assert.assertTrue(page.getByText(emptyDob).nth(1).isVisible());
    }

    public void signUpWrongInputFieldsValidationFlow(Page page,String email, String fname, String lname) throws ParseException, InterruptedException {
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName(emailAddress)).fill(wrongInputEmail);
        page.keyboard().press("Backspace");
        Assert.assertTrue(page.getByText(wrongInputEmailError).isVisible());
        Assert.assertFalse(page.getByText(emptyEmailError).isVisible());
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName(emailAddress)).fill(email);
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName(firstName)).fill(fname);
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName(lastName)).fill(lname);
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName(password)).fill(wrongInputPassword);
        page.keyboard().press("Backspace");
        Assert.assertTrue(page.getByText(shortPasswordError).isVisible());
        Assert.assertFalse(page.getByText(emptyPasswordError).isVisible());
        super.setDateOfBirth(page,"5","9","2007");
        Assert.assertTrue(page.getByText(tooYoungError).isVisible());
        page.getByText(Utils.calculateDaysTillUser16("5" , "SEP","2007") + " " + sleepsToGoError).hover();
        super.setDateOfBirth(page,"5","Month","2007");
        Thread.sleep(500);
        Assert.assertTrue(page.getByText(emptyDob).nth(1).isVisible());
        super.setDateOfBirth(page,"5","9","2003");
        //TODO uncomment when bug error message not vanished despite the date is valid will be fixed
        //Assert.assertFalse(page.getByText(emptyDob).nth(1).isVisible());

    }

    public void clickGoogleIntButton(Page page) {
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(googleIntegration)).click();
    }

    public void clickAppleintButton(Page page) {
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(appleIntegration)).click();
    }

    public void clickFacebookintButton(Page page) {
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(facebookIntegration)).click();
    }
}
