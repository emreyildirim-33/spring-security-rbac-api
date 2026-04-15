package com.workintech.s19d2.controller;

import com.workintech.s19d2.entity.Account;
import com.workintech.s19d2.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/account","/workintech/accounts"})
@AllArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @GetMapping
    public List<Account> findAll() {
        return accountService.findAll();
    }

    @GetMapping("/{id}")
    public Account find(@PathVariable long id) {
        return accountService.find(id);
    }

    @PostMapping
    public Account save(@RequestBody Account account) {
        return accountService.save(account);
    }

    @PutMapping("/{id}")
    public Account update(@PathVariable long id,@RequestBody Account account) {
        account.setId(id);
        return accountService.save(account);
    }

    @DeleteMapping("/{id}")
    public Account delete(@PathVariable long id) {
        return accountService.delete(id);
    }
}
