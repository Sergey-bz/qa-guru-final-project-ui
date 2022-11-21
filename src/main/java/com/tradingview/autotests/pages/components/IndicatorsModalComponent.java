package com.tradingview.autotests.pages.components;

import com.codeborne.selenide.SelenideElement;
import com.tradingview.autotests.pages.ChartPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;

public class IndicatorsModalComponent {

    private final SelenideElement searchInput = $(byAttribute("data-role", "search"));
    private final SelenideElement closeButton = $(byAttribute("data-name", "close"));

    @Step("Поиск индикатора {name}")
    public IndicatorsModalComponent searchIndicatorByName(String name) {
        searchInput.sendKeys(name);
        return this;
    }

    @Step("Выбор индикатора {value}")
    public IndicatorsModalComponent selectIndicatorByValue(String value) {
        $(byAttribute("data-id", value)).click();
        return this;
    }

    @Step("Закрываем модальное окно \"Индикаторы\"")
    public ChartPage closeIndicatorsModal() {
        closeButton.click();
        return new ChartPage();
    }
}
