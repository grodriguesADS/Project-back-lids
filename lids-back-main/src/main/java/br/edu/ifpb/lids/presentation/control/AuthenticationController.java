package br.edu.ifpb.lids.presentation.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpb.lids.config.CustomAuthenticationProvider;
import br.edu.ifpb.lids.config.TokenService;
import br.edu.ifpb.lids.model.entity.User;
import br.edu.ifpb.lids.model.repository.UserRepository;
import br.edu.ifpb.lids.presentation.dto.AuthenticationDto;
import br.edu.ifpb.lids.presentation.dto.LoginResponseDto;
import br.edu.ifpb.lids.presentation.dto.RegisterDto;

@RestController
@RequestMapping("/api/user")
public class AuthenticationController {

    @Autowired
    private CustomAuthenticationProvider authenticationManager;

    @Autowired
    private UserRepository repository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthenticationDto data) {
    var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
    var auth = authenticationManager.authenticate(usernamePassword);
    var token = tokenService.generateToken(auth);

    return ResponseEntity.ok(new LoginResponseDto(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterDto data) {
        if (this.repository.existsByLogin(data.login()))
            return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.login(), encryptedPassword, data.role());

        this.repository.save(newUser);

        return ResponseEntity.ok().build();
    }
}
