package com.tradingview.ru.autotests;

import com.tradingview.autotests.pages.ChartPage;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("Chart")
public class ExchangeTest extends UserTest {

    private final ChartPage chartPage = new ChartPage();

    @Test
    @DisplayName("Открытие графика")
    public void openChartTest() {
        headerComponent
                .hoverOverProducts()
                .clickOnChart();

        chartPage
                .shouldBeOpened();
    }

    @Test
    @DisplayName("Добавление индикатора на график")
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
    @DisplayName("Изменение валютной пары")
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


}
