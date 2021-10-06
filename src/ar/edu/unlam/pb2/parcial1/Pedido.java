package ar.edu.unlam.pb2.parcial1;

public class Pedido {

	private Comida[] comidasAPedir;
	private Bebida[] bebidasAPedir;
	private Mozo mozo;
	private Mesa mesa;

	public Pedido(Comida[] comidasAPedir, Bebida[] bebidasAPedir, Mozo mozo, Mesa mesa) {
		this.comidasAPedir = comidasAPedir;
		this.bebidasAPedir = bebidasAPedir;
		this.mozo = mozo;
		this.mesa = mesa;

	}

	public Comida[] getComidasAPedir() {
		return comidasAPedir;
	}

	public void setComidasAPedir(Comida[] comidasAPedir) {
		this.comidasAPedir = comidasAPedir;
	}

	public Bebida[] getBebidasAPedir() {
		return bebidasAPedir;
	}

	public void setBebidasAPedir(Bebida[] bebidasAPedir) {
		this.bebidasAPedir = bebidasAPedir;
	}

	public Mozo getMozo() {
		return mozo;
	}

	public void setMozo(Mozo mozo) {
		this.mozo = mozo;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

}
