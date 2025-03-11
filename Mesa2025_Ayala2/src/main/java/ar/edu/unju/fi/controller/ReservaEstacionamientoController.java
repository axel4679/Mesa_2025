package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.model.Automovil;
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
	public ModelAndView reservaNuevo(@RequestParam(value = "box", required = false) Long boxId) {
	    ModelAndView mav = new ModelAndView("formularioReservaEstacionamiento");
	    ReservaEstacionamiento reserva = new ReservaEstacionamiento();

	    // Si se recibe un ID de box, lo establece en la reserva
	    if (boxId != null) {
	        BoxDeEstacionamiento boxSeleccionado = boxDeEstacionamientoService.buscarPorId(boxId);
	        reserva.setEstacionamiento(boxSeleccionado);
	    }

	    mav.addObject("reserva", reserva);
	    mav.addObject("automoviles", automovilService.listar());
	    mav.addObject("estacionamientos", boxDeEstacionamientoService.listar());
	    return mav;
	}


	@PostMapping("/reservas/guardar")
	public String guardarReservaEstacionamientos(ReservaEstacionamiento reserva) {
		reservaEstacionamientoService.crear(reserva);
		BoxDeEstacionamiento box=reserva.getEstacionamiento();
		boxDeEstacionamientoService.actualizarEstado(box.getCodigo(), reserva.getEstado());
		Automovil automovil=reserva.getAutomovil();
		automovilService.actualizarEstado(automovil.getPatente(), reserva.getEstado());
		return "redirect:/reservas";
	}

	@GetMapping("/reservas")
	public ModelAndView listarReservaEstacionamientos() {
		ModelAndView mav = new ModelAndView("listaReservaEstacionamientos");
		mav.addObject("reservas", reservaEstacionamientoService.listar());
		return mav;
	}
	
	
}
