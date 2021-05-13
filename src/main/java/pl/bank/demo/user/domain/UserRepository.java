package pl.bank.demo.user.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByIdAndMotherSurnameFromHome(Long id, String motherSurnameFromHome);
    Optional<User> findById(Long id);
    boolean existsByIdAndPassword(Long id, String password);
}
