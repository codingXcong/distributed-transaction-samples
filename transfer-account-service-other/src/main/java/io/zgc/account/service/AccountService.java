package io.zgc.account.service;

import java.math.BigDecimal;

public interface AccountService {

    /**
     * 增加金额的方法
     *
     * */
    boolean increse(long uid,BigDecimal money);
}
