package pageObjects;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class AppleOAuthPo extends AbsIntegrationPage{
    String password = "Password";
    String signInBtn = "Sign In";
    String verCodeDAigit1 = "Enter verification code. On entering code in the input fields, the focus will automatically move on to the next input fields.\n" +
            "After entering the verification code, the page gets updated automatically. Digit 1";
    String verCodeDigits2to6 = "Digit";
    String trustButton = "Trust";

    String continueButton = "Continue";

    String shareMyEmailRadio = "Share My Email";
    public AppleOAuthPo() {
        super.emailAddress = "Sign in with your Apple ID";
        super.submitButton = "Continue";
    }

    public void setPassword(Page page, String passwordValue) {
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName(password)).fill("0123456789");
    }

    public void setVerificationCode(Page page, String vercode) {
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName(verCodeDAigit1)).fill(String.valueOf(vercode.charAt(0)));
        for (int i=2; i < 7; i++) {
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName(verCodeDigits2to6 + " i")).fill(String.valueOf(vercode.charAt(i-1)));
        }
    }
    public void clickGoogleNextButton(Page page) {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(super.submitButton)).click();
    }
    public void clickSignInButton(Page page) {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(signInBtn)).click();
    }

    public void clickTrustButton(Page page) {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(trustButton)).click();
    }

    public void clickContinueButton(Page page) {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(continueButton)).click();
    }
    public void clickShareMyEmailRadioButton(Page page, String email) {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(shareMyEmailRadio + " " + email)).click();
    }

}

