package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.model.BoxDeEstacionamiento;
import ar.edu.unju.fi.model.ReservaEstacionamiento;
import ar.edu.unju.fi.service.IAutomovilService;
import ar.edu.unju.fi.service.IBoxDeEstacionamientoService;
import ar.edu.unju.fi.service.IReservaEstacionamientoService;

@Controller
public class ReservaEstacionamientoController {
	@Autowired
	IReservaEstacionamientoService reservaEstacionamientoService;
	@Autowired
	IAutomovilService automovilService;
	@Autowired
	IBoxDeEstacionamientoService boxDeEstacionamientoService;

	@GetMapping("/reserva/nuevo")
	public ModelAndView reservaNuevo() {
		ModelAndView mav = new ModelAndView("formularioReservaEstacionamiento");
		mav.addObject("reserva", new ReservaEstacionamiento());
		mav.addObject("automoviles", automovilService.listar());
		mav.addObject("estacionamientos", boxDeEstacionamientoService.listar());
		return mav;

	}

	@PostMapping("/reservas/guardar")
	public String guardarReservaEstacionamientos(ReservaEstacionamiento reserva) {
		reservaEstacionamientoService.crear(reserva);
		BoxDeEstacionamiento box=reserva.getEstacionamiento();
		boxDeEstacionamientoService.actualizarEstado(box.getCodigo(), box.getDisponibilidad());
		return "redirect:/reservas";
	}

	@GetMapping("/reservas")
	public ModelAndView listarReservaEstacionamientos() {
		ModelAndView mav = new ModelAndView("listaReservaEstacionamientos");
		mav.addObject("reservas", reservaEstacionamientoService.listar());
		return mav;
	}
	
	
}
