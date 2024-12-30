package pageObjects

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class P1_HomeScreen {

	class HomeScreen {
		static TestObject countryDropdown = ObjectRepository.findTestObject('Object Repository/HomeScreen/CountryDropdown')
		static TestObject nameField = ObjectRepository.findTestObject('Object Repository/HomeScreen/NameField')
		static TestObject FemaleRadioButton = ObjectRepository.findTestObject('Object Repository/HomeScreen/FemaleRadioButton')
		static TestObject letsShopButton = ObjectRepository.findTestObject('Object Repository/HomeScreen/LetsShopButton')

		static void selectCountry(String country) {
			Mobile.tap(countryDropdown, 15)
			Mobile.scrollToText(country)
			Mobile.tap(findTestObject('Object Repository/HomeScreen/SelectCountry', [('country') : country]), 30)
		}

		static void enterName(String name) {
			Mobile.setText(nameField, name, 10)
			Mobile.hideKeyboard()
		}

		static void selectGender(String gender) {
			Mobile.tap(FemaleRadioButton, 10)
		}

		static void clickLetsShop() {
			Mobile.tap(letsShopButton, 10)
		}
	}
}
