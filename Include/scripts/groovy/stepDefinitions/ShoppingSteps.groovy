package stepDefinitions

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import pageObjects.P1_HomeScreen.HomeScreen
import pageObjects.P2_ProductsScreen.ProductsScreen
import pageObjects.P3_ShoppingCartScreen
import pageObjects.P3_ShoppingCartScreen.CartScreen


class ShoppingSteps {
	String productName_1
	String productName_2
	float productPrice_1
	float productPrice_2

	def ShoppingSteps() {
		HomeScreen homeScreen = new HomeScreen()
		ProductsScreen productsScreen = new ProductsScreen()
		CartScreen CartScreen = new CartScreen()
	}
	// Retrieve the project directory
	//String projectDir = RunConfiguration.getProjectDir()
	// Construct the relative path to the APK
	//String apkPath = projectDir + "/androidApp/General-Store.apk"
	String apkPath = "C:/Users/Jack/Katalon Studio/ShoppingApp/androidApp/General-Store.apk"

	@Given("the app is launched")
	def launchApp() {
		println apkPath
		Mobile.startApplication(apkPath, true)
	}

	@When("I select (.*) as the country")
	def selectCountry(String country) {
		HomeScreen.selectCountry(country)
	}

	@When("I enter (.*) as the name")
	def enterName(String name) {
		HomeScreen.enterName(name)
	}

	@When("I select (.*) as the gender")
	def selectGender(String gender) {
		HomeScreen.selectGender(gender)
	}

	@When("I click on Lets Shop")
	def clickLetsShop() {
		HomeScreen.clickLetsShop()
		assert ProductsScreen.getScreenTitle().contains("Products")
	}

	@Then("I add two products to the cart")
	def addProductsToCart() {
		productName_1 = ProductsScreen.getProductNameByIndex(1)
		productName_2 = ProductsScreen.getProductNameByIndex(2)
		productPrice_1=ProductsScreen.getProductPriceByIndex(1)
		productPrice_2=ProductsScreen.getProductPriceByIndex(2)
		ProductsScreen.addProductToCart(1)
		assert ProductsScreen.getAddedToCardCount().contains("1")
		ProductsScreen.addProductToCart(2)
		assert ProductsScreen.getAddedToCardCount().contains("2")
	}

	@Then("I navigate to the cart screen")
	def navigateToCart() {
		println productName_1
		println productName_2
		println productPrice_1
		println productPrice_2
		ProductsScreen.navigateToCart()
	}

	@Then("I verify the products are displayed")
	def verifyProducts() {
		assert ProductsScreen.getProductNameByIndex(1).contains(productName_1)
		assert ProductsScreen.getProductNameByIndex(2).contains(productName_2)
		assert ProductsScreen.getProductPriceByIndex(1).equals(productPrice_1)
		assert ProductsScreen.getProductPriceByIndex(2).equals(productPrice_2)
	}

	@Then("I verify the total equals the sum of the product prices")
	def verifyTotal() {
		CartScreen.verifyTotalAmount()
	}
}