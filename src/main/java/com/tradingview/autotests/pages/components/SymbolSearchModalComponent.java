package com.tradingview.autotests.pages.components;

import com.codeborne.selenide.SelenideElement;
import com.tradingview.autotests.pages.ChartPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SymbolSearchModalComponent {

    private final SelenideElement searchInput = $(byAttribute("data-role", "search"));
    private final SelenideElement symbolDescription = $$("[class*=\"symbolDescription\"]").first();

    @Step("В строке поиска вводим название валютной пары {value}")
    public SymbolSearchModalComponent setValue(String value) {
        searchInput.setValue(value);
        return this;
    }

    @Step("Нажимаем на название валютной пары")
    public ChartPage clickOnSymbol() {
        symbolDescription.click();
        return new ChartPage();
    }
}
