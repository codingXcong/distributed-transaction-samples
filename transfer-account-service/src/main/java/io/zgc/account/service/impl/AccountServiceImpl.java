package io.zgc.account.service.impl;

import java.math.BigDecimal;

import io.zgc.account.model.Account;
import io.zgc.account.repository.AccountRepository;
import io.zgc.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;
	
	/**
	 * debit方法需要有事务《
	 */
	@Transactional
	public boolean debit(long id, BigDecimal money) {
		//扣减金额.
		Account account = accountRepository.findById(id);
		if(account ==  null) {
			throw new RuntimeException("Account is not exist");
		}
		if(account.getMoney().compareTo(money) == -1) {
			throw new RuntimeException("Money is not enough");
		}
		
		account.setMoney(account.getMoney().subtract(money));
		accountRepository.save(account);
		
		//扣减金额，判断如果是李四的id = 1002的时候，不可操作，抛出异常，为了方便测试。
		if(id == 1002) {
			//强制抛出. 为了测试本地事务是否可以回滚。
			throw new RuntimeException("Account is invalid,id="+id);
		}
		
		return true;
	}

}
