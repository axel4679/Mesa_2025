package ar.edu.unju.fi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.model.BoxDeEstacionamiento;
import ar.edu.unju.fi.service.IBoxDeEstacionamientoService;

@Controller 
public class IndexController {
  
  @Autowired
  private IBoxDeEstacionamientoService boxDeEstacionamientoService;

  @GetMapping("/")
  public String index(Model model) {
      List<BoxDeEstacionamiento> espaciosDisponibles = boxDeEstacionamientoService.listar();
      
      // Pasamos los datos al modelo
      model.addAttribute("espaciosDisponibles", espaciosDisponibles);
      
      return "index"; // Retorna la vista "index.html"
  }
}
