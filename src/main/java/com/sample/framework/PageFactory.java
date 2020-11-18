package com.sample.framework;

import com.sample.framework.ui.controls.Control;
import org.apache.commons.lang3.ArrayUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class PageFactory {
    private static By toLocator(String input){
        if (input.matches("^(xpath=|/)(.*)"))
            return By.xpath(input.replaceAll("^xpath=",""));
        else if (input.matches("^id=(.*)"))
            return By.id(input.substring("id=".length()));
        else if (input.matches("^name=(.*)"))
            return By.name(input.substring("name=".length()));
        else if (input.matches("^css=(.*)"))
            return By.cssSelector(input.substring("css=".length()));
        else if (input.matches("^class=(.*)"))
            return By.className(input.substring("class=".length()));
        else
            return By.id(input);
    }



    @SuppressWarnings("unchecked")
    private static <T> T getAnnotationField(Annotation annotation, String name, Class<T> type)
        throws Exception{
        T result;
        result = (T) annotation.getClass().getMethod(name).invoke(annotation);
        return  result;

    }
    public static SubItem[] getSubItemsForWeb(SubItem[] items){
        SubItem[] result = new SubItem[]{};
        for(SubItem item : items){
            result = ArrayUtils.add(result, item);
        }
        return result;
    }
    public static <T extends Page> T init(Class<T> pageClass) throws Exception{
        T page = pageClass.getConstructor(WebDriver.class).newInstance(Driver.current());
        for (Field field : pageClass.getFields()){
            FindBy anno = (FindBy) field.getAnnotation(FindBy.class);
            if(anno != null){
                Control control = (Control) field.getType().getConstructor(Page.class,By.class)
                        .newInstance(page, toLocator(getAnnotationField(anno, "locator", String.class)));
                control.setItemLocator(anno.itemLocator());
                SubItem[] items = field.getAnnotationsByType(SubItem.class);
                control.addSubItems(getSubItemsForWeb(items));
                control.setExcludeFromSearch(anno.excludeFromSearch());
                field.set(page, control);
            }
        }
        return page;
    }
}
