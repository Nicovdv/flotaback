package pl.flota.flota.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.flota.flota.repositories.UserDTO;
import pl.flota.flota.repositories.UserDAO;

@Service
public class AddUserService {


    private final UserDAO userDAO;

    @Autowired
    public AddUserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public String create(String username, String email, String password){
        try{
            UserDTO user = new UserDTO(username, email, password);
            userDAO.save(user);
        }
        catch (Exception ex){
            return "Error creating user: " + ex.toString();
        }
        return "User: " + username + " created!";
    }


}
