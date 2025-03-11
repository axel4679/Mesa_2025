package ar.edu.unju.fi.service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.model.BoxDeEstacionamiento;
import ar.edu.unju.fi.repository.BoxDeEstacionamientoRepository;
import ar.edu.unju.fi.service.IBoxDeEstacionamientoService;

@Service
public class IBoxDeEstacionamientoServiceImp implements IBoxDeEstacionamientoService {
	@Autowired
	BoxDeEstacionamientoRepository boxDeEstacionamientoRepository;

	@Override
	public BoxDeEstacionamiento crear(BoxDeEstacionamiento estacionamiento) {
		// TODO Auto-generated method stub
		return boxDeEstacionamientoRepository.save(estacionamiento);
	}

	@Override
	public List<BoxDeEstacionamiento> listar() {
		// TODO Auto-generated method stub
		return (List<BoxDeEstacionamiento>) boxDeEstacionamientoRepository.findAll();
	}

	@Override
	public void actualizarEstado(Long codigo, Boolean disponibilidad) {
		// TODO Auto-generated method stub
		BoxDeEstacionamiento estacionamiento = boxDeEstacionamientoRepository.findById(codigo)
				.orElseThrow(() -> new RuntimeException("Estacionamiento no encontrada"));
		estacionamiento.setDisponibilidad(disponibilidad);
		boxDeEstacionamientoRepository.save(estacionamiento);
	}

	@Override
	public BoxDeEstacionamiento buscarPorId(Long id) {
		return boxDeEstacionamientoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Estacionamiento no encontrada"));
	}
}
