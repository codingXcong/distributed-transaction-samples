package io.zgc.account.service.impl;

import io.zgc.account.manager.AccountServiceOtherClient;
import io.zgc.account.service.AccountService;
import io.zgc.account.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
@Service
public class TransferServiceImpl implements TransferService {

    @Autowired
    private AccountService accountService;
    @Autowired
    private AccountServiceOtherClient accountServiceOtherClient;

    @Transactional
    public boolean transfer(BigDecimal money) {
        //张三扣减金额》
        accountService.debit(1001, money);

        //李四增加金额>
        accountServiceOtherClient.increse(1002, money);

        //为了测试异常，当money，传入为10
        if(money.compareTo(new BigDecimal(10)) == 0) {
            //人为抛出异常
            int i = 1/0;
            System.out.println("i="+i);
        }

        return true;
    }
}
