package ar.edu.unlam.pb2.parcial1;

public class Mesa {

	
	private Integer numero;
	private Integer capacidad;
	private Boolean disponible;

	public Mesa(int numero, int capacidad, Boolean disponible ) {
		this.setNumero(numero);
		this.setCapacidad(capacidad);
		this.setDisponible(disponible);
		
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
