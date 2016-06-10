package com.softserve.edu.rs.pages;

import com.softserve.edu.data.IUser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;

public class RegisteredUsersHomePage extends AdminHomePage {

	public static enum RegisteredUsersHomePageL10n {
		FIRST_NAME("Ім'я *","Имя *","First name *"),
		SECOND_NAME("Прізвище*","Фамилия*","Second name*"),
		MIDDLE_NAME("По-батькові","Отчество","Middle name"),
		EMAIL("Електронна пошта *","Электронная почта *","E-mail *"),
		LOGIN("Логін *","Логин *","Login *"),
		PASSWORD("Пароль *","Пароль *","Password *"),
        CONFIRM_PASSWORD("Підтвердження паролю *","Подтверждение пароля *","Confirm password *"),
		CITY("Місто","Город","City"),
		REGION("Область","Область","Region"),
		DISTRICT("Район","Район","District"),
		STREET("Вулиця","Улица","Street"),
		BUILDING("Будинок","Дом","Building"),
		FLAT("Квартира","Квартира","Flat"),
		POSTCODE("Поштовий індекс","Почтовый индекс","Postcode"),
		SERIA("Серія","Серия","Seria"),
		NUMBER("Номер","Номер","Number"),
		PUBLISHED_BY("Виданий","Выданный","Published by"),
		PHONE_NUMBER("Номер телефону","Номер телефона","Phone number"),
		COMMUNITY("Громада *","Община *","Community *"),
		ACCESSION_DATE("Дата приєднання до договору*","Дата присоединения к договору*","Date of accession to the treaty*"),
		SEND_BUTTON("Надіслати","Отправить","Send"),
		CLEAR_FORM_BUTTON("Очистити форму","Очистить форму","Clear form"),
		CANCEL_BUTTON("Відмінити","Отменить","Cancel");

		//
		private HashMap<ChangeLanguageFields, String> field;

		private RegisteredUsersHomePageL10n(String... localization) {
			this.field = new HashMap<ChangeLanguageFields, String>();
			int i = 0;
			for (ChangeLanguageFields language : ChangeLanguageFields.values()) {
				this.field.put(language, localization[i]);
				i++;
			}
		}

		public String getLocalization(ChangeLanguageFields language) {
			return this.field.get(language).trim();
		}
	}
	// Fields

	//region Basic Info
	private WebElement firstNameLabel;
	private WebElement secondNameLabel;
	private WebElement middleNameLabel;
	private WebElement emailLabel;
	private WebElement loginLabel;
	private WebElement passwordLabel;
	private WebElement confirmPasswordLabel;

	private WebElement firstNameInput;
	private WebElement secondNameInput;
	private WebElement middleNameInput;
	private WebElement emailInput;
	private WebElement loginInput;
	private WebElement passwordInput;
	private WebElement confirmPasswordInput;
	//endregion

	//region Address Info
	private WebElement cityLabel;
	private WebElement regionLabel;
	private WebElement districtLabel;
	private WebElement streetLabel;
	private WebElement buildingLabel;
	private WebElement flatLabel;
	private WebElement postcodeLabel;

	private WebElement cityInput;
	private WebElement regionInput;
	private WebElement districtInput;
	private WebElement streetInput;
	private WebElement buildingInput;
	private WebElement flatInput;
	private WebElement postcodeInput;
	//endregion

	//region Passport Info
	private WebElement seriaLabel;
	private WebElement numberLabel;
	private WebElement publishedByLabel;

	private WebElement seriaInput;
	private WebElement numberInput;
	private WebElement publishedByInput;
	//endregion

	//region Other data
	private WebElement phoneNumberLabel;
	private WebElement communityLabel;
	private WebElement accessionDateLabel;

	private WebElement phoneNumberInput;
	private Select communitySelect;
	private WebElement accessionDateInput;
	//endregion

	//region Buttons
	private WebElement sendButton;
	private WebElement clearFormButton;
	private WebElement cancelButton;
	//endregion

	public RegisteredUsersHomePage(WebDriver driver) {
		super(driver);
		this.firstNameLabel = driver.findElement(By.xpath("//label[@for='firstName']"));
		this.secondNameLabel = driver.findElement(By.xpath("//label[@for='lastName']"));
		this.middleNameLabel = driver.findElement(By.xpath("//label[@for='middleName']"));
		this.emailLabel = driver.findElement(By.xpath("//label[@for='email']"));
		this.loginLabel = driver.findElement(By.xpath("//label[@for='login']"));
		this.passwordLabel = driver.findElement(By.xpath("//label[@for='password']"));
		this.confirmPasswordLabel = driver.findElement(By.xpath("//label[@for='confirmPassword']"));
		this.firstNameInput = driver.findElement(By.id("firstName"));
		this.secondNameInput = driver.findElement(By.id("lastName"));
		this.middleNameInput = driver.findElement(By.id("middleName"));
		this.emailInput = driver.findElement(By.id("email"));
		this.loginInput = driver.findElement(By.id("login"));
		this.passwordInput = driver.findElement(By.id("password"));
		this.confirmPasswordInput = driver.findElement(By.id("confirmPassword"));
		/*this.cityLabel = driver.findElement(By.id(""));
		this.regionLabel = driver.findElement(By.id(""));
		this.districtLabel = driver.findElement(By.id(""));
		this.streetLabel = driver.findElement(By.id(""));
		this.buildingLabel = driver.findElement(By.id(""));
		this.flatLabel = driver.findElement(By.id(""));
		this.postcodeLabel = driver.findElement(By.id(""));
		this.cityInput = driver.findElement(By.id(""));
		this.regionInput = driver.findElement(By.id(""));
		this.districtInput = driver.findElement(By.id(""));
		this.streetInput = driver.findElement(By.id(""));
		this.buildingInput = driver.findElement(By.id(""));
		this.flatInput = driver.findElement(By.id(""));
		this.postcodeInput = driver.findElement(By.id(""));
		this.seriaLabel = driver.findElement(By.id(""));
		this.numberLabel = driver.findElement(By.id(""));
		this.publishedByLabel = driver.findElement(By.id(""));
		this.seriaInput = driver.findElement(By.id(""));
		this.numberInput = driver.findElement(By.id(""));
		this.publishedByInput = driver.findElement(By.id(""));
		this.phoneNumberLabel = driver.findElement(By.id(""));*/
		this.communityLabel = driver.findElement(By.xpath("//label[@for='territorial_Community']"));
		//this.accessionDateLabel = driver.findElement(By.id(""));
		//this.phoneNumberInput = driver.findElement(By.id(""));
		this.communitySelect = new Select(driver.findElement(By.id("territorial_Community")));
		//this.accessionDateInput = driver.findElement(By.id(""));
		this.sendButton = driver.findElement(By.id("submit"));
	//	this.clearFormButton = driver.findElement(By.id(""));
		//this.cancelButton = driver.findElement(By.id(""));
	}


	/*public RegisteredUsersHomePage(WebDriver driver) {
		super(driver);
		this.name = driver.findElement(By.id("firstName"));
	}*/
	
    // PageObject

	//region get Data

    public WebElement getFirstNameLabel() {
        return firstNameLabel;
    }

    public WebElement getSecondNameLabel() {
        return secondNameLabel;
    }

    public WebElement getMiddleNameLabel() {
        return middleNameLabel;
    }

    public WebElement getEmailLabel() {
        return emailLabel;
    }

    public WebElement getLoginLabel() {
        return loginLabel;
    }

    public WebElement getPasswordLabel() {
        return passwordLabel;
    }

    public WebElement getConfirmPasswordLabel() {
        return confirmPasswordLabel;
    }

    public WebElement getFirstNameInput() {
        return firstNameInput;
    }

    public WebElement getSecondNameInput() {
        return secondNameInput;
    }

    public WebElement getMiddleNameInput() {
        return middleNameInput;
    }

    public WebElement getEmailInput() {
        return emailInput;
    }

    public WebElement getLoginInput() {
        return loginInput;
    }

    public WebElement getPasswordInput() {
        return passwordInput;
    }

    public WebElement getConfirmPasswordInput() {
        return confirmPasswordInput;
    }

    public WebElement getCityLabel() {
        return cityLabel;
    }

    public WebElement getRegionLabel() {
        return regionLabel;
    }

    public WebElement getDistrictLabel() {
        return districtLabel;
    }

    public WebElement getStreetLabel() {
        return streetLabel;
    }

    public WebElement getBuildingLabel() {
        return buildingLabel;
    }

    public WebElement getFlatLabel() {
        return flatLabel;
    }

    public WebElement getPostcodeLabel() {
        return postcodeLabel;
    }

    public WebElement getCityInput() {
        return cityInput;
    }

    public WebElement getRegionInput() {
        return regionInput;
    }

    public WebElement getDistrictInput() {
        return districtInput;
    }

    public WebElement getStreetInput() {
        return streetInput;
    }

    public WebElement getBuildingInput() {
        return buildingInput;
    }

    public WebElement getFlatInput() {
        return flatInput;
    }

    public WebElement getPostcodeInput() {
        return postcodeInput;
    }

    public WebElement getSeriaLabel() {
        return seriaLabel;
    }

    public WebElement getNumberLabel() {
        return numberLabel;
    }

    public WebElement getPublishedByLabel() {
        return publishedByLabel;
    }

    public WebElement getSeriaInput() {
        return seriaInput;
    }

    public WebElement getNumberInput() {
        return numberInput;
    }

    public WebElement getPublishedByInput() {
        return publishedByInput;
    }

    public WebElement getPhoneNumberLabel() {
        return phoneNumberLabel;
    }

    public WebElement getCommunityLabel() {
        return communityLabel;
    }

    public WebElement getAccessionDateLabel() {
        return accessionDateLabel;
    }

    public WebElement getPhoneNumberInput() {
        return phoneNumberInput;
    }

    public Select getCommunitySelect() {
        return communitySelect;
    }

    public WebElement getCommunitySelected(){
        return getCommunitySelect().getFirstSelectedOption();
    }

    public WebElement getAccessionDateInput() {
        return accessionDateInput;
    }

    public WebElement getSendButton() {
        return sendButton;
    }

    public WebElement getClearFormButton() {
        return clearFormButton;
    }

    public WebElement getCancelButton() {
        return cancelButton;
    }
    //endregion

    // Functional

    //region get Text
    public String getFirstNameLabelText() {
        return getFirstNameLabel().getText().trim();
    }

    public String getSecondNameLabelText() {
        return getSecondNameLabel().getText().trim();
    }

    public String getMiddleNameLabelText() {
        return getMiddleNameLabel().getText().trim();
    }

    public String getEmailLabelText() {
        return getEmailLabel().getText().trim();
    }

    public String getLoginLabelText() {
        return getLoginLabel().getText().trim();
    }

    public String getPasswordLabelText() {
        return getPasswordLabel().getText().trim();
    }

    public String getConfirmPasswordLabelText() {
        return getConfirmPasswordLabel().getText().trim();
    }

    public String getFirstNameInputText() {
        return getFirstNameInput().getText().trim();
    }

    public String getSecondNameInputText() {
        return getSecondNameInput().getText().trim();
    }

    public String getMiddleNameInputText() {
        return getMiddleNameInput().getText().trim();
    }

    public String getEmailInputText() {
        return getEmailInput().getText().trim();
    }

    public String getLoginInputText() {
        return getLoginInput().getText().trim();
    }

    public String getPasswordInputText() {
        return getPasswordInput().getText().trim();
    }

    public String getConfirmPasswordInputText() {
        return getConfirmPasswordInput().getText().trim();
    }

    public String getCityLabelText() {
        return getCityLabel().getText().trim();
    }

    public String getRegionLabelText() {
        return getRegionLabel().getText().trim();
    }

    public String getDistrictLabelText() {
        return getDistrictLabel().getText().trim();
    }

    public String getStreetLabelText() {
        return getStreetLabel().getText().trim();
    }

    public String getBuildingLabelText() {
        return getBuildingLabel().getText().trim();
    }

    public String getFlatLabelText() {
        return getFlatLabel().getText().trim();
    }

    public String getPostcodeLabelText() {
        return getPostcodeLabel().getText().trim();
    }

    public String getCityInputText() {
        return getCityInput().getText().trim();
    }

    public String getRegionInputText() {
        return getRegionInput().getText().trim();
    }

    public String getDistrictInputText() {
        return getDistrictInput().getText().trim();
    }

    public String getStreetInputText() {
        return getStreetInput().getText().trim();
    }

    public String getBuildingInputText() {
        return getBuildingInput().getText().trim();
    }

    public String getFlatInputText() {
        return getFlatInput().getText().trim();
    }

    public String getPostcodeInputText() {
        return getPostcodeInput().getText().trim();
    }

    public String getSeriaLabelText() {
        return getSeriaLabel().getText().trim();
    }

    public String getNumberLabelText() {
        return getNumberLabel().getText().trim();
    }

    public String getPublishedByLabelText() {
        return getPublishedByLabel().getText().trim();
    }

    public String getSeriaInputText() {
        return getSeriaInput().getText().trim();
    }

    public String getNumberInputText() {
        return getNumberInput().getText().trim();
    }

    public String getPublishedByInputText() {
        return getPublishedByInput().getText().trim();
    }

    public String getPhoneNumberLabelText() {
        return getPhoneNumberLabel().getText().trim();
    }

    public String getCommunityLabelText() {
        return getCommunityLabel().getText().trim();
    }

    public String getAccessionDateLabelText() {
        return getAccessionDateLabel().getText().trim();
    }

    public String getPhoneNumberInputText() {
        return getPhoneNumberInput().getText().trim();
    }

    public String getCommunitySelectedText() {
        return getCommunitySelected().getText().trim();
    }

    public String getAccessionDateInputText() {
        return getAccessionDateInput().getText().trim();
    }

    public String getSendButtonText() {
        return getSendButton().getText().trim();
    }

    public String getClearFormButtonText() {
        return getClearFormButton().getText().trim();
    }

    public String getCancelButtonText() {
        return getCancelButton().getText().trim();
    }

    //endregion
	
	// set Data

    //First Name
	public void clickFirstName() {
		getFirstNameInput().click();
	}

	public void clearFirstName() {
        getFirstNameInput().clear();
	}

	public void setFirstName(String firstName) {
        getFirstNameInput().sendKeys(firstName);
	}

	public void setFirstNameClearInput(String firstName) {
        clickFirstName();
        clearFirstName();
        setFirstName(firstName);
	}

    //Last Name
    public void clickSecondName() {
        getSecondNameInput().click();
    }

    public void clearSecondName() {
        getSecondNameInput().clear();
    }

    public void setSecondName(String secondName) {
        getSecondNameInput().sendKeys(secondName);
    }

    public void setSecondNameClearInput(String firstName) {
        clickSecondName();
        clearSecondName();
        setSecondName(firstName);
    }

    //Email
    public void clickEmail() {
        getEmailInput().click();
    }

    public void clearEmail() {
        getEmailInput().clear();
    }

    public void setEmail(String email) {
        getEmailInput().sendKeys(email);
    }

    public void setEmailClearInput(String email) {
        clickEmail();
        clearEmail();
        setEmail(email);
    }

    //Login
    public void clickLogin() {
        getLoginInput().click();
    }

    public void clearLogin() {
        getLoginInput().clear();
    }

    public void setLogin(String login) {
        getLoginInput().sendKeys(login);
    }

    public void setLoginClearInput(String login) {
        clickLogin();
        clearLogin();
        setLogin(login);
    }

    //Password
    public void clickPassword() {
        getPasswordInput().click();
    }

    public void clearPassword() {
        getPasswordInput().clear();
    }

    public void setPassword(String password) {
        getPasswordInput().sendKeys(password);
    }

    public void setPasswordClearInput(String password) {
        clickPassword();
        clearPassword();
        setPassword(password);
    }

    //Confirm Password
    public void clickConfirmPassword() {
        getConfirmPasswordInput().click();
    }

    public void clearConfirmPassword() {
        getConfirmPasswordInput().clear();
    }

    public void setConfirmPassword(String confirmPassword) {
        getConfirmPasswordInput().sendKeys(confirmPassword);
    }

    public void setConfirmPasswordClearInput(String confirmPassword) {
        clickConfirmPassword();
        clearConfirmPassword();
        setConfirmPassword(confirmPassword);
    }

    //Community
    public void clickCommunity() {
        getCommunitySelected().click();
    }

    public void clearCommunity() {
        getCommunitySelect().deselectAll();
    }

    public void setCommunity() {
        getCommunitySelect().selectByValue("Україна");
    }

    public void setCommunityClearInput() {
        clickCommunity();
        clearCommunity();
        setCommunity();
    }

    public void clickSendButton(){
        getSendButton().click();
    }




    // Business Logic

    public RegisteredUsersHomePage changeLanguage(ChangeLanguageFields language) {
        setChangeLanguage(language);
        // Return a new page object representing the destination.
        return new RegisteredUsersHomePage(driver);
    }

    public UsersPage registerNewUser(IUser user){
        setFirstNameClearInput(user.getFirstname());
        setSecondNameClearInput(user.getLastname());
        setEmailClearInput(user.getEmail());
        setLoginClearInput(user.getLogin());
        setPasswordClearInput(user.getPassword());
        setConfirmPasswordClearInput(user.getPassword());
        setCommunityClearInput();

        clickSendButton();

        return new UsersPage(driver);
    }
}
