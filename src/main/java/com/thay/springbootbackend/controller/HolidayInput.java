package com.thay.springbootbackend.controller;

import com.thay.springbootbackend.entity.HolidayEntity;
import lombok.Data;

@Data
public class HolidayInput {
    private String holidayName;
    private String holidayDate;


    public HolidayEntity toHolidayEntity() {
        HolidayEntity holiday = new HolidayEntity();

        holiday.setHolidayName(this.holidayName);
        holiday.setHolidayDate(this.holidayDate);
        return holiday;
    }

}


