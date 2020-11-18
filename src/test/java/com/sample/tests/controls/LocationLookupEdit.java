package com.sample.tests.controls;

import com.sample.framework.Page;
import com.sample.framework.ui.controls.Control;
import com.sample.framework.ui.controls.Edit;
import org.openqa.selenium.By;

public class LocationLookupEdit extends Edit {
    public LocationLookupEdit(Page parentValue, By locatorValue){
        super(parentValue, locatorValue);
    }
    @Override
    public void setText(String value) throws Exception{
        this.click();
        this.getElement().clear();
        this.getElement().sendKeys(value);
        Control lookUpItem = new Control(this.getParent(),By.cssSelector("li[class='c-autocomplete__item sb-autocomplete__item sb-autocomplete__item-with_photo sb-autocomplete__item__item--elipsis sb-autocomplete__item--icon_revamp sb-autocomplete__item--city ']"));
        //lookUpItem.click();
    }
}
