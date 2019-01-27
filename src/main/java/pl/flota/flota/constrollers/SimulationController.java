package pl.flota.flota.constrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.flota.flota.services.SimulationService;
import pl.flota.flota.utils.StartSimulationDTO;

@RestController
@RequestMapping("/simulation")
public class SimulationController {

  @Autowired
  private SimulationService simulationService;

  @PostMapping("/start")
  public void startSimulation(@RequestBody StartSimulationDTO startSimulationDTO) {
    simulationService.startSimulation(startSimulationDTO.getOrigin(),
            startSimulationDTO.getDestination(),
            startSimulationDTO.getReg());
  }
}