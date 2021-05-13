package pl.bank.demo.user.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public final class RegistrationRequest {

    Long id;
    String password;
    String motherSurnameFromHome;

}
