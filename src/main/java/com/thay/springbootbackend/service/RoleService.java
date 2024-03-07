package com.thay.springbootbackend.service;

import com.thay.springbootbackend.entity.Role;
import java.util.List;

public interface RoleService {
    Role createRole(Role role);

    Role getRoleByID(int roleID);

    List<Role> getAllRoles();

    Role updateRole(int roleID, String roleName, String roleStatus, String roleDescription, String createdDate, String ruleRights);

    Role deleteRole(int roleID);
}
