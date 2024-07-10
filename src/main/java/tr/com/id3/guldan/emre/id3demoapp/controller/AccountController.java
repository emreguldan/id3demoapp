package tr.com.id3.guldan.emre.id3demoapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.com.id3.guldan.emre.id3demoapp.entity.Account;
import tr.com.id3.guldan.emre.id3demoapp.service.AccountService;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/{userId}")
    public Account createAccount(@PathVariable Long userId, @RequestBody Account account) {
        return accountService.createAccount(userId, account);
    }

    @GetMapping("/{userId}")
    public List<Account> getAccountByUserId(@PathVariable Long userId) {
        return accountService.getAccountByUserId(userId);
    }

    @DeleteMapping("/{accountId}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long accountId) {
        accountService.deleteAccount(accountId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/transfer")
    public ResponseEntity<String> transferBalance(@RequestParam Long fromAccountId, @RequestParam Long toAccountId, @RequestParam Double amount) {
        String response = accountService.transferBalance(fromAccountId, toAccountId, amount);
        return ResponseEntity.ok(response);
    }
}
