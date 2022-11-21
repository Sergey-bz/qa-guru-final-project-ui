package com.tradingview.autotests.pages;

import com.codeborne.selenide.SelenideElement;
import com.tradingview.autotests.pages.components.SignInModalComponent;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SignInPage {

    private final SelenideElement userMenu = $(byAttribute("aria-label", "Open user menu"));
    private final SelenideElement signInButton = $(byText("Sign in"));
    SignInModalComponent signInModalComponent = new SignInModalComponent();

    @Step("Открываем страницу входа")
    public SignInPage openPage() {
        open("/");
        return this;
    }

    @Step("Открываем меню пользователя")
    public SignInPage openUserMenu() {
        userMenu.click();
        return this;
    }

    @Step("Нажимаем кнопку \"Sign in\"")
    public SignInPage pressSignInButton() {
        signInButton.click();
        return this;
    }

    @Step("Выполняем вход в систему")
    public SignInPage signIn(String username, String password) {
        signInModalComponent
                .switchEmailToggle()
                .setUsername(username)
                .setPassword(password)
                .pressSignInButton();
        return this;
    }
}
