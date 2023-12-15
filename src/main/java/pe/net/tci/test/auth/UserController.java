package pe.net.tci.test.auth;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/auth")
public class UserController {

    private SignInService signInService;
    private SignUpService signupService;

    @PostMapping("/login")
    public String login(@RequestBody @Valid SignInService.LoginInput input) {
        return signInService.run(input);
    }

    @PostMapping("/signup")
    public UserAccount signup(@RequestBody @Valid SignUpService.Input input) {
        return signupService.run(input);
    }
}