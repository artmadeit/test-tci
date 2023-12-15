package pe.net.tci.test.auth;

import pe.net.tci.test.auth.jwt.JwtTokenProvider;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Service
public class SignInService {

    @Data
    public static class LoginInput {
        @NotBlank
        protected String name;

        @NotBlank
        protected String password;
    }

    private JwtTokenProvider jwtTokenProvider;
    private AuthenticationManager authenticationManager;

    public String run(LoginInput input) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(input.name, input.password));
        return jwtTokenProvider.createToken(input.name, authentication.getAuthorities());
    }
}