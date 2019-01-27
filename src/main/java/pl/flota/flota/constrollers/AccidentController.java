package pl.flota.flota.constrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.flota.flota.repositories.AccidentDAO;
import pl.flota.flota.repositories.AccidentDTO;
import pl.flota.flota.repositories.CarsDAO;
import pl.flota.flota.utils.AccidentResponse;

import java.util.List;

@RestController
@RequestMapping("/accidents")
public class AccidentController {

  @Autowired
  private AccidentDAO accidentDAO;

  @Autowired
  private CarsDAO carsDAO;

  @GetMapping("/send")
  public String alertAccident(@RequestParam("reg") String reg, @RequestParam("content") String content) {
    try{
      AccidentDTO accidentDTO = new AccidentDTO();
      accidentDTO.setUnread(true);
      accidentDTO.setContent(content);
      accidentDTO.setCar(carsDAO.findByReg(reg));

      accidentDTO = accidentDAO.save(accidentDTO);
    }catch(Exception e) {
      return "Nie udalo sie zglosic problemu";
    }

    return "Wyslano informacje o problemie!";
  }

  @GetMapping("/{id}")
  public AccidentResponse getAccident(@PathVariable("id") Integer id) {
    AccidentResponse accidentResponse = new AccidentResponse();
    AccidentDTO accident = accidentDAO.getOne(id);
    accidentResponse.setId(accident.getId());
    accidentResponse.setContent(accident.getContent());
    accidentResponse.setReg(accident.getCar().getReg());
    return accidentResponse;
  }

  @GetMapping
  public List<AccidentDTO> getNewAccidents() {
    List<AccidentDTO> list = accidentDAO.findAllByUnread(true);

    for(AccidentDTO dto : list) {
      dto.setUnread(false);
    }

    return accidentDAO.saveAll(list);
  }
}
