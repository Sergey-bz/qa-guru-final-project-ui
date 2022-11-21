package com.tradingview.autotests.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.tradingview.autotests.pages.components.IndicatorsModalComponent;
import com.tradingview.autotests.pages.components.SymbolSearchModalComponent;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ChartPage {

    private final SelenideElement chartWidget = $(".chart-widget");
    private final SelenideElement indicatorsButton = $("#header-toolbar-indicators");
    private final SelenideElement indicatorSourceLegend = $$("[class*=\"legend\"]").last();
    private final ElementsCollection indicatorSourceLegendTitles = indicatorSourceLegend.$$("[data-name=\"legend-source-title\"]");
    private final SelenideElement mainSourceLegend = $("[class*=\"legendMainSourceWrapper\"]");
    private final SelenideElement symbolSearchButton = $("#header-toolbar-symbol-search");

    @Step("Проверка, что график открылся")
    public ChartPage shouldBeOpened() {
        chartWidget.shouldBe(visible);
        return this;
    }

    @Step("Открываем модальное окно \"Индикаторы\"")
    public IndicatorsModalComponent openIndicatorsModal() {
        indicatorsButton.click();
        return new IndicatorsModalComponent();
    }

    @Step("Заголовок легенды виджета индикатора содержит текст {texts}")
    public ChartPage indicatorLegendShouldHaveTexts(String... texts) {
        indicatorSourceLegendTitles.shouldHave(texts(texts));
        return this;
    }

    @Step("Заголовок легенды графика содержит текст {text}")
    public ChartPage mainLegendShouldHaveText(String text) {
        mainSourceLegend.shouldHave(text(text));
        return this;
    }

    @Step("Открываем окно выбора валютной пары")
    public SymbolSearchModalComponent clickOnSymbolSearchButton() {
        symbolSearchButton.click();
        return new SymbolSearchModalComponent();
    }
}
