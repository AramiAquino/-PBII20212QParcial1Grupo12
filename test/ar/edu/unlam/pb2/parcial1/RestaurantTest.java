package ar.edu.unlam.pb2.parcial1;

import static org.junit.Assert.*;

import org.junit.Test;

public class RestaurantTest {

	@Test
	public void queSePuedanCrearLasClases() {
		Mesa mesa = new Mesa(01, 6);
		Comida comida = new Comida("Pizza", 800.0);
		Bebida bebida = new Bebida("Cerveza", 350.0);
		Mozo mozo = new Mozo("Juan", 123456l, 123, 2);
		Comensal comensal = new Comensal("Maria", 7894561l);
		Pedido pedido = new Pedido(comida, bebida, mozo, mesa);
		Restaurant restaurant = new Restaurant("Insertar nombre de restaurant");

		assertNotNull(mesa);
		assertNotNull(comida);
		assertNotNull(bebida);
		assertNotNull(mozo);
		assertNotNull(comensal);
		assertNotNull(pedido);
		assertNotNull(restaurant);

	}

	@Test
	public void queSePuedaAgregarUnaMesaAlRestaurant() {

		Mesa mesa = new Mesa(01, 6);
		Restaurant restaurant = new Restaurant("Insertar nombre de restaurant");
		Boolean valorObtenido = restaurant.agregarUnaMesa(mesa);

		assertTrue(valorObtenido);
	}

	@Test
	public void queSePuedaReservarUnaMesa() {

		Mesa mesa = new Mesa(01, 6);
		Mesa mesa2 = new Mesa(02, 4);
		Restaurant restaurant = new Restaurant("Insertar nombre de restaurant");
		restaurant.agregarUnaMesa(mesa);
		restaurant.agregarUnaMesa(mesa2);

		Boolean valorObtenido = restaurant.reservarUnaMesa(01, 5);

		assertTrue(valorObtenido);
	}

	@Test
	public void queNoSePuedaReservarUnaMesaOcupada() {

		Mesa mesa = new Mesa(01, 6);
		Mesa mesa2 = new Mesa(02, 4);
		Restaurant restaurant = new Restaurant("Insertar nombre de restaurant");
		restaurant.agregarUnaMesa(mesa);
		restaurant.agregarUnaMesa(mesa2);
		restaurant.reservarUnaMesa(01, 4);

		Boolean valorObtenido = restaurant.reservarUnaMesa(01, 5);

		assertFalse(valorObtenido);
	}

	@Test
	public void queNoSePuedaReservarUnaMesaSiHayMasComensalesQueElLimite() {

		Mesa mesa = new Mesa(01, 6);
		Mesa mesa2 = new Mesa(02, 4);
		Restaurant restaurant = new Restaurant("Insertar nombre de restaurant");

		restaurant.agregarUnaMesa(mesa);
		restaurant.agregarUnaMesa(mesa2);
		Boolean valorObtenido = restaurant.reservarUnaMesa(01, 7);

		assertFalse(valorObtenido);
	}

	@Test
	public void queSePuedaAgregarUnaComidaAlMenu() {
		Restaurant restaurant = new Restaurant("Insertar nombre de restaurant");
		Comida comida = new Comida("Milanesa", 150.0);

		Boolean valorObtenido = restaurant.agregarUnaComidaAlMenu(comida);

		assertTrue(valorObtenido);
	}

	@Test
	public void queSePuedaAgregarUnaBebidaAlMenu() {
		Restaurant restaurant = new Restaurant("Insertar nombre de restaurant");
		Bebida bebida = new Bebida("Agua", 100.0);

		Boolean valorObtenido = restaurant.agregarUnaBebidaAlMenu(bebida);

		assertTrue(valorObtenido);
	}

	@Test
	public void queSePuedaAgregarComidaAlPedido() {
		Comida comida = new Comida("Comida", 100.0);
		Bebida bebida = new Bebida("Comida", 100.0);
		Mozo mozo = new Mozo("Juan", 123456l, 123, 2);
		Mesa mesa = new Mesa(01, 6);
		Pedido pedido = new Pedido(comida, bebida, mozo, mesa);

		Boolean valorObtenido = pedido.agregarComidaAlpedido(comida);

		assertTrue(valorObtenido);
	}

	@Test
	public void queSePuedaAgregarBebidaAlPedido() {
		Comida comida = new Comida("Agua", 100.0);
		Bebida bebida = new Bebida("Agua", 100.0);
		Mozo mozo = new Mozo("Juan", 123456l, 123, 2);
		Mesa mesa = new Mesa(01, 6);
		Pedido pedido = new Pedido(comida, bebida, mozo, mesa);

		Boolean valorObtenido = pedido.agregarBebidaAlpedido(bebida);

		assertTrue(valorObtenido);
	}

	@Test
	public void queSePuedaEliminarComidaDelPedido() {
		Comida comida = new Comida("Comida", 100.0);
		Bebida bebida = new Bebida("Comida", 100.0);
		Mozo mozo = new Mozo("Juan", 123456l, 123, 2);
		Mesa mesa = new Mesa(01, 6);
		Pedido pedido = new Pedido(comida, bebida, mozo, mesa);
		pedido.agregarComidaAlpedido(comida);

		Boolean valorObtenido = pedido.eliminarUnaComidaDelPedido(comida);

		assertTrue(valorObtenido);
	}

	@Test
	public void queSePuedaEliminarBebidaDelPedido() {
		Comida comida = new Comida("Comida", 100.0);
		Bebida bebida1 = new Bebida("Comida", 100.0);
		Bebida bebida = new Bebida("Comida", 100.0);
		Mozo mozo = new Mozo("Juan", 123456l, 123, 2);
		Mesa mesa = new Mesa(01, 6);
		Pedido pedido = new Pedido(comida, bebida1, mozo, mesa);
		pedido.agregarBebidaAlpedido(bebida);

		Boolean valorObtenido = pedido.eliminarUnaBebidaDelPedido(bebida);

		assertTrue(valorObtenido);
	}

	@Test
	public void queSePuedaCalcularLaDeudaDeUnaMesa() {
		Restaurant restaurant = new Restaurant("Insertar nombre de restaurant");
		Comida comida = new Comida("Comida", 100.0);
		restaurant.agregarUnaComidaAlMenu(comida);
		Bebida bebida1 = new Bebida("Comida", 100.0);
		restaurant.agregarUnaBebidaAlMenu(bebida1);
		Mozo mozo = new Mozo("Juan", 123456l, 123, 2);
		Mesa mesa = new Mesa(01, 6);
		restaurant.agregarUnaMesa(mesa);
		Pedido pedido = new Pedido(comida, bebida1, mozo, mesa);
		restaurant.agregarUnPedidoAPedidos(pedido);
		Integer nroMesa = mesa.getNumero();

		Double valorEsperado = 200d;
		Double valorObtenido = restaurant.calcularDeudaDeUnaMesa(nroMesa);

		assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void queSePuedaCalcularElValorDeLaDeudaTotalDelRestaurant() {
		Restaurant restaurant = new Restaurant("Insertar nombre de restaurant");

		Comida comida = new Comida("Comida", 100.0);
		restaurant.agregarUnaComidaAlMenu(comida);

		Bebida bebida1 = new Bebida("Comida", 100.0);
		restaurant.agregarUnaBebidaAlMenu(bebida1);

		Mozo mozo = new Mozo("Juan", 123456l, 123, 2);

		Mesa mesa = new Mesa(01, 6);
		restaurant.agregarUnaMesa(mesa);
		Mesa mesa2 = new Mesa(02, 4);
		Pedido pedido = new Pedido(comida, bebida1, mozo, mesa);
		Pedido pedido2 = new Pedido(comida, bebida1, mozo, mesa2);
		restaurant.agregarUnPedidoAPedidos(pedido);
		restaurant.agregarUnPedidoAPedidos(pedido2);

		Double valorEsperado = 400d;
		Double valorObtenido = restaurant.calcularTotalDeudaTodasLasMesas();

		assertEquals(valorEsperado, valorObtenido);

	}

	@Test
	public void queSePuedaAgregarComensalesAUnaMesa() {
		Restaurant restaurant = new Restaurant("Insertar nombre de restaurant");
		Mesa mesa = new Mesa(01, 6);
		restaurant.agregarUnaMesa(mesa);
		Comensal comensal = new Comensal("Lucia", 1234567l);

		Boolean valorObtenido = restaurant.agregarComensalAUnaMesa(comensal);

		assertTrue(valorObtenido);
	}

	@Test
	public void queNoSePuedaAgregarComensalesAUnaMesaOcupada() {
		Restaurant restaurant = new Restaurant("Insertar nombre de restaurant");
		Mesa mesa = new Mesa(01, 6);
		restaurant.agregarUnaMesa(mesa);
		Comensal comensal = new Comensal("Lucia", 1234567l);
		Comensal comensal2 = new Comensal("Maria", 1287677l);

		restaurant.agregarComensalAUnaMesa(comensal);
		Boolean valorObtenido = restaurant.agregarComensalAUnaMesa(comensal2);

		assertFalse(valorObtenido);
	}

	@Test
	public void queSePuedaAgregarVariosComensalesAUnaMesa() {
		Restaurant restaurant = new Restaurant("Insertar nombre de restaurant");
		Mesa mesa = new Mesa(01, 6);
		restaurant.agregarUnaMesa(mesa);
		Comensal[] comensales = new Comensal[2];
		comensales[0] = new Comensal("Lucia", 1234567l);
		comensales[1] = new Comensal("Maria", 1287677l);
		Boolean valorObtenido = restaurant.agregarComensalAUnaMesa(mesa, comensales);

		assertTrue(valorObtenido);
	}

	@Test
	public void queSePuedaEliminarUnaComidaDelMenu() {
		Restaurant restaurant = new Restaurant("Insertar nombre de restaurant");
		Comida comida = new Comida("Milanesa", 150.0);
		restaurant.agregarUnaComidaAlMenu(comida);

		Boolean valorObtenido = restaurant.eliminarUnaComidaDelMenu(comida);

		assertTrue(valorObtenido);
	}

	@Test
	public void queSePuedaEliminarUnaBebidaDelMenu() {
		Restaurant restaurant = new Restaurant("Insertar nombre de restaurant");
		Bebida bebida = new Bebida("Agua", 100.0);
		restaurant.agregarUnaBebidaAlMenu(bebida);

		Boolean valorObtenido = restaurant.eliminarUnaBebidaDelMenu(bebida);

		assertTrue(valorObtenido);
	}

	@Test
	public void queSePuedaContratarAUnMozo() {
		Restaurant restaurant = new Restaurant("Insertar nombre de restaurant");
		Mozo mozo = new Mozo("Alan", 123L, 13, 0);

		Boolean valorObtenido = restaurant.contratarMozo(mozo);

		assertTrue(valorObtenido);
	}

	@Test
	public void queSePuedaDespedirAUnMozo() {
		Restaurant restaurant = new Restaurant("Insertar nombre de restaurant");
		Mozo mozo = new Mozo("Alan", 123L, 13, 0);
		restaurant.contratarMozo(mozo);

		Boolean valorObtenido = restaurant.despedirMozo(mozo);

		assertTrue(valorObtenido);
	}

	@Test
	public void queSePuedaMostrarElMenuDeComidas() {
		Restaurant restaurant = new Restaurant("Insertar nombre de restaurant");
		Comida comida = new Comida("Milanesa", 150.0);
		restaurant.agregarUnaComidaAlMenu(comida);

		Comida[] valorObtenido = restaurant.getMenuComidas();

		assertNotNull(valorObtenido);
	}

	@Test
	public void queSePuedaMostrarElMenuDeBebidas() {
		Restaurant restaurant = new Restaurant("Insertar nombre de restaurant");
		Bebida bebida = new Bebida("Agua", 100.0);
		restaurant.agregarUnaBebidaAlMenu(bebida);

		Bebida[] valorObtenido = restaurant.getMenuBebidas();

		assertNotNull(valorObtenido);
	}

	@Test
	public void queSePuedaConocerCuantosPedidosTieneAsignadoElMozo() {
		Restaurant restaurant = new Restaurant("Insertar nombre de restaurant");
		Comida comida = new Comida("Comida", 100.0);
		Bebida bebida = new Bebida("Comida", 100.0);
		Mozo mozo = new Mozo("Juan", 123456l, 123, 0);
		Mesa mesa = new Mesa(01, 6);
		Pedido pedido = new Pedido(comida, bebida, mozo, mesa);
		restaurant.agregarUnPedidoAPedidos(pedido);
		Integer valorEsperado = 1;

		Integer valorObtenido = mozo.getCantidadPedidos();

		assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void queSePuedaVerLaCantidadDeMesasDisponibles() {
		Restaurant restaurant = new Restaurant("Insertar nombre de restaurant");
		Mesa mesa = new Mesa(01, 6);
		Mesa mesa2 = new Mesa(02, 6);
		Mesa mesa3 = new Mesa(03, 6);
		Mesa mesa4 = new Mesa(04, 6);

		restaurant.agregarUnaMesa(mesa);
		restaurant.agregarUnaMesa(mesa2);
		restaurant.agregarUnaMesa(mesa3);
		restaurant.agregarUnaMesa(mesa4);

		Integer valorEsperado = 4;
		Integer valorObtenido = restaurant.getCantidadDeMesasDisponibles();

		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queLaMesaSePongaDisponibleCuandoSePagueElPedido() {
		Restaurant restaurant = new Restaurant("Insertar nombre de restaurant");
		Mesa mesa = new Mesa(01, 6);
		restaurant.agregarUnaMesa(mesa);
		Comensal comensal = new Comensal("Lucia", 1234567l);
		restaurant.agregarComensalAUnaMesa(comensal);
		restaurant.recibirPagoDeUnaMesa(mesa.getNumero());
		
		Boolean valorObtenido = mesa.getDisponible();
		assertTrue(valorObtenido);
	}
	
	@Test
	public void queNoSePuedaPedirLoQueNoEstaEnElMenu() {
		Restaurant restaurant = new Restaurant("Insertar nombre de restaurant");
		Mesa mesa = new Mesa(01, 6);
		restaurant.agregarUnaMesa(mesa);
		Comensal comensal = new Comensal("Lucia", 1234567l);
		restaurant.agregarComensalAUnaMesa(comensal);
		Comida pasta = new Comida("Espaguetti", 400d);
		restaurant.agregarUnaComidaAlMenu(pasta);
		Bebida gaseosa = new Bebida("Coca Cola", 120d);
		restaurant.agregarUnaBebidaAlMenu(gaseosa);
		Mozo mozo = new Mozo("Juan", 123456l, 123, 0);
		Pedido pedido = new Pedido(pasta, gaseosa, mozo, mesa);
		Boolean valorObtenido = restaurant.chequearQueLoPedidoEsteEnElMenu(pedido);
		
		assertTrue(valorObtenido);
		
	}
	
	@Test
	public void queSePuedaRealizarUnPedidoSoloDeBebidas() {
		Bebida bebida = new Bebida("Bebida", 100.0);
		Mozo mozo = new Mozo("Juan", 123456l, 123, 2);
		Mesa mesa = new Mesa(01, 6);
		
		Pedido pedido = new Pedido(bebida, mozo, mesa);

		assertNotNull(pedido);
		assertNull(pedido.getComidasAPedir()[0]);
	}
	
	@Test
	public void queSePuedaRealizarUnPedidoSoloDeComidas() {
		Comida comida = new Comida("Comida", 100.0);
		Mozo mozo = new Mozo("Juan", 123456l, 123, 2);
		Mesa mesa = new Mesa(01, 6);
		
		Pedido pedido = new Pedido(comida, mozo, mesa);

		assertNotNull(pedido);
		assertNull(pedido.getBebidasAPedir()[0]);
	}
}
