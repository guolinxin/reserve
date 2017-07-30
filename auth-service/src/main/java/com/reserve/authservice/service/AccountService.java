package com.reserve.authservice.service;

import com.reserve.authservice.dao.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by linxing on 29/07/2017.
 */
@Service
public class AccountService implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return accountRepository.findByUsername(username)
                .map(account -> new User(account.getUsername(), account.getPassword(),
                        account.isActive(),
                        account.isActive(),
                        account.isActive(),
                        account.isActive(),
                        AuthorityUtils.createAuthorityList("ROLE_ADMIN", "ROLE_USER")))
                .orElseThrow(() -> new UsernameNotFoundException("oops! couldn't find " + username));
    }
}
