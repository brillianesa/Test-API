package id.amartek.app.controller.RestAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.amartek.app.model.User;
import id.amartek.app.service.AccountService;
import id.amartek.app.service.UserServices;
import id.amartek.app.DTO.LoginRequest;
import id.amartek.app.DTO.LoginResponse;
import id.amartek.app.DTO.RegisterRequest;
import id.amartek.app.handler.Response;

@RestController
@RequestMapping("api")
public class UserRestController {
    @Autowired
    private UserServices<User> userServices;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AccountService accountService;

    @GetMapping("user")
    public ResponseEntity<Object> get() {
        return Response.generate(HttpStatus.OK, "Data retrieved", userServices.getAll());
    }

    @GetMapping("user/{id}")
    public ResponseEntity<Object> get(@PathVariable(required = true) Integer id) {
        return Response.generate(HttpStatus.OK, "Data retrieved", userServices.Get(id));
    }

    @PostMapping("user")
    public ResponseEntity<Object> post(@RequestBody User user) {
        userServices.Save(user);
        return Response.generate(HttpStatus.OK, "Data saved");
    }

    @DeleteMapping("user/{id}")
    public ResponseEntity<Object> delete(@PathVariable(required = true) Integer id) {
        userServices.Delete(id);
        return Response.generate(HttpStatus.OK, "Data deleted");
    }

    @PostMapping("user/login")
    public ResponseEntity<Object> login(@RequestBody LoginRequest login) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        if (authentication.isAuthenticated()) {
            return Response.generate(HttpStatus.OK, "Logged In");
        }
        return Response.generate(HttpStatus.OK, "Failed to login");
    }

    @PostMapping("user/register")
    public ResponseEntity<Object> register(@RequestBody RegisterRequest registerRequest) {
        Boolean result = accountService.register(registerRequest);
        if (result) {
            return Response.generate(HttpStatus.OK, "Data saved");
        }
        return Response.generate(HttpStatus.OK, "Data failed to save");
    }

    @PostMapping("user/forgot")
    public String forgotPassword() {
        return "";
    }

    @PostMapping("profile/changePassword")
    public String changePassword() {
        return "";
    }
}
