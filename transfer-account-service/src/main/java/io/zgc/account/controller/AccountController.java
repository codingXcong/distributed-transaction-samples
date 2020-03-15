package io.zgc.account.controller;

import io.zgc.account.service.AccountService;
import io.zgc.account.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;
    @Autowired
    private TransferService transferService;

    //http://127.0.0.1:2222/debit?id=1001&money=1
    @RequestMapping("/debit")
    public Boolean debit(Long id, BigDecimal money) {
        accountService.debit(id, money);
        return true;
    }

    //http://127.0.0.1:2222/transfer?money=1
    @RequestMapping("/transfer")
    public Boolean transfer(BigDecimal money) {
        return transferService.transfer(money);
    }
}

