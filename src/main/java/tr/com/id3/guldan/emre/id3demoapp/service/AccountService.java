package tr.com.id3.guldan.emre.id3demoapp.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.id3.guldan.emre.id3demoapp.entity.Account;
import tr.com.id3.guldan.emre.id3demoapp.entity.User;
import tr.com.id3.guldan.emre.id3demoapp.repository.AccountRepository;
import tr.com.id3.guldan.emre.id3demoapp.repository.UserRepository;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserRepository userRepository;

    public Account createAccount(Long userId, Account account) {
        User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));
        account.setUser(user);
        return accountRepository.save(account);
    }

    public List<Account> getAccountByUserId(Long userId) {
        return accountRepository.findByUserId(userId);
    }

    public void deleteAccount(Long accountId) {
        accountRepository.deleteById(accountId);
    }

    public String transferBalance(Long fromAccountId, Long toAccountId, Double amount) {

        Account fromAccount = accountRepository.findById(fromAccountId).orElseThrow(() -> new RuntimeException("Account not found with id: " + fromAccountId));
        Account toAccount = accountRepository.findById(toAccountId).orElseThrow(() -> new RuntimeException("Account not found with id: " + toAccountId));

        if (!fromAccount.getCurrency().equals(toAccount.getCurrency())) {
            throw new IllegalArgumentException("Currency mismatch");
        }

        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);

        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);

        if (!fromAccount.getUser().getId().equals(toAccount.getUser().getId())) {
            return "Transfer successful between different users";
        }

        return "Transfer successful within the same user";
    }
}
