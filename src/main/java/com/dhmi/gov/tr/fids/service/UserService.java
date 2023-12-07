package com.dhmi.gov.tr.fids.service;

import com.dhmi.gov.tr.fids.domain.dto.RegisterRequestDto;
import com.dhmi.gov.tr.fids.domain.entity.User;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity<?> create(RegisterRequestDto registerRequestDto);
    ResponseEntity<?> deleteUser(Long id);
    ResponseEntity<?> readAllUsers();
    String readAuthenticatedUserName();
}
