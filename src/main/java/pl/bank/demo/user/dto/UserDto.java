package pl.bank.demo.user.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public final class UserDto {

    long id;
    String motherSurnameFromHome;
    String password;

}
