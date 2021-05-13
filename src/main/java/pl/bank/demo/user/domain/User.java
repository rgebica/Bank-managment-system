package pl.bank.demo.user.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;
import pl.bank.demo.user.dto.UserDto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String motherSurnameFromHome;
    String password;

    UserDto dto() {
        return UserDto.builder()
                .id(id)
                .motherSurnameFromHome(motherSurnameFromHome)
                .password(password)
                .build();
    }
}
