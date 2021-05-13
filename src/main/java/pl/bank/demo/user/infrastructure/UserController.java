package pl.bank.demo.user.infrastructure;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.bank.demo.user.domain.UserFacade;
import pl.bank.demo.user.dto.LoginRequest;
import pl.bank.demo.user.dto.RegistrationRequest;

import static org.springframework.http.HttpStatus.*;

@RequestMapping("/user")
@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)

class UserController {

    UserFacade userFacade;

    @Autowired
    UserController(UserFacade userFacade) {
        this.userFacade = userFacade;
    }

    @CrossOrigin
    @PostMapping("/register")
    public ResponseEntity<String> userRegister(@RequestBody RegistrationRequest registrationRequest) throws Exception {
        userFacade.registerUser(registrationRequest);
        return new ResponseEntity<>("Password created", CREATED);
    }

    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity<String> userLogin(@RequestBody LoginRequest loginRequest) throws Exception {
        if (userFacade.loginUser(loginRequest)) {
            return new ResponseEntity<>("Login successfully", OK);
        } else {
            return new ResponseEntity<>("Bad credentials", UNAUTHORIZED);
        }
    }
}
