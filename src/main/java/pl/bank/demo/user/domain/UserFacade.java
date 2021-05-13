package pl.bank.demo.user.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;
import pl.bank.demo.user.dto.LoginRequest;
import pl.bank.demo.user.dto.RegistrationRequest;
import pl.bank.demo.user.dto.UserDto;

@Builder
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserFacade {

    UserRepository userRepository;

    public UserDto registerUser(RegistrationRequest registrationRequest) throws Exception {

        User user = getUserById(registrationRequest.getId());

        if (checkUserCredentials(registrationRequest.getId(), registrationRequest.getMotherSurnameFromHome())) {
            user.setPassword(registrationRequest.getPassword());
            return userRepository.save(user).dto();
        } else {
            return null;
        }
    }

    public boolean loginUser(LoginRequest loginRequest) throws Exception {
        return checkLoginCredentials(loginRequest.getId(), loginRequest.getPassword());
    }

    private boolean checkUserCredentials(Long id, String motherSurnameFromHome) {
        if (userRepository.existsByIdAndMotherSurnameFromHome(id, motherSurnameFromHome)) {
            return true;
        } else {
            return false;
        }
    }

    private User getUserById(Long id) throws Exception {
        return userRepository.findById(id)
                .orElseThrow(() -> new Exception("Can not find user"));
    }

    private boolean checkLoginCredentials(Long id, String password) {
        if (userRepository.existsByIdAndPassword(id, password)) {
            return true;
        } else {
            return false;
        }
    }
}
