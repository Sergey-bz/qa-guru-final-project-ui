package com.tradingview.autotests.pages.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;

public class HeaderComponent {

    private final SelenideElement productsItem = $(byAttribute("data-main-menu-root-track-id", "products"));
    private final SelenideElement mainMenu = $(".tv-header__main-menu");
    private final ElementsCollection mainMenuItems = mainMenu.$$(".tv-header__main-menu-item");

    @Step("Навести курсор на \"Продукты\"")
    public ProductsComponent hoverOverProducts() {
        productsItem.hover();
        return new ProductsComponent();
    }

    @Step("Проверка, что меню содержит разделы: {items}")
    public HeaderComponent shouldHaveItems(String... items) {
        mainMenuItems.shouldHave(texts(items));
        return this;
    }
}
