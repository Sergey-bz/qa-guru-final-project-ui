package com.tradingview.autotests.pages.components;

import com.codeborne.selenide.SelenideElement;
import com.tradingview.autotests.pages.ChartPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ProductsComponent {

    private final SelenideElement chartItem = $(byText("Chart+"));

    @Step("Открываем график")
    public ChartPage clickOnChart() {
        chartItem.click();
        return new ChartPage();
    }
}
