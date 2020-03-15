package io.zgc.account.controller;

import io.zgc.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    //http://127.0.0.1:2223/increse?id=1001&money=1
    @RequestMapping("/increse")
    public Boolean debit(Long id, BigDecimal money) {
        return accountService.increse(id, money);
    }
}

