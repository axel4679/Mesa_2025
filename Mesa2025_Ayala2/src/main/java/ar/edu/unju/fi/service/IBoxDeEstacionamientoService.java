package ar.edu.unju.fi.service;


import java.util.List;

import ar.edu.unju.fi.model.BoxDeEstacionamiento;
public interface IBoxDeEstacionamientoService {
	public BoxDeEstacionamiento crear(BoxDeEstacionamiento estacionamiento);

	public List<BoxDeEstacionamiento> listar();
	
	public void actualizarEstado(Long codigo, Boolean disponibilidad);	

	BoxDeEstacionamiento buscarPorId(Long id);
	
}
