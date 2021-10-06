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

}
