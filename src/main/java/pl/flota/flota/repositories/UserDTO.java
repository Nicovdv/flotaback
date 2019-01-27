package pl.flota.flota.repositories;
import lombok.Generated;
import lombok.Setter;
import lombok.Getter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name = "user")
public class UserDTO {
    @Id
    @Column (name = "username") private String username;
    @Column (name = "email") private String email;
    @Column (name = "password") private String password;
    private String create_time;

    public UserDTO(String username, String email, String password){
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public UserDTO(){

    }



}
