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

	public Boolean contratarMozo(Mozo mozo) {
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

	private Boolean agregarUnComensal(Comensal comensal) {
		Boolean sePudoAgregar = false;
		for (int i = 0; i < comensales.length; i++) {
			if (comensales[i] == null) {
				comensales[i] = comensal;
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

				Integer PedidosDelMozo = pedido.getMozo().getCantidadPedidos();
				Integer PedidosDelMozoActual = PedidosDelMozo + 1;
				pedido.getMozo().setCantidadPedidos(PedidosDelMozoActual);
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

				for (int j = 0; j < pedidos[i].getBebidasAPedir().length; j++) {
					if (pedidos[i].getBebidasAPedir()[j] != null) {
						deuda += pedidos[i].getBebidasAPedir()[j].getPrecio();
					}
				}
				for (int k = 0; k < pedidos[i].getComidasAPedir().length; k++) {
					if (pedidos[i].getComidasAPedir()[k] != null) {
						deuda += pedidos[i].getComidasAPedir()[k].getPrecio();
					}
				}
				break;
			}

		}
		return deuda;
	}

	public Double calcularTotalDeudaTodasLasMesas() {
		for (int i = 0; i < pedidos.length; i++) {
			if (pedidos[i] != null) {
				Integer numeroMesa = pedidos[i].getMesa().getNumero();
				totalDeuda += calcularDeudaDeUnaMesa(numeroMesa);
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

	public Boolean agregarComensalAUnaMesa(Comensal comensal) {
		Boolean sePudoAgregar = false;
		for (int i = 0; i < mesas.length; i++) {
			if (mesas[i] != null && mesas[i].getDisponible()) {
				if (agregarUnComensal(comensal)) {
					sePudoAgregar = true;
					mesas[i].setDisponible(false);
					break;
				}
			}
		}
		return sePudoAgregar;
	}

	public Boolean agregarComensalAUnaMesa(Mesa mesa, Comensal[] comensalesAAgregar) {
		Boolean sePudoAgregar = false;
		for (int i = 0; i < mesas.length; i++) {
			if (mesas[i] != null && mesas[i].getDisponible()) {
				for (int j = 0; j < comensalesAAgregar.length; j++) {
					if (comensales[j] != null) {
						agregarUnComensal(comensalesAAgregar[j]);
					}
				}
				sePudoAgregar = true;
				mesas[i].setDisponible(false);
				break;
			}
		}
		return sePudoAgregar;
	}

	public Boolean eliminarUnaComidaDelMenu(Comida comida) {
		Boolean sePudoEliminar = false;
		for (int i = 0; i < menuComidas.length; i++) {
			if (menuComidas[i].getDescripcion().equals(comida.getDescripcion())) {
				menuComidas[i] = null;
				sePudoEliminar = true;
				break;
			}
		}
		return sePudoEliminar;
	}

	public Boolean eliminarUnaBebidaDelMenu(Bebida bebida) {
		Boolean sePudoEliminar = false;
		for (int i = 0; i < menuBebidas.length; i++) {
			if (menuBebidas[i].getDescripcion().equals(bebida.getDescripcion())) {
				menuBebidas[i] = null;
				sePudoEliminar = true;
				break;
			}
		}
		return sePudoEliminar;
	}

	public Boolean despedirMozo(Mozo mozo) {
		Boolean sePudoEliminar = false;
		for (int i = 0; i < mozos.length; i++) {
			if (mozos[i].getLegajo().equals(mozo.getLegajo())) {
				mozos[i] = null;
				sePudoEliminar = true;
				break;
			}
		}
		return sePudoEliminar;
	}

	public Integer getCantidadDeMesasDisponibles() {
		Integer cantidadDeMesasDisponibles = 0;
		for (int i = 0; i < mesas.length; i++) {
			if (mesas[i] != null && mesas[i].getDisponible()) {
				cantidadDeMesasDisponibles++;
			}
		}
		return cantidadDeMesasDisponibles;
	}

	public Boolean recibirPagoDeUnaMesa(Integer nroMesa) {
		Boolean sePudoRecibir = false;
		for (int i = 0; i < mesas.length; i++) {
			if (mesas[i] != null && mesas[i].getNumero() == nroMesa && mesas[i].getDisponible() == false) {
				sePudoRecibir = true;
				mesas[i].setDisponible(true);
				break;
			}
		}

		return sePudoRecibir;
	}

	public Boolean chequearQueLoPedidoEsteEnElMenu(Pedido pedido) {
		Boolean estaEnElMenu = false;
		Comida comidaPedida = pedido.getComida();
		Bebida bebidaPedida = pedido.getBebida();
		for (int i = 0; i < menuComidas.length; i++) {
			if (menuComidas[i] != null && menuComidas[i].equals(comidaPedida)) {
				for (int j = 0; j < menuBebidas.length; j++) {
					if (menuBebidas[j] != null && menuBebidas[j].equals(bebidaPedida)) {
						estaEnElMenu = true;
						break;
					}
				}
				break;
			}
		}
		return estaEnElMenu;
	}
}
