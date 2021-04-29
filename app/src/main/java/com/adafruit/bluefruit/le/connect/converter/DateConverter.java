package com.adafruit.bluefruit.le.connect.converter;

import java.util.Date;

import com.adafruit.bluefruit.le.connect.utils.DateUtils;
import io.objectbox.converter.PropertyConverter;

public class DateConverter implements PropertyConverter<Date, String> {

    @Override
    public Date convertToEntityProperty(String databaseValue) {
        Date date = new Date();
        try {
            return DateUtils.getInstance().setDateString(databaseValue).dateStrToDate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    @Override
    public String convertToDatabaseValue(Date entityProperty) {
        return entityProperty.toString();
    }
}