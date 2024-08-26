package com.coherentsolutions.java.webauto.section01;

import com.coherentsolutions.java.webauto.section01.basicclasses.PageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserAccountPage extends PageBase {

    @FindBy(id = "ybarMailLink")
    private WebElement ybarMailLink;

    public UserAccountPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public boolean isDisplayedMailLink() {
        return ybarMailLink.isDisplayed();
    }
}
