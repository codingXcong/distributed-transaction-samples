package io.zgc.account.service;

import java.math.BigDecimal;

public interface AccountService {

    /**减少金额的方法*/
    boolean debit(long id, BigDecimal money);
}
