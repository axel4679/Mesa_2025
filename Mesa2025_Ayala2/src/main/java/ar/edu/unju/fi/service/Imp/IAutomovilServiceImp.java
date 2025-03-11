package ar.edu.unju.fi.service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.model.Automovil;
import ar.edu.unju.fi.model.BoxDeEstacionamiento;
import ar.edu.unju.fi.repository.AutomovilRepository;
import ar.edu.unju.fi.service.IAutomovilService;
@Service
public class IAutomovilServiceImp implements IAutomovilService {
	@Autowired
	AutomovilRepository automovilRepository; 
	@Override
	public Automovil crear(Automovil automovil) {
		// TODO Auto-generated method stub
		return automovilRepository.save(automovil);
	}
	
	@Override
	public List<Automovil> listar() {
		// TODO Auto-generated method stub
		return (List<Automovil>) automovilRepository.findAll();
	}
	@Override
	public void actualizarEstado(String patente, Boolean disponibilidad) {
		// TODO Auto-generated method stub
		Automovil estacionamiento = automovilRepository.findById(patente).orElseThrow(() -> new RuntimeException("Estacionamiento no encontrada"));
		estacionamiento.setEstado(disponibilidad);
		automovilRepository.save(estacionamiento);
	}
}
