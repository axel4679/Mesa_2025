package ar.edu.unju.fi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.model.ReservaEstacionamiento;

@Service
public interface IReservaEstacionamientoService {
	
	public ReservaEstacionamiento crear(ReservaEstacionamiento estacionar);
	
	public List<ReservaEstacionamiento> listar();
	
//	public void eliminarEstacionar(Long codigo);
}