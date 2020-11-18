package com.sample.framework.ui.controls;

import com.sample.framework.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Edit extends Control {

    public Edit(Page parentValue, By locator){
        super(parentValue, locator);
    }

    public void setText(String value) throws Exception{
            this.click();
            this.getElement().clear();
            this.getElement().sendKeys(value);
    }
    @Override
    public String getText(){
        return  this.getElement().getAttribute("value");
    }
}
