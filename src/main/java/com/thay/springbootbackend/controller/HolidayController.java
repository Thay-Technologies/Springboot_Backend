package com.thay.springbootbackend.controller;

import com.thay.springbootbackend.controller.input.HolidayInput;
import com.thay.springbootbackend.entity.HolidayEntity;
import com.thay.springbootbackend.service.HolidayService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;


@Controller
public class HolidayController {
    private final HolidayService holidayService;

    public HolidayController(HolidayService holidayService) {
        this.holidayService = holidayService;
    }

    @QueryMapping("getAllHolidays")
    public List<HolidayEntity> getAllHolidays() {
        return holidayService.getAllHolidays();
    }

    @MutationMapping("createHoliday")
    public HolidayEntity createHoliday(@Argument("input") HolidayInput holidayInput) {
        return holidayService.createHoliday(holidayInput.toHolidayEntity());
    }

    @MutationMapping("updateHoliday")
    public HolidayEntity updateHoliday(@Argument("holidayId") int holidayId, @Argument("input") HolidayInput holidayInput) {
        return holidayService.updateHoliday(holidayId, holidayInput.toHolidayEntity());
    }

    @MutationMapping("deleteHoliday")
    public HolidayEntity deleteHoliday(@Argument("holidayId") int holidayId) {
        return holidayService.deleteHoliday(holidayId);
    }

    @QueryMapping("getHolidayById")
    public HolidayEntity getHolidayById(@Argument("holidayId") int holidayId) {
        return holidayService.getHolidayById(holidayId);
    }
}



