package pl.flota.flota.repositories;
import lombok.Setter;
import lombok.Getter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name = "cars")
public class CarsDTO {
    @Id @Column (name = "reg") private String reg;
    @Column(name = "phone")private String phone;
    @Column(name = "lati") private double lati;
    @Column(name = "longi") private double longi;
    @Column(name = "alert") private String alert;
    @Column(name = "active") private Boolean active;

    public CarsDTO(){

    }





}
