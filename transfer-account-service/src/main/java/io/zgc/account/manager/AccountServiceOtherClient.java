package io.zgc.account.manager;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@FeignClient(name = "user-service-other")
public interface AccountServiceOtherClient {
    @GetMapping("/increse")
    boolean increse(@RequestParam("id") long id, @RequestParam("money") BigDecimal money);
}
