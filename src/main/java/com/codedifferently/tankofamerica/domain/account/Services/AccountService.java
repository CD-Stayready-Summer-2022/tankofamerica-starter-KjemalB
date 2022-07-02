package com.codedifferently.tankofamerica.domain.account.Services;

import com.codedifferently.tankofamerica.domain.user.Exceptions.UserNotFoundException;
import com.codedifferently.tankofamerica.domain.account.Models.Account;

public interface AccountService {
    Account create(Long userId, Account account) throws UserNotFoundException;

    String getAllFromUser(Long userId) throws UserNotFoundException;

    Boolean delete(String id);

    String getById(String id);

    Account update(Account account);
}
