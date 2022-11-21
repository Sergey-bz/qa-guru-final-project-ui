package com.tradingview.ru.autotests;

import com.tradingview.autotests.pages.ChartPage;
import com.tradingview.autotests.pages.HomePage;
import com.tradingview.autotests.pages.SignInPage;
import com.tradingview.autotests.pages.components.HeaderComponent;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("Chart")
public class ChartTest extends BaseTest {

    private final ChartPage chartPage = new ChartPage();
    private final HeaderComponent headerComponent = new HeaderComponent();
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
    @DisplayName("Sign in")
    public void signInTest() {
        homePage
                .clickOnUserMenuButton()
                .checkSignInSuccess(username);
    }

    @Test
    @DisplayName("Open chart")
    public void openChartTest() {
        headerComponent
                .hoverOverProducts()
                .clickOnChart();

        chartPage
                .shouldBeOpened();
    }

    @Test
    @DisplayName("Add indicator")
    public void addIndicatorTest() {
        headerComponent
                .hoverOverProducts()
                .clickOnChart()
                .shouldBeOpened()
                .openIndicatorsModal()
                .searchIndicatorByName("Relative Strength Index")
                .selectIndicatorByValue("STD;RSI")
                .closeIndicatorsModal();

        chartPage
                .indicatorLegendShouldHaveTexts("RSI", "14 close SMA 14 2");
    }

    @Test
    @DisplayName("Symbol search")
    public void symbolSearchTest() {
        headerComponent
                .hoverOverProducts()
                .clickOnChart()
                .shouldBeOpened()
                .clickOnSymbolSearchButton()
                .setValue("USDJPY")
                .clickOnSymbol();

        chartPage
                .mainLegendShouldHaveText("U.S. Dollar / Japanese Yen");
    }

    @Test
    @DisplayName("Change language")
    public void changeLanguageTest() {
        homePage
                .clickOnUserMenuButton()
                .hoverOverLanguage()
                .selectLanguageByValue("Русский");

        headerComponent
                .shouldHaveItems("Продукты", "Сообщество", "Рынки", "Новости", "Брокеры", "Ещё");
    }
}
