package com.tradingview.autotests.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    private final SelenideElement userMenuButton = $(".tv-header__user-menu-button-userpic");
    private final SelenideElement userMenuProfileHeader = $(byAttribute("data-name", "header-user-menu-profile"));
    private final SelenideElement languageItem = $(byText("Language"));

    @Step("Открываем меню пользователя")
    public HomePage clickOnUserMenuButton() {
        userMenuButton.click();
        return this;
    }

    @Step("Проверка, что вход успешный")
    public HomePage checkSignInSuccess(String username) {
        userMenuProfileHeader.shouldHave(text(username));
        return this;
    }

    @Step("Навести курсор на строку выбора языка")
    public HomePage hoverOverLanguage() {
        languageItem.hover();
        return this;
    }

    @Step("Выбор языка {value}")
    public HomePage selectLanguageByValue(String value) {
        $(byText(value)).click();
        return this;
    }
}
