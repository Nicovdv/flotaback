package pl.flota.flota.repositories;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class AccidentDTO {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  @Column private String content;
  @Column private Boolean unread;

  @JsonUnwrapped
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "reg")
  private CarsDTO car;
}
