package pageObjects;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class AbsPagePo {

    String dateOfBirthDay = "Date of birth Day";
    String dateOfBirthMonth =  "Date of birth Month";
    String dateOfBirthYear = "Date of birth Year";
    String submitIntButton = "Join ASOS";

    public void setDateOfBirth(Page page,String dateOfBirthDayValue,String dateOfBirthMonthValue,String dateOfBirthYearValue) {
        page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName(dateOfBirthDay)).selectOption(dateOfBirthDayValue);
        page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName(dateOfBirthMonth)).selectOption(dateOfBirthMonthValue);
        page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName(dateOfBirthYear)).selectOption(dateOfBirthYearValue);
    }

    public void clickSubmitIntButton(Page page) {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(submitIntButton)).click();
    }

}
