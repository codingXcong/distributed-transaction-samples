package io.zgc.account.repository;

import io.zgc.account.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

    /**
     * 通过id获取账号信息
     * @param id
     * @return
     */
    Account findById(long id);

}
