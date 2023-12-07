package com.dhmi.gov.tr.fids.controller;

import com.dhmi.gov.tr.fids.domain.entity.Role;
import com.dhmi.gov.tr.fids.repository.RoleRepository;
import com.dhmi.gov.tr.fids.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserService userService;

    @GetMapping("/role")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SUPER_ADMIN')")
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @GetMapping("/")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SUPER_ADMIN')")
    public ResponseEntity<?> getAllUsers() {
        return userService.readAllUsers();
    }

    @DeleteMapping("/delete-user/{id}")
    @PreAuthorize("hasAuthority('SUPER_ADMIN')")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long userId) {
        return userService.deleteUser(userId);
    }
}
