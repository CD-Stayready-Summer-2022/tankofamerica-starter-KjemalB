package com.codedifferently.tankofamerica.domain.account.controllers;

import com.codedifferently.tankofamerica.domain.user.Exceptions.UserNotFoundException;
import com.codedifferently.tankofamerica.domain.account.Models.Account;
import com.codedifferently.tankofamerica.domain.account.Services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class AccountController {
    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @ShellMethod("Create new account")
    public String createNewAccount(@ShellOption({"-A", "--name"}) String name,
                                   @ShellOption({"-U", "--user-id"}) Long id
                                   )
    {
        try {
            Account account = new Account(name);
            account = accountService.create(id, account);
            return account.toString();
        } catch (UserNotFoundException e) {
            return "This user ID is not valid";
        }
    }
        @ShellMethod("Get owners Accounts")
        public String getAllAccounts (@ShellOption({"-U", "--user"}) Long id){
            try {
                String accounts = accountService.getAllFromUser(id);
                return accounts;
            } catch (UserNotFoundException e) {
                return "The User Id is invalid";
            }
        }
    }

