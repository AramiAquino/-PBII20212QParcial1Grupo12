package ar.edu.unlam.pb2.parcial1;

public class Comensal extends Persona {

	private Mesa mesa;

	public Comensal(String nombre, Long documento) {
		super(nombre, documento);
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

}
