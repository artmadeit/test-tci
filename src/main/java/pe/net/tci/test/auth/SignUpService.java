package pe.net.tci.test.auth;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Service
@AllArgsConstructor
public class SignUpService {

    @Data
    public static class Input {
        @NotBlank
        String name;

        @NotBlank
        String password;
    }

    UserRepository userRepository;
    PasswordEncoder passwordEncoder;

    public UserAccount run(Input input) {
        return userRepository.save(new UserAccount(input.name, passwordEncoder.encode(input.password)));
    }
}
