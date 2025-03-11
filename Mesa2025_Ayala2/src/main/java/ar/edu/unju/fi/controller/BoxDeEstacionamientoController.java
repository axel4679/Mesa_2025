package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.DTO.EstacionamientosDisponiblesDTO;
import ar.edu.unju.fi.model.BoxDeEstacionamiento;
import ar.edu.unju.fi.service.IBoxDeEstacionamientoService;

@Controller
public class BoxDeEstacionamientoController {
	@Autowired
	IBoxDeEstacionamientoService boxDeEstacionamientoService;
	
	
	@GetMapping("/estacionamiento/nuevo")
	public ModelAndView estacionamientoNuevo() {
		 ModelAndView mav = new ModelAndView("formularioBoxDeEstacionamiento");
		 mav.addObject("estacionamiento", new BoxDeEstacionamiento());
		 return mav;

	}
	
	@GetMapping("/estacionamientos")
	public ModelAndView listarEstacionamientos() {
		 ModelAndView mav = new ModelAndView("listaBoxDeEstacionamientos");
		 mav.addObject("estacionamientos", boxDeEstacionamientoService.listar());
		 return mav;

	}
	
	@GetMapping("/estacionamientos/disponibles")
    @ResponseBody
    public EstacionamientosDisponiblesDTO contarEstacionamientosDisponibles() {
        return boxDeEstacionamientoService.contarEstacionamientosDisponibles();
    }
	
	@PostMapping("/estacionamientos/guardar")
	public String guardarBoxDeEstacionamiento(BoxDeEstacionamiento estacionamiento) {
		boxDeEstacionamientoService.crear(estacionamiento);
		return "redirect:/estacionamientos";
	}
	
}
