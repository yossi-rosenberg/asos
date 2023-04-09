import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.Test;
import pageObjects.*;

import java.text.ParseException;

public class signUpTests {
    String email = "honey@gmail.com";
    String fname = "honey";

    String lname = "book";

    @Test
    public void signUpHappyFlow() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
            HomePagePo homePagePo = new HomePagePo(page);
            homePagePo.navigateToPage(page);
            homePagePo.validatePage(page);
            homePagePo.clickJoin(page);

            SignUpPagePo signUpPagePo = new SignUpPagePo(page);
            signUpPagePo.signup(page, true);
            signUpPagePo.clickSubmitIntButton(page);

            homePagePo.validatePage(page);
        }
    }

    @Test
    public void signUpAppleFlow() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
            HomePagePo homePagePo = new HomePagePo(page);
            homePagePo.navigateToPage(page);
            homePagePo.validatePage(page);
            homePagePo.clickJoin(page);

            SignUpPagePo signUpPagePo = new SignUpPagePo(page);
            signUpPagePo.clickAppleintButton(page);

            AppleOAuthPo appleOAuthPo = new AppleOAuthPo();
            appleOAuthPo.insertEmailAddress(page, email);
            appleOAuthPo.clickSubmitButton(page);
            appleOAuthPo.setVerificationCode(page, "123456");
            appleOAuthPo.clickContinueButton(page);
            appleOAuthPo.clickTrustButton(page);
            appleOAuthPo.clickContinueButton(page);

            homePagePo.validatePage(page);
        }
    }

    @Test
    public void signUpGoogleFlow() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
            HomePagePo homePagePo = new HomePagePo(page);
            homePagePo.navigateToPage(page);
            homePagePo.validatePage(page);
            homePagePo.clickJoin(page);

            SignUpPagePo signUpPagePo = new SignUpPagePo(page);
            signUpPagePo.clickGoogleIntButton(page);

            GoogleOAuthPo googleOAuthPo = new GoogleOAuthPo();
            googleOAuthPo.insertEmailAddress(page, email);
            googleOAuthPo.clickSubmitButton(page);
            googleOAuthPo.setPassword(page, "0123456789");
            googleOAuthPo.clickGoogleNextButton(page);

            homePagePo.validatePage(page);
        }
    }

    @Test
    public void signUpFacebookFlow() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
            HomePagePo homePagePo = new HomePagePo(page);
            homePagePo.navigateToPage(page);
            homePagePo.validatePage(page);
            homePagePo.clickJoin(page);

            SignUpPagePo signUpPagePo = new SignUpPagePo(page);
            signUpPagePo.clickFacebookintButton(page);

            FacebookOAuthPo facebookOAuthPo = new FacebookOAuthPo(email);
            facebookOAuthPo.insertEmailAddress(page, email);
            facebookOAuthPo.clickSubmitButton(page);
            facebookOAuthPo.clickContinueAs(page);

            homePagePo.validatePage(page);

        }
    }

    @Test
    public void signUpEmptyInputsValidationsFlow() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
            HomePagePo homePagePo = new HomePagePo(page);
            homePagePo.navigateToPage(page);
            homePagePo.validatePage(page);
            homePagePo.clickJoin(page);

            SignUpPagePo signUpPagePo = new SignUpPagePo(page);

            signUpPagePo.clickSubmitIntButton(page);
            signUpPagePo.signUpAllFieldsEmptyValidationFlow(page);

        }
    }

    @Test
    public void signUpWrongInputsValidationsFlow() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
            HomePagePo homePagePo = new HomePagePo(page);
            homePagePo.navigateToPage(page);
            homePagePo.validatePage(page);
            homePagePo.clickJoin(page);

            SignUpPagePo signUpPagePo = new SignUpPagePo(page);

            signUpPagePo.clickSubmitIntButton(page);
            signUpPagePo.signUpWrongInputFieldsValidationFlow(page, email, fname, lname);

        } catch (ParseException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

