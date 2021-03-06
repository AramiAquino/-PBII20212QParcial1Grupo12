package ar.edu.unlam.pb2.parcial1;

public abstract class Persona {

	private Long documento;
	private String nombre;

	public Persona(String nombre, Long documento) {
		this.nombre = nombre;
		this.documento = documento;
	}

	public Long getDocumento() {
		return documento;
	}

	public void setDocumento(Long documento) {
		this.documento = documento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
