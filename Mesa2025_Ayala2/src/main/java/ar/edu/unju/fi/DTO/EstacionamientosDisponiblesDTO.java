package ar.edu.unju.fi.DTO;

public class EstacionamientosDisponiblesDTO {

	private int zona1;
	private int zona2;

	// Constructor
	public EstacionamientosDisponiblesDTO(int zona1, int zona2) {
		this.zona1 = zona1;
		this.zona2 = zona2;
	}

	// Getters y Setters
	public int getZona1() {
		return zona1;
	}

	public void setZona1(int zona1) {
		this.zona1 = zona1;
	}

	public int getZona2() {
		return zona2;
	}

	public void setZona2(int zona2) {
		this.zona2 = zona2;
	}
}
