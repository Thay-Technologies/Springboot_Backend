package com.thay.springbootbackend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@Table(name="holiday")
public class HolidayEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int holidayId;
    private String holidayDate;
    private String holidayName;

}
