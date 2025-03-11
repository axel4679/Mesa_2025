package ar.edu.unju.fi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.model.BoxDeEstacionamiento;
import ar.edu.unju.fi.service.IBoxDeEstacionamientoService;
import ch.qos.logback.core.model.Model;
// GetMApping pedir informacion
//Postmapping enviar informacion
public class IndexController {
  
  @Autowired
  private IBoxDeEstacionamientoService boxDeEstacionamientoService;

  @GetMapping("/")
  public ModelAndView index(Model model) {
           // Pasamos los datos al modelo
      ModelAndView mav = new ModelAndView("index");
 	 mav.addObject("espaciosDisponibles", boxDeEstacionamientoService.listar());
 	 return mav;
  }
  
}
