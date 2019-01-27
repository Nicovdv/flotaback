package pl.flota.flota.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.flota.flota.repositories.UserDTO;

@Repository
public interface UserDAO extends JpaRepository<UserDTO, String> {

//    public UserDTO save(String username, String email, String password);

}
