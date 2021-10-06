package ar.edu.unlam.pb2.parcial1;

public class Bebida {

	private Double precio;
	private String descripcion;

	public Bebida(String descripcion, Double precio) {
		this.setDescripcion(descripcion);
		this.setPrecio(precio);
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


}
