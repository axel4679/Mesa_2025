package ar.edu.unju.fi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.model.BoxDeEstacionamiento;

@Repository
public interface BoxDeEstacionamientoRepository extends CrudRepository<BoxDeEstacionamiento , Long> {
	
}
