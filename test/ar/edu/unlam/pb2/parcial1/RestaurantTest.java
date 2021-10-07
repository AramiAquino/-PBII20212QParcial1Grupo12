package ar.edu.unlam.pb2.parcial1;

import static org.junit.Assert.*;

import org.junit.Test;

public class RestaurantTest {

	@Test
	public void queSePuedanCrearLasClases() {

		Comida[] comidas = new Comida[10];
		Bebida[] bebidas = new Bebida[5];

		Mesa mesa = new Mesa(01, 6);
		Comida comida = new Comida("Pizza", 800.0);
		Bebida bebida = new Bebida("Cerveza", 350.0);
		Mozo mozo = new Mozo("Juan", 123456l, 123, 2);
		Comensal comensal = new Comensal("Maria", 7894561l, mesa);
		Pedido pedido = new Pedido(comidas, bebidas, mozo, mesa);
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
		Comida[] comidas = new Comida[10];
		Bebida[] bebidas = new Bebida[5];
		Comida comida = new Comida("Comida", 100.0);
		Mozo mozo = new Mozo("Juan", 123456l, 123, 2);
		Mesa mesa = new Mesa(01, 6);
		Pedido pedido = new Pedido(comidas, bebidas, mozo, mesa);

		Boolean valorObtenido = pedido.agregarComidaAlpedido(comida);

		assertTrue(valorObtenido);
	}

	@Test
	public void queSePuedaAgregarBebidaAlPedido() {
		Restaurant restaurant = new Restaurant("Insertar nombre de restaurant");
		Comida[] comidas = new Comida[10];
		Bebida[] bebidas = new Bebida[5];
		Comida comida = new Comida("Agua", 100.0);
		Comida bebida2 = new Comida("Comida", 100.0);
		Bebida bebida = new Bebida("Agua", 100.0);
		Mozo mozo = new Mozo("Juan", 123456l, 123, 2);
		Mesa mesa = new Mesa(01, 6);
		Pedido pedido = new Pedido(comidas, bebidas, mozo, mesa);

		Boolean valorObtenido = pedido.agregarBebidaAlpedido(bebida);

		assertTrue(valorObtenido);
	}
	
	@Test
	public void queSePuedaEliminarComidaDelPedido() {
		Comida[] comidas = new Comida[10];
		Bebida[] bebidas = new Bebida[5];
		Comida comida = new Comida("Comida", 100.0);
		Mozo mozo = new Mozo("Juan", 123456l, 123, 2);
		Mesa mesa = new Mesa(01, 6);
		Pedido pedido = new Pedido(comidas, bebidas, mozo, mesa);
		
		pedido.agregarComidaAlpedido(comida);

		Boolean valorObtenido = pedido.eliminarUnaComidaDelMenu(comida);

		assertTrue(valorObtenido);
	}
	
	@Test
	public void queSePuedaEliminarBebidaDelPedido() {
		Comida[] comidas = new Comida[10];
		Bebida[] bebidas = new Bebida[5];
		Bebida bebida = new Bebida("Comida", 100.0);
		Mozo mozo = new Mozo("Juan", 123456l, 123, 2);
		Mesa mesa = new Mesa(01, 6);
		Pedido pedido = new Pedido(comidas, bebidas, mozo, mesa);
		
		pedido.agregarBebidaAlpedido(bebida);

		Boolean valorObtenido = pedido.eliminarUnaBebidaDelPedido(bebida);

		assertTrue(valorObtenido);
	}

}
