package ar.edu.unlam.pb2.parcial1;

public class Mesa {

	private Integer numero;
	private Integer capacidad;
	private Boolean disponible;

	public Mesa(int numero, int capacidad) {
		this.numero = numero;
		this.capacidad = capacidad;
		this.disponible = Boolean.TRUE;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}

	public Boolean getDisponible() {
		return disponible;
	}

	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}

}
