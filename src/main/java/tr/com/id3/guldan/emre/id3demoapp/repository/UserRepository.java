package tr.com.id3.guldan.emre.id3demoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.com.id3.guldan.emre.id3demoapp.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
