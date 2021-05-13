package pl.bank.demo.user.domain;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
class UserConfiguration {

    @Bean
    public UserFacade createUserFacade(UserRepository userRepository) {
        return UserFacade.builder()
                .userRepository(userRepository)
                .build();
    }
}
