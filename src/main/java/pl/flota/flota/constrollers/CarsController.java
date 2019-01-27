package pl.flota.flota.constrollers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.flota.flota.repositories.CarsDAO;
import pl.flota.flota.repositories.CarsDTO;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/cars")
public class CarsController {
    

    @Autowired
    private CarsDAO carsDAO;



    @DeleteMapping("/{reg}")
    public void deleteCar(@PathVariable("reg") String reg) {
        carsDAO.deleteById(reg);
    }

    @PostMapping
    @RequestMapping
    public CarsDTO addCar(@RequestBody CarsDTO carsDTO) {
        carsDTO.setLati(51.00012322);
        carsDTO.setLongi(21.31231231);
        carsDTO.setActive(false);
        return carsDAO.save(carsDTO);
    }

    @GetMapping("/all")
    public List<CarsDTO> getAllCar() {
        return carsDAO.findAll();
    }

    @GetMapping("/all/active")
    public List<CarsDTO> getAllActiveCar() {
        return carsDAO.findAllByActive(true);
    }
}
