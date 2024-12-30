package pageObjects

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

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

public class P3_ShoppingCartScreen {

	class CartScreen {

		
		static float getProductPriceByIndex(int index) {
			TestObject product = findTestObject('Object Repository/ProductsScreen/ProductPrice', [('index') : index])
			String priceText =  Mobile.getText(product, 10)
			String numericPart = priceText.replace('$', '')
			// Convert the numeric part to a float
			float price = Float.parseFloat(numericPart)
			return price
		}
		
		static float getTotalPrice() {
			TestObject totalPrice = findTestObject('Object Repository/CartScreen/TotalPrice')
			String totalPriceText =  Mobile.getText(totalPrice, 10)
			String numericPart = totalPriceText.replace('$ ', '')
			// Convert the numeric part to a float
			float price = Float.parseFloat(numericPart)
			return price
		}
		
		
		static void verifyTotalAmount() {
			TestObject totalPrice = findTestObject('Object Repository/CartScreen/TotalPrice')
			float price1 = getProductPriceByIndex(1)
			float price2 = getProductPriceByIndex(2)
			float total = getTotalPrice()
			assert total == (price1 + price2)
		}
	}
}
