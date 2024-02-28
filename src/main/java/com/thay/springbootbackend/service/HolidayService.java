package com.thay.springbootbackend.service;

import com.thay.springbootbackend.entity.HolidayEntity;

import java.util.List;


public interface HolidayService {
    List<HolidayEntity> getAllHolidays();


    HolidayEntity getHolidayById(int employeeId);

    HolidayEntity createHoliday(HolidayEntity holiday);
    HolidayEntity updateHoliday(int holidayId, HolidayEntity holiday);


    HolidayEntity deleteHoliday(int holidayId);
}



