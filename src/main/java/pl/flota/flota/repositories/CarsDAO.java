package pl.flota.flota.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarsDAO extends JpaRepository<CarsDTO, String> {

    CarsDTO findByReg(String reg);

    List<CarsDTO> findAllByActive(Boolean bool);
}
