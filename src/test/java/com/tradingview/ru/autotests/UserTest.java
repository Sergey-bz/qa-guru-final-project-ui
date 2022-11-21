package com.tradingview.ru.autotests;

import com.tradingview.autotests.pages.HomePage;
import com.tradingview.autotests.pages.SignInPage;
import com.tradingview.autotests.pages.components.HeaderComponent;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("User")
public class UserTest extends BaseTest {

    protected final HeaderComponent headerComponent = new HeaderComponent();
    private final SignInPage signInPage = new SignInPage();
    private final HomePage homePage = new HomePage();

    @BeforeEach
    public void signIn() {
        signInPage
                .openPage()
                .openUserMenu()
                .pressSignInButton()
                .signIn(username, password);
    }

    @Test
    @DisplayName("Вход в систему")
    public void signInTest() {
        homePage
                .clickOnUserMenuButton()
                .checkSignInSuccess(username);
    }

    @Test
    @DisplayName("Изменение языка интерфейса")
    public void changeLanguageTest() {
        homePage
                .clickOnUserMenuButton()
                .hoverOverLanguage()
                .selectLanguageByValue("Русский");

        headerComponent
                .shouldHaveItems("Продукты", "Сообщество", "Рынки", "Новости", "Брокеры", "Ещё");
    }
}
