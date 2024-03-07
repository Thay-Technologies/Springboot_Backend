package com.thay.springbootbackend.service.impl;

import com.thay.springbootbackend.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.thay.springbootbackend.entity.Role;
import com.thay.springbootbackend.service.RoleService;
import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role getRoleByID(int roleID) {
        return (Role) roleRepository.findById(roleID)
                .orElseThrow(() -> new RuntimeException("Role not found"));
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role updateRole(int roleID, String roleName, String roleStatus, String roleDescription, String createdDate, String ruleRights) {
        Optional<Role> optionalRole = roleRepository.findById(roleID);

        if (optionalRole.isPresent()) {
            Role existingRole = optionalRole.get();
            existingRole.setRoleName(roleName);
            existingRole.setRoleStatus(roleStatus);
            existingRole.setRoleDescription(roleDescription);
            existingRole.setCreatedDate(createdDate);
            existingRole.setRuleRights(ruleRights);
            return roleRepository.save(existingRole);
        } else {
            throw new RuntimeException("Role with ID " + roleID + " not found");
        }
    }

    @Override
    public Role deleteRole(int roleID) {
        Role deleteRole = roleRepository.findById(roleID)
                .orElseThrow(() -> new RuntimeException("Role with ID " + roleID + " not found"));

        roleRepository.deleteById(roleID);
        return deleteRole;
    }
}
