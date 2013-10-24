package com.sap.ui5.modules.librarytests.commons.tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.sap.ui5.modules.librarytests.commons.pages.TriStateCheckBoxPO;
import com.sap.ui5.selenium.common.TestBase;

public class TriStateCheckBoxTest extends TestBase {

	private TriStateCheckBoxPO page;

	private String targetUrl = "/uilib-sample/test-resources/sap/ui/commons/visual/TriStateCheckBox.html";

	@Before
	public void setUp() {
		page = PageFactory.initElements(driver, TriStateCheckBoxPO.class);
		driver.get(getFullUrl(targetUrl));
		userAction.mouseClickStartPoint(driver);
	}

	@Test
	public void testAllElements() {
		verifyFullPageUI("full-initial");
	}

	@Test
	public void testClickAction() {
		// Avoid generating no dashed on FIREFOX
		new Actions(driver).sendKeys(Keys.TAB).perform();

		page.clickElement(driver, userAction, page.checkBoxPcb1Id);
		verifyElementUI(page.uiAreaId, "Selected-All-first");

		page.clickElement(driver, userAction, page.checkBoxCcb1Id);
		verifyElementUI(page.uiAreaId, "Deselected-Partly");

		page.clickElement(driver, userAction, page.checkBoxPcb1Id);
		verifyElementUI(page.uiAreaId, "Selected-All-second");

		page.clickElement(driver, userAction, page.checkBoxPcb1Id);
		verifyElementUI(page.uiAreaId, "Deselected-All");

		page.clickElement(driver, userAction, page.checkBoxCcb2Id);
		verifyElementUI(page.uiAreaId, "Selected-Partly");

		page.clickElement(driver, userAction, page.checkBoxCcb1Id);
		verifyElementUI(page.uiAreaId, "Selected-All-CheckBox");

	}

}
