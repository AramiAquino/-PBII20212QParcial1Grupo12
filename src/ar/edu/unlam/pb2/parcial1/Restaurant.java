package ar.edu.unlam.pb2.parcial1;

public class Restaurant {

	private String nombre;
	private Mozo[] mozos;
	private Mesa[] mesas;
	private Pedido[] pedidos;
	private Comida[] menuComidas;
	private Bebida[] menuBebidas;

	public Restaurant(String nombre, Mozo[] mozos, Mesa[] mesas, Pedido[] pedidos, Comida[] menuComidas,
			Bebida[] menuBebidas) {
		this.nombre = nombre;
		this.mozos = mozos;
		this.mesas = mesas;
		this.pedidos = pedidos;
		this.menuComidas = menuComidas;
		this.menuBebidas = menuBebidas;
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

	public Comida[] getMenuComidas() {
		return menuComidas;
	}

	public void setMenuComidas(Comida[] menuComidas) {
		this.menuComidas = menuComidas;
	}

	public Bebida[] getMenuBebidas() {
		return menuBebidas;
	}

	public void setMenuBebidas(Bebida[] menuBebidas) {
		this.menuBebidas = menuBebidas;
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

	public Boolean agregarUnaComidaAlMenu(Comida comida) {
		Boolean sePudoAgregar = false;
		for (int i = 0; i < menuComidas.length; i++) {
			if (menuComidas[i] == null) {
				menuComidas[i] = comida;
				sePudoAgregar = true;
				break;
			}
		}
		return sePudoAgregar;
	}

	public Boolean agregarUnaBebidaAlMenu(Bebida bebida) {
		Boolean sePudoAgregar = false;
		for (int i = 0; i < menuBebidas.length; i++) {
			if (menuBebidas[i] == null) {
				menuBebidas[i] = bebida;
				sePudoAgregar = true;
				break;
			}
		}
		return sePudoAgregar;
	}

}
