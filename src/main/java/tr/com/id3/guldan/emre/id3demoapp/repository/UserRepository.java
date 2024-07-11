package tr.com.id3.guldan.emre.id3demoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.com.id3.guldan.emre.id3demoapp.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
