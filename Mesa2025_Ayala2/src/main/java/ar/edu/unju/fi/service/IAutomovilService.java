package ar.edu.unju.fi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.model.Automovil;

@Service
public interface IAutomovilService {
	public Automovil crear(Automovil automovil);

	// public Automovil actualizar(Automovil automovil);

	public List<Automovil> listar();

	// public void eliminar(String dni);
}
