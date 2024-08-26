package com.coherentsolutions.java.webauto.section02;

import com.codeborne.selenide.SelenideElement;
import com.coherentsolutions.java.webauto.section02.basicclasses.PageBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class UserAccountPage extends PageBase {

    private SelenideElement ybarMailLink = $("#ybarMailLink");

    public boolean isDisplayedMailLink() {
        return ybarMailLink.shouldBe(visible).isDisplayed();
    }
}

