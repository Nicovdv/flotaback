package pl.flota.flota.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccidentDAO extends JpaRepository<AccidentDTO, Integer> {
  List<AccidentDTO> findAllByUnread(Boolean bool);
}
