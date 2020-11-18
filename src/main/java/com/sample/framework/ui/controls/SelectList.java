package com.sample.framework.ui.controls;

import com.sample.framework.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectList extends Control {
    public SelectList(Page parentValue, By locator){
        super(parentValue, locator);
    }

    public Select getSelect(){
        return  new Select(this.getElement());
    }
    public void selectByText(String value){
        this.exists();
        this.getSelect().selectByVisibleText(value);

    }

}
