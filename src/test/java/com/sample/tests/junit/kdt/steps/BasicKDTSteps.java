package com.sample.tests.junit.kdt.steps;

import com.sample.framework.Driver;
import com.sample.framework.Page;
import com.sample.framework.ui.controls.Control;
import com.sample.framework.ui.controls.Edit;
import com.sample.framework.ui.controls.TableView;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;

import java.util.List;
import java.util.Map;


public class BasicKDTSteps {

    @Given("^the banking application has been started$")
    public void startBankingApplication() throws Throwable{
        Driver.current().get("http://globalsqa.com/angularJs-protractor/BankingProject/#/login");

    }
    @Given("^I am on the \"(.*)\" (?:page|screen)$")
    @When("^(?:I |) go to the \"(.*)\" (?:page|screen)$")
    public void navigateToPage(String name) throws Exception{
        Page target = Page.screen(name);
        Assert.assertNotNull("Unable to find the "+ name +" page", target);
        target.navigate();
        verifyCurrentPage(name);
    }
    @When("^(?:I |)(?:click|tap) on the \"(.*)\" (?:button|element|control)$")
    public void clickOnTheButton(String name) throws Exception{
        Control control = Page.getCurrent().onPage(name);
        Assert.assertNotNull("Unable to find " + name+ " element on current page", control);
        control.click();
    }
    @Then("^I should see the \"(.*)\" (?:page|screen)$")
    public void verifyCurrentPage(String name) throws Exception{
        Page target = Page.screen(name);
        Assert.assertTrue("The "+ name + " screen is not current", target.isCurrent());
        Page.setCurrent(target);
    }
@Then("^(?:I should see |)the \"(.*)\" field is available$")
    public Control verifyElementExists(String fieldName) throws Exception{
        Control control = Page.getCurrent().onPage(fieldName);
        Assert.assertNotNull("Unable to find the' "+ fieldName + "'element on the current page",control);
        Assert.assertTrue("Elemenet '"+ fieldName + "'is not available", control.exists());
    return control;
    }
    @When("^(?:I |)enter \"(.*)\" text into the \"(.*)\" field$")
    public void enterValue(String text, String fieldName) throws Exception{
        Edit control = (Edit) verifyElementExists(fieldName);
        control.setText(text);
    }
    @Then("^(?:I should see |)the \"(.*)\" field contains the \"(.*)\" text$")
    public void verifyFieldText(String fieldName, String text) throws Exception{
        Control control = verifyElementExists(fieldName);

        String actualText = control.getText();
        Assert.assertTrue(
                String.format("The '%s' field has unexpected text. Expected: '%s', Actual: '%s'",
                fieldName,
                text,
                actualText),
                text.equals(actualText) || actualText.contains(text));
    }
    @When("^(?:I |)accept the alert message$")
    public void acceptAlert() throws Exception{
        Driver.current().switchTo().alert().accept();
    }
    @Then("^(?:I should see |)the \"(.*)\" text is shown$")
    public void verifyTextPresent(String text){
        Assert.assertTrue("Unable to find text: '" + text +"'",
                        Page.getCurrent().isTextPresent(text));
    }

    @When("^I scroll to the bottom of the page$")
    public void scrollToBottom() throws Exception{
        JavascriptExecutor js = (JavascriptExecutor) Driver.current();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
    @Then("^(?:I should see |)the following fields are shown:$")
    public void verifyMultipleFieldsAvailability(List<String> elements) throws Exception{
        for (String element:elements){
            verifyElementExists(element);
        }
    }
    @Then("^(?:I should see |)the following labels are shown:$")
    public void verifyMultipleLabelsAvailability(List<String> elements) throws Exception{
        for(String element:elements){
            verifyElementExists(element);
        }

    }
    @When("^(?:I |)populate current page with the following data:$")
    public void populatePageWithData(DataTable data) throws Exception{
        List<Map<String, String>> content = data.asMaps(String.class, String.class);
        for(Map<String,String> row : content){
            enterValue(row.get("Value"),row.get("Field"));
        }

    }
    @Then("^(?:I should see |)the page contains the following data:$")
    public void pageContainsData(DataTable data) throws Exception{
        List<Map<String, String>> content = data.asMaps(String.class, String.class);
        for(Map<String,String> row : content){
            verifyFieldText(row.get("Field"),row.get("Value"));
        }

    }

    @Then("^(?:I should see |)the \"(.*)\" list is (|not) empty $")
    public void verifyListEmptyState(String list, String emptyState)throws Exception{
        boolean empty = emptyState.trim().equals("");
        TableView control = (TableView) verifyElementExists(list);
        if(empty){
            Assert.assertTrue("The '"+ list +"' is not empty", control.isEmpty());
        } else {
            Assert.assertTrue("The '"+ list +"' is empty", control.isNotEmpty());

        }
    }
}
