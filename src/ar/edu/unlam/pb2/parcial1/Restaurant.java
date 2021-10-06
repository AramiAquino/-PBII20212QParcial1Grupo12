package ar.edu.unlam.pb2.parcial1;

public class Restaurant {

	private String nombre;
	private Mozo[] mozos;
	private Mesa[] mesas;
	private Pedido[] pedidos;

	public Restaurant(String nombre, Mozo[] mozos, Mesa[] mesas, Pedido[] pedidos) {
		this.setNombre(nombre);
		this.setMozos(mozos);
		this.setMesas(mesas);
		this.setPedidos(pedidos);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Mozo[] getMozos() {
		return mozos;
	}

	public void setMozos(Mozo[] mozos) {
		this.mozos = mozos;
	}

	public Mesa[] getMesas() {
		return mesas;
	}

	public void setMesas(Mesa[] mesas) {
		this.mesas = mesas;
	}

	public Pedido[] getPedidos() {
		return pedidos;
	}

	public void setPedidos(Pedido[] pedidos) {
		this.pedidos = pedidos;
	}

	public Boolean agregarUnaMesa(Mesa mesa) {
		Boolean sePudoAgregar = false;

		for (int i = 0; i < mesas.length; i++) {
			if (mesas[i] == null) {
				mesas[i] = mesa;
				sePudoAgregar = true;
				break;
			}
		}
		return sePudoAgregar;
	}

	public Boolean reservarUnaMesa(int nroDeMesa, int cantidadDeComensales) {
		Boolean sePudoReservar = false;
		// buscar por nro de mesa
		for (int i = 0; i < mesas.length; i++) {
			if (mesas[i] != null && mesas[i].getNumero() == nroDeMesa && mesas[i].getDisponible()
					&& mesas[i].getCapacidad() >= cantidadDeComensales) {
				sePudoReservar = true;
				// Poner la mesa como NO disponible
				mesas[i].setDisponible(false);
				break;
			}
		}
		return sePudoReservar;

	}

}
