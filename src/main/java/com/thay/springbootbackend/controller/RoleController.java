package com.thay.springbootbackend.controller;

import com.thay.springbootbackend.entity.Role;
import com.thay.springbootbackend.service.RoleService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import java.util.List;



@Controller
public class RoleController {


    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @QueryMapping("getAllRoles")
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    @QueryMapping("getRoleByID")
    public Role getRoleByID(@Argument("roleID") int roleID) {
        return roleService.getRoleByID(roleID);
    }

    @MutationMapping("createRole")
    public Role createRole(
            @Argument("roleID") int roleID,
            @Argument("roleName") String roleName,
            @Argument("roleStatus") String roleStatus,
            @Argument("roleDescription") String roleDescription,
            @Argument("createdDate") String createdDate,
            @Argument("ruleRights") String ruleRights
    ) {
        Role role = new Role(roleID, roleName, roleStatus, roleDescription, createdDate, ruleRights);
        return roleService.createRole(role);
    }

    @MutationMapping("updateRole")
    public Role updateRole(@Argument("roleID") int roleID,
                           @Argument("roleName") String roleName,
                           @Argument("roleStatus") String roleStatus,
                           @Argument("roleDescription") String roleDescription,
                           @Argument("createdDate") String createdDate,
                           @Argument("ruleRights") String ruleRights) {
        return roleService.updateRole(roleID, roleName, roleStatus, roleDescription, createdDate, ruleRights);
    }

    @MutationMapping("deleteRole")
    public Role deleteRole(@Argument("roleID") int roleID) {
        return roleService.deleteRole(roleID);
    }

}