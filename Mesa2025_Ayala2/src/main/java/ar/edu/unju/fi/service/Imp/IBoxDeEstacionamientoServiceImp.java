package ar.edu.unju.fi.service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.DTO.EstacionamientosDisponiblesDTO;
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
    public EstacionamientosDisponiblesDTO contarEstacionamientosDisponibles() {
        // Obtener todos los estacionamientos disponibles
        List<BoxDeEstacionamiento> estacionamientosDisponibles = (List<BoxDeEstacionamiento>) boxDeEstacionamientoRepository.findAll();

        int zona1Count = 0;
        int zona2Count = 0;

        // Filtrar los estacionamientos por zona y disponibilidad
        for (BoxDeEstacionamiento estacionamiento : estacionamientosDisponibles) {
            if (estacionamiento.getDisponibilidad()) {
                if (estacionamiento.getZona().toString().equals("ZONA1")) {
                    zona1Count++;
                } else if (estacionamiento.getZona().toString().equals("ZONA2")) {
                    zona2Count++;
                }
            }
        }

        // Crear y devolver el DTO con la cantidad de estacionamientos disponibles por zona
        return new EstacionamientosDisponiblesDTO(zona1Count, zona2Count);
    }
}
