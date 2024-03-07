package com.thay.springbootbackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "role")
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    @Id
    private int roleID;
    private String roleName;
    private String roleStatus;
    private String roleDescription;
    private String createdDate;
    private String ruleRights;

}
