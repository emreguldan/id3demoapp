package tr.com.id3.guldan.emre.id3demoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.com.id3.guldan.emre.id3demoapp.entity.Account;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findByUserId(Long userId);
}
