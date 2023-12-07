package com.dhmi.gov.tr.fids.domain.dto;

import com.dhmi.gov.tr.fids.domain.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {

    private Long id;
    private String email;
    private Set<Role> roles;
}
