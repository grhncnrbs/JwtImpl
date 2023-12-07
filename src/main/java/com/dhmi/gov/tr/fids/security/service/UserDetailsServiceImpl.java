package com.dhmi.gov.tr.fids.security.service;

import com.dhmi.gov.tr.fids.domain.entity.User;
import com.dhmi.gov.tr.fids.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(email + " adresi için kullanıcı bulunamadı."));
        return UserDetailsImpl.build(user);
    }
}
