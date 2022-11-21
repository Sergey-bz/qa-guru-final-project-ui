package com.tradingview.autotests.pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class SignInModalComponent {

    private final SelenideElement emailToggle = $(byText("Email"));
    private final SelenideElement usernameInput = $(byName("username"));
    private final SelenideElement passwordInput = $(byName("password"));
    private final SelenideElement signInButton = $(".tv-button__loader");

    @Step("Переключаемся на вход по Email")
    public SignInModalComponent switchEmailToggle() {
        emailToggle.click();
        return this;
    }

    @Step("Вводим имя пользователя")
    public SignInModalComponent setUsername(String username) {
        this.usernameInput.setValue(username);
        return this;
    }

    @Step("Вводим пароль")
    public SignInModalComponent setPassword(String password) {
        this.passwordInput.setValue(password);
        return this;
    }

    @Step("Нажимаем кнопку \"Sign in\"")
    public SignInModalComponent pressSignInButton() {
        signInButton.click();
        return this;
    }
}
