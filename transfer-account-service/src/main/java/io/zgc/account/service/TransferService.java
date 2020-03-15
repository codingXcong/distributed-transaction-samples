package io.zgc.account.service;

import java.math.BigDecimal;

public interface TransferService {
    boolean transfer(BigDecimal money);
}
