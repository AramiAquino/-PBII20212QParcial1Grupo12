package ar.edu.unlam.pb2.parcial1;

public class Comida {

	private String descripcion;
	private Double precio;

	public Comida(String descripcion, Double precio) {
		this.setDescripcion(descripcion);
		this.setPrecio(precio);
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

}
