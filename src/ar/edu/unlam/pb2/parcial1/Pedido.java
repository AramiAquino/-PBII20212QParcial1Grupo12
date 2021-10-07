package ar.edu.unlam.pb2.parcial1;

public class Pedido {

	private Comida comida;
	private Bebida bebida;
	private Comida[] comidasAPedir;
	private Bebida[] bebidasAPedir;
	private Mozo mozo;
	private Mesa mesa;

	public Pedido(Comida comidasAPedir, Bebida bebidasAPedir, Mozo mozo, Mesa mesa) {
		this.comida = comidasAPedir;
		this.bebida = bebidasAPedir;
		this.mozo = mozo;
		this.mesa = mesa;
		this.comidasAPedir = new Comida[100];
		this.bebidasAPedir = new Bebida[100];

	}

	public Boolean agregarComidaAlpedido(Comida comida) {
		Boolean sePudoAgregar = false;
		for (int i = 0; i < comidasAPedir.length; i++) {
			if (comidasAPedir[i] == null) {
				comidasAPedir[i] = comida;
				sePudoAgregar = true;
				break;
			}
		}
		return sePudoAgregar;
	}

	public Boolean agregarBebidaAlpedido(Bebida bebida) {
		Boolean sePudoAgregar = false;
		for (int i = 0; i < bebidasAPedir.length; i++) {
			if (bebidasAPedir[i] == null) {
				bebidasAPedir[i] = bebida;
				sePudoAgregar = true;
				break;
			}
		}
		return sePudoAgregar;
	}
	
	public Boolean eliminarUnaComidaDelMenu(Comida comida) {
		Boolean sePudoEliminar = false;
		for (int i = 0; i < comidasAPedir.length; i++) {
			if (comidasAPedir[i].getDescripcion().equals(comida.getDescripcion())) {
				comidasAPedir[i] = null;
				sePudoEliminar = true;
				break;
			}
		}
		return sePudoEliminar;
	}
	
	public Boolean eliminarUnaBebidaDelPedido(Bebida bebida) {
		Boolean sePudoEliminar = false;
		for (int i = 0; i < bebidasAPedir.length; i++) {
			if (bebidasAPedir[i].getDescripcion().equals(bebida.getDescripcion())) {
				bebidasAPedir[i] = null;
				sePudoEliminar = true;
				break;
			}
		}
		return sePudoEliminar;
	}


	public Comida getComida() {
		return comida;
	}

	public void setComida(Comida comida) {
		this.comida = comida;
	}

	public Bebida getBebida() {
		return bebida;
	}

	public void setBebida(Bebida bebida) {
		this.bebida = bebida;
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
