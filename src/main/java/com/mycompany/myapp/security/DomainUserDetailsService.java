package com.mycompany.myapp.security;

import static com.mycompany.myapp.database.Tables.*;

import com.mycompany.myapp.database.Tables;
import com.mycompany.myapp.database.tables.records.JhiUserRecord;
import com.mycompany.myapp.domain.Authority;
import com.mycompany.myapp.domain.User;
import com.mycompany.myapp.repository.UserRepository;
import java.util.*;
import java.util.stream.Collectors;
import org.hibernate.validator.internal.constraintvalidators.hv.EmailValidator;
import org.jooq.DSLContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Authenticate a user from the database.
 */
@Component("userDetailsService")
public class DomainUserDetailsService implements UserDetailsService {

    private final DSLContext dsl;
    private final Logger log = LoggerFactory.getLogger(DomainUserDetailsService.class);

    public DomainUserDetailsService(DSLContext dsl) {
        this.dsl = dsl;
    }

    @Override
    public UserDetails loadUserByUsername(final String login) throws UsernameNotFoundException {
        log.debug("Authenticating {}", login);

        //        Record userRecord;
        JhiUserRecord userRecord;
        boolean isEmail = new EmailValidator().isValid(login, null);

        if (isEmail) {
            userRecord = (JhiUserRecord) dsl
                .select()
                .from(JHI_USER)
                //                .leftJoin(JHI_USER_AUTHORITY).on(JHI_USER.ID.eq(JHI_USER_AUTHORITY.USER_ID))
                //                .leftJoin(JHI_AUTHORITY).on(JHI_USER_AUTHORITY.AUTHORITY_NAME.eq(JHI_AUTHORITY.NAME))
                .where(JHI_USER.EMAIL.eq(login.toLowerCase()))
                .fetchOne();
        } else {
            userRecord = (JhiUserRecord) dsl
                .select()
                .from(JHI_USER)
                //                .leftJoin(JHI_USER_AUTHORITY).on(JHI_USER.ID.eq(JHI_USER_AUTHORITY.USER_ID))
                //                .leftJoin(JHI_AUTHORITY).on(JHI_USER_AUTHORITY.AUTHORITY_NAME.eq(JHI_AUTHORITY.NAME))
                .where(JHI_USER.LOGIN.eq(login.toLowerCase()))
                .fetchOne();
        }

        if (userRecord == null) {
            throw new UsernameNotFoundException("User " + login + " not found in the database");
        }

        return createSpringSecurityUser(userRecord);
    }

    private UserDetails createSpringSecurityUser(JhiUserRecord userRecord) {
        String login = userRecord.get(JHI_USER.LOGIN);
        String password = userRecord.get(JHI_USER.PASSWORD_HASH);
        byte activated = userRecord.get(JHI_USER.ACTIVATED);

        if (activated != 1) {
            throw new UserNotActivatedException("User " + login + " was not activated");
        }

        List<SimpleGrantedAuthority> authorities = dsl
            .select(JHI_AUTHORITY.NAME)
            .from(JHI_AUTHORITY)
            .join(JHI_USER_AUTHORITY)
            .on(JHI_USER_AUTHORITY.AUTHORITY_NAME.eq(JHI_AUTHORITY.NAME))
            .where(JHI_USER_AUTHORITY.USER_ID.eq(userRecord.get(JHI_USER.ID)))
            .fetch()
            .stream()
            .map(record -> new SimpleGrantedAuthority(record.get(JHI_AUTHORITY.NAME)))
            .collect(Collectors.toList());

        return new org.springframework.security.core.userdetails.User(login, password, authorities);
    }
}
