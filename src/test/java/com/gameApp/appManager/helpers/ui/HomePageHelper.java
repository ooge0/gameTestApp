package com.gameApp.appManager.helpers.ui;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import com.gameApp.appManager.helpers.HelperBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class HomePageHelper extends HelperBase {
    static Logger log = LogManager.getLogger(HomePageHelper.class);
    private HelperBase helperBase;
    // main bar elements
    /**
     * checkIn/Out
     */
    SelenideElement newHardware = $(Selectors.byXpath("//nav/ul/li/a[contains(@href,'new-hardware')]"));
    SelenideElement selectedProduct = $(Selectors.byCssSelector("#bc-sf-filter-products article:nth-child(1)"));
    SelenideElement searchButton = $(Selectors.byXpath("//*[@id=\"hotels\"]/div/div/form/div/div/div[4]/button"));
    SelenideElement comingSoon = $(Selectors.byXpath("//nav/ul/li/a[contains(@href,'comming-soon')]"));
    SelenideElement checkInInput = $(Selectors.byCssSelector("input[id=\"checkin\"]"));
    SelenideElement checkOutInput = $(Selectors.byCssSelector("input[id=\"checkout\"]"));
    /**
     * popUps & forms
     */
    SelenideElement popUpCloseButton = $(Selectors.byCssSelector("button[alt=\"Close form\"]"));


    SelenideElement cartButton = $(Selectors.byCssSelector(".dropdown.dropdown-login.dropdown-tab #dropdownCurrency"));

    /***  Search & Search result */
    ElementsCollection searchResultTitleList = $$(Selectors.byCssSelector("h2[class=\"productitem--title\"]"));
    ElementsCollection itemsList = $$(Selectors.byCssSelector("h2[class=\"productitem--title\"]"));
    ElementsCollection sortedResultList = $$(Selectors.byCssSelector("#bc-sf-filter-products .productitem"));
    SelenideElement firstSortedResultList = $(Selectors.byCssSelector("#bc-sf-filter-products>article:first-of-type"));

    /**
     * Product page
     */
    SelenideElement preOrder = $(Selectors.byXpath("//nav/ul/li/a[contains(@href,'pre-order')]"));
    ElementsCollection itemTitles = $$(Selectors.byCssSelector("#bc-sf-filter-products .productitem--title"));
    ElementsCollection itemDescriptions = $$(Selectors.byCssSelector("#bc-sf-filter-products .item-description"));
    ElementsCollection itemPrices = $$(Selectors.byCssSelector("#bc-sf-filter-products .item-description"));
    ElementsCollection itemStarRatings = $$(Selectors.byCssSelector("#bc-sf-filter-products .spr-starrating.spr-badge-starrating"));
    ElementsCollection itemReviews = $$(Selectors.byCssSelector("#bc-sf-filter-products .spr-badge-caption"));
    SelenideElement quantityItemDropdown = $(Selectors.byCssSelector("#product-quantity-select"));
    SelenideElement addToCartPopUpCloseButton = $(Selectors.byCssSelector(".atc-banner--container.visible button[aria-label=\"Close\"]"));
    SelenideElement addToCardButton = $(Selectors.byCssSelector("#addToCartCopy"));


}
