package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.BoxDeEstacionamiento.Zona;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity 
@Component
@Getter
@Setter

public class ReservaEstacionamiento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long codigo;

	private Zona zona;
	
	@OneToOne
	private Automovil automovil;
	
	@OneToOne
	private BoxDeEstacionamiento estacionamiento;

	private Boolean estado;
	private Long horas;
	private Long costo;
}