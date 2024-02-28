package com.thay.springbootbackend.repository;

import com.thay.springbootbackend.entity.HolidayEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HolidayRepository extends JpaRepository<HolidayEntity,Integer> {

}

