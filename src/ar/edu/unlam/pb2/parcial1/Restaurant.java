package ar.edu.unlam.pb2.parcial1;

public class Restaurant {

	private String nombre;
	private Mozo[] mozos;
	private Mesa[] mesas;
	private Pedido[] pedidos;
	private Comida[] menuComidas;
	private Bebida[] menuBebidas;
	private Comensal[] comensales;
	private Double totalDeuda;

	public Restaurant(String nombre) {
		this.nombre = nombre;
		this.mozos = new Mozo[100];
		this.mesas = new Mesa[1000];
		this.pedidos = new Pedido[10000];
		this.menuComidas = new Comida[100];
		this.menuBebidas = new Bebida[100];
		this.totalDeuda = 0d;
		this.comensales = new Comensal[1000];
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

	public Boolean agregarUnMozo(Mozo mozo) {
		Boolean sePudoAgregar = false;

		for (int i = 0; i < mozos.length; i++) {
			if (mozos[i] == null) {
				mozos[i] = mozo;
				sePudoAgregar = true;
				break;
			}
		}
		return sePudoAgregar;
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

	public Boolean agregarUnPedidoAPedidos(Pedido pedido) {
		Boolean sePudoAgregar = false;
		for (int i = 0; i < pedidos.length; i++) {
			if (pedidos[i] == null) {
				pedidos[i] = pedido;
				sePudoAgregar = true;
				break;
			}
		}
		return sePudoAgregar;
	}

	public Double calcularDeudaDeUnaMesa(Integer nroMesa) {
		Double deuda = 0d;
		for (int i = 0; i < pedidos.length; i++) {
			if (pedidos[i] != null && pedidos[i].getMesa().getNumero() == nroMesa) {
				deuda = pedidos[i].getBebida().getPrecio() + pedidos[i].getComida().getPrecio();
				break;
			}
		}
		return deuda;
	}

	public Double calcularTotalDeudaTodasLasMesas() {
		for (int i = 0; i < pedidos.length; i++) {
			if (pedidos[i] != null) {
				this.totalDeuda += pedidos[i].getBebida().getPrecio() + pedidos[i].getComida().getPrecio();
			}
		}
		return totalDeuda;
	}

	public Boolean contratarUnMozo(Mozo mozo) {
		Boolean sePudoAgregar = false;
		for (int i = 0; i < mozos.length; i++) {
			if (mozos[i] == null) {
				mozos[i] = mozo;
				sePudoAgregar = true;
				break;
			}
		}
		return sePudoAgregar;
	}
	
	public Boolean agregarComensalAUnaMesa(Mesa mesa, Comensal comensal) {
		Boolean sePudoAgregar = false;

		if(mesa.getDisponible() == true) {
			for (int i = 0; i < comensales.length; i++) {
				if (comensales[i] == null) {
					comensales[i] = comensal;
					sePudoAgregar = true;
					mesa.setDisponible(false);
					break;
				}
			}
		}
		
		return sePudoAgregar;
	}
	
	public Boolean agregarComensalAUnaMesa(Mesa mesa, Comensal[] comensalesAAgregar) {
		Boolean sePudoAgregar = false;

		if(mesa.getDisponible() && comensalesAAgregar.length <= mesa.getCapacidad()) {
			for (int i = 0, j = 0; i < comensales.length; i++) {
				if(comensales[i] == null && comensalesAAgregar[j] != null) {
					comensales[i] = comensalesAAgregar[j];
					j++;
					if(j == comensalesAAgregar.length) {
						sePudoAgregar = true;
						break;
					}
				}
			}
		}

		return sePudoAgregar;
	}
}
