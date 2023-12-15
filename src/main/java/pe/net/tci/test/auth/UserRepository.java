package pe.net.tci.test.auth;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<UserAccount, String> {
    @Transactional(readOnly = true)
    public Optional<UserAccount> findByName(String name);
}