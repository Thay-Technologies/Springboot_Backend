package com.thay.springbootbackend.service;

import com.thay.springbootbackend.entity.HolidayEntity;
import com.thay.springbootbackend.repository.HolidayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service

public class HolidayServiceImpl implements HolidayService {
    private final HolidayRepository holidayRepository;

    @Autowired
    public HolidayServiceImpl(HolidayRepository holidayRepository) {
        this.holidayRepository = holidayRepository;
    }

    @Override
    public List<HolidayEntity> getAllHolidays() {
        return holidayRepository.findAll();
    }

    @Override
    public HolidayEntity getHolidayById(int employeeId) {
        return (HolidayEntity) holidayRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("EmployeeId not found"));
    }



    @Override
    public HolidayEntity createHoliday(HolidayEntity holiday) {

        return holidayRepository.save(holiday);
    }

    @Override
    public HolidayEntity updateHoliday(int holidayId, HolidayEntity holiday) {
        HolidayEntity existingHoliday = holidayRepository.findById(holidayId)
                .orElseThrow(() -> new RuntimeException("HolidayId not found"));


        existingHoliday.setHolidayName(holiday.getHolidayName());
        existingHoliday.setHolidayDate(holiday.getHolidayDate());
        return holidayRepository.save(existingHoliday);
    }

    @Override
    public HolidayEntity deleteHoliday(int holidayId) {

        HolidayEntity deletedHoliday= holidayRepository.findById(holidayId)
                .orElseThrow(() -> new RuntimeException("HolidayId not found"));

        holidayRepository.deleteById(holidayId);

        return deletedHoliday;
    }
}



