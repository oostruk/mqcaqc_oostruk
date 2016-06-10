package com.softserve.edu.rs.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Created by obrylyuk on 6/5/2016.
 */
public class UsersPage extends AdminHomePage {

    private WebElement title;
    //Controls
    private WebElement actionsDropDown;
    private Select elementsCountDropDown;
    private WebElement elementsCountInTable;

    public static enum ChangeElementsOnPageFields {
        TEN("10"),
        TWENTY_FIVE("25"),
        FIFTY("50"),
        ONE_HUNDRED("100");
        //
        private String field;

        private ChangeElementsOnPageFields(String field) {
            this.field = field;
        }

        @Override
        public String toString() {
            return this.field;
        }
    }


    //Search
    private WebElement firstNameSearchInput;
    private WebElement lastNameSearchInput;
    private WebElement loginSearchInput;
    private WebElement communitySearchInput;
    private WebElement emailSearchInput;
    private Select roleSearchDropDown;
    private WebElement searchButton;

    //Ajax controls
    /*private WebElement setAsActiveAction;
    private WebElement blockAction;
    private WebElement setCommunityAction;
    private WebElement profileButton;*/

    //region Constructor
    public UsersPage(WebDriver driver) {
        super(driver);
        this.title = driver.findElement(By.xpath("//div[@id='body']/div/div/h4"));
        this.actionsDropDown = driver.findElement(By.id("dLabel"));
        this.elementsCountDropDown = new Select(driver.findElement(By.name("example_length")));
        this.elementsCountInTable = driver.findElement(By.id("example_info"));
        this.firstNameSearchInput = driver.findElement(By.id("inputIndex1"));
        this.lastNameSearchInput = driver.findElement(By.id("inputIndex2"));
        this.loginSearchInput = driver.findElement(By.id("inputIndex3"));
        this.communitySearchInput = driver.findElement(By.id("inputIndex4"));
        this.emailSearchInput = driver.findElement(By.id("inputIndex5"));
        this.roleSearchDropDown = new Select(driver.findElement(By.name("role_type")));
        this.searchButton = driver.findElement(By.id("bth-search"));
    }

    //endregion

    //region Getters
    public WebElement getTitle() {
        return title;
    }

    public WebElement getActionsDropDown() {
        return actionsDropDown;
    }

    public Select getElementsCountDropDown() {
        return elementsCountDropDown;
    }

    public WebElement getElementCountDropDownValueSelected(){
        return getElementsCountDropDown().getFirstSelectedOption();
    }

    public WebElement getElementsCountInTable() {
        return elementsCountInTable;
    }

    public WebElement getFirstNameSearchInput() {
        return firstNameSearchInput;
    }

    public WebElement getLastNameSearchInput() {
        return lastNameSearchInput;
    }

    public WebElement getLoginSearchInput() {
        return loginSearchInput;
    }

    public WebElement getCommunitySearchInput() {
        return communitySearchInput;
    }

    public WebElement getEmailSearchInput() {
        return emailSearchInput;
    }

    public Select getRoleSearchDropDown() {
        return roleSearchDropDown;
    }

    public WebElement getRoleSearchDropDownValueSelected(){
        return getRoleSearchDropDown().getFirstSelectedOption();
    }

    public WebElement getSearchButton() {
        return searchButton;
    }
    //endregion

    //region Get Text
    public String getTitleText() {
        return getTitle().getText().trim();
    }

    public String getActionsDropDownText() {
        return getActionsDropDown().getText().trim();
    }

    public String getElementsCountDropDownValueSelectedText() {
        return getElementCountDropDownValueSelected().getText().trim();
    }

    public String getElementsCountInTableText() {
        return getElementsCountInTable().getText().trim();
    }

    public String getFirstNameSearchInputText() {
        return getFirstNameSearchInput().getText().trim();
    }

    public String getLastNameSearchInputText() {
        return getLastNameSearchInput().getText().trim();
    }

    public String getLoginSearchInputText() {
        return getLoginSearchInput().getText().trim();
    }

    public String getCommunitySearchInputText() {
        return getCommunitySearchInput().getText().trim();
    }

    public String getEmailSearchInputText() {
        return getEmailSearchInput().getText().trim();
    }

    public String getRoleSearchDropDownValueSelectedText() {
        return getRoleSearchDropDownValueSelected().getText().trim();
    }

    public String getSearchButtonText() {
        return getSearchButton().getText().trim();
    }
    //endregion

    //-----------

    /*public WebElement getSetAsActiveAction() {
        return setAsActiveAction;
    }

    public WebElement getBlockAction() {
        return blockAction;
    }

    public WebElement getSetCommunityAction() {
        return setCommunityAction;
    }

    public WebElement getProfileButton() {
        return profileButton;
    }*/

    //-------------

    //Functional
    public ChangeElementsOnPageFields getSelectedElementsOnPage() {
        ChangeElementsOnPageFields currentElements = ChangeElementsOnPageFields.TEN;
        for (ChangeElementsOnPageFields element : ChangeElementsOnPageFields.values()) {
            if (element.toString().contains(getElementsCountDropDownValueSelectedText())) {
                currentElements = element;
                break;
            }
        }
        return currentElements;
    }


    public void clickActionsDropDown() {
        getActionsDropDown().click();
    }

    public void clickElementsCountDropDown(ChangeElementsOnPageFields elements) {
        getElementsCountDropDown().selectByVisibleText(elements.toString());
    }


    public void clickSearchButton() {
        getSearchButton().click();
    }


     /*
     //TODO add users selection in the method
    public void clickSetAsActiveAction() {
        clickActionsDropDown();
        getSetAsActiveAction().click();
    }


    //TODO add users selection in the method
    public void clickBlockAction() {
        clickActionsDropDown();
        getBlockAction().click();
    }


    //TODO add users selection in the method
    public void clickSetCommunityAction() {
        clickActionsDropDown();
        getSetCommunityAction().click();
    }


    //TODO add users selection in the method
    public void clickProfileButton() {
       getProfileButton().click();
    }*/

    //Business Logic

    public UsersPage changeLanguage(ChangeLanguageFields language) {
        setChangeLanguage(language);
        // Return a new page object representing the destination.
        return new UsersPage(driver);
    }
}
