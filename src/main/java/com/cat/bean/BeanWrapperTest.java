package com.cat.bean;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.PropertyValue;

public class BeanWrapperTest {

    public static void main(String[] args) {
        User user = new User();
        BeanWrapper bean = new BeanWrapperImpl(user);
        bean.setPropertyValue("id", 100);

        PropertyValue propertyValue = new PropertyValue("name", "csl");
        bean.setPropertyValue(propertyValue);

        System.out.println(user);
    }
}
