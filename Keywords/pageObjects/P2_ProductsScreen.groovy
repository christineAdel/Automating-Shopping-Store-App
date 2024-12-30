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

public class P2_ProductsScreen {
	class ProductsScreen {
		static TestObject title = ObjectRepository.findTestObject('Object Repository/ProductsScreen/Title')

		static String getScreenTitle() {
			return Mobile.getText(title, 10)
		}

		static String getProductNameByIndex(int index) {
			TestObject product = findTestObject('Object Repository/ProductsScreen/ProductsName', [('index') : index])
			return Mobile.getText(product, 10)
		}

		static float getProductPriceByIndex(int index) {
			TestObject product = findTestObject('Object Repository/ProductsScreen/ProductPrice', [('index') : index])
			String priceText =  Mobile.getText(product, 10)
			String numericPart = priceText.replace('$', '')
			// Convert the numeric part to a float
			float price = Float.parseFloat(numericPart)
			return price
		}

		static void addProductToCart(int productIndex) {
			TestObject addToCart = findTestObject('Object Repository/ProductsScreen/AddToCartBtn', [('index') : productIndex])
			Mobile.tap(addToCart, 10)
			assert Mobile.getText(addToCart, 10).contains("ADDED TO CART")
		}

		static void navigateToCart() {
			TestObject shoppingCartBtn = findTestObject('Object Repository/ProductsScreen/ShoppingCartBtn')
			Mobile.tap(shoppingCartBtn, 10)
		}
		
		static String getAddedToCardCount() {
			TestObject counter = findTestObject('Object Repository/ProductsScreen/Counter')
			String counterText =  Mobile.getText(counter, 10)
			return counterText
		}
		
		static String getNumberOfProduct() {
			TestObject products = findTestObject('Object Repository/ProductsScreen/AllProducts')
			List elements = WebUI.findWebElements(products, 30)
			String elementCount = elements.size()
			println("Number of product elements found: " + elementCount)
			return  elementCount
		}
	}	
}
