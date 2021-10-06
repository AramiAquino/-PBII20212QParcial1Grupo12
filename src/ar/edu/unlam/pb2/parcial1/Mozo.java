package ar.edu.unlam.pb2.parcial1;

public class Mozo extends Persona {

	private Integer legajo;
	private Integer cantidadPedidos;

	public Mozo(String nombre, Long documento, Integer legajo, Integer cantidadPedidos) {
		super(nombre,documento);
		this.setLegajo(legajo);
		this.setCantidadPedidos(cantidadPedidos);
	}

	public Integer getLegajo() {
		return legajo;
	}

	public void setLegajo(Integer legajo) {
		this.legajo = legajo;
	}

	public Integer getCantidadPedidos() {
		return cantidadPedidos;
	}

	public void setCantidadPedidos(Integer cantidadPedidos) {
		this.cantidadPedidos = cantidadPedidos;
	}



}
