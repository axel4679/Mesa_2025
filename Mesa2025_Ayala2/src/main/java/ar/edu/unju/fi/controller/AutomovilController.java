package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.model.Automovil;
import ar.edu.unju.fi.service.IAutomovilService;

@Controller
public class AutomovilController {
 @Autowired
 IAutomovilService automovilService;
 
 @GetMapping("/automovil/nuevo")
 public ModelAndView automovilNuevo() {
     ModelAndView mav = new ModelAndView("formularioAutomovil");
     mav.addObject("automovil", new Automovil());
     return mav;
 }
 
 
 @GetMapping("/automoviles")
 public ModelAndView listarAutomoviles() {
	 ModelAndView mav = new ModelAndView("listaAutomoviles");
	 mav.addObject("automoviles", automovilService.listar());
	 return mav;
 }
 @PostMapping("/automoviles/guardar")
 public String guardarAutomovil(Automovil automovil) {
	 automovilService.crear(automovil);
	 return "redirect:/automoviles";
 }
 
 
}
