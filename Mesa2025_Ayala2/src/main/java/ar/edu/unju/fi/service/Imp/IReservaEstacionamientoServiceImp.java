package ar.edu.unju.fi.service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.model.ReservaEstacionamiento;
import ar.edu.unju.fi.repository.AutomovilRepository;
import ar.edu.unju.fi.repository.BoxDeEstacionamientoRepository;
import ar.edu.unju.fi.repository.ReservaEstacionamientoRepository;
import ar.edu.unju.fi.service.IReservaEstacionamientoService;
@Service
public class IReservaEstacionamientoServiceImp implements IReservaEstacionamientoService {
	@Autowired
	AutomovilRepository automovilRepository; 
	@Autowired
	BoxDeEstacionamientoRepository boxDeEstacionamientoRepository;
	@Autowired
	ReservaEstacionamientoRepository reservaEstacionamientoRepository;
	@Override
	public ReservaEstacionamiento crear(ReservaEstacionamiento estacionar) {
		// TODO Auto-generated method stub
		return reservaEstacionamientoRepository.save(estacionar);
	}

	@Override
	public List<ReservaEstacionamiento> listar() {
		// TODO Auto-generated method stub
		return (List<ReservaEstacionamiento>) reservaEstacionamientoRepository.findAll();
	}

}
