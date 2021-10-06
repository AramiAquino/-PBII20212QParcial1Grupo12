package ar.edu.unlam.pb2.parcial1;

import static org.junit.Assert.*;

import org.junit.Test;

public class RestaurantTest {

	@Test
	public void queSePuedanCrearLasClases() {

		Mesa[] mesas = new Mesa[10];
		Mozo[] mozos = new Mozo[10];
		Comida[] comidas = new Comida[10];
		Bebida[] bebidas = new Bebida[5];
		Pedido[] pedidos = new Pedido[50];

		Mesa mesa = new Mesa(01, 6, Boolean.TRUE);
		Comida comida = new Comida("Pizza", 800.0);
		Bebida bebida = new Bebida("Cerveza", 350.0);
		Mozo mozo = new Mozo("Juan", 123456l, 123, 2);
		Comensal comensal = new Comensal("Maria", 7894561l, mesa);
		Pedido pedido = new Pedido(comidas, bebidas, mozo, mesa);
		Restaurant restaurant = new Restaurant("Insertar nombre de restaurant", mozos, mesas, pedidos, comidas,
				bebidas);

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
		Mesa[] mesas = new Mesa[10];
		Mozo[] mozos = new Mozo[10];
		Pedido[] pedidos = new Pedido[50];
		Comida[] comidas = new Comida[10];
		Bebida[] bebidas = new Bebida[5];

		Mesa mesa = new Mesa(01, 6, Boolean.TRUE);
		Restaurant restaurant = new Restaurant("Insertar nombre de restaurant", mozos, mesas, pedidos, comidas,
				bebidas);
		Boolean valorObtenido = restaurant.agregarUnaMesa(mesa);

		assertTrue(valorObtenido);
	}

	@Test
	public void queSePuedaReservarUnaMesa() {
		Mesa[] mesas = new Mesa[10];
		Mozo[] mozos = new Mozo[10];
		Pedido[] pedidos = new Pedido[50];
		Comida[] comidas = new Comida[10];
		Bebida[] bebidas = new Bebida[5];

		Mesa mesa = new Mesa(01, 6, Boolean.TRUE);
		Mesa mesa2 = new Mesa(02, 4, Boolean.TRUE);
		Restaurant restaurant = new Restaurant("Insertar nombre de restaurant", mozos, mesas, pedidos, comidas,
				bebidas);

		restaurant.agregarUnaMesa(mesa);
		restaurant.agregarUnaMesa(mesa2);

		Boolean valorObtenido = restaurant.reservarUnaMesa(01, 5);

		assertTrue(valorObtenido);
	}

	@Test
	public void queNoSePuedaReservarUnaMesaOcupada() {
		Mesa[] mesas = new Mesa[10];
		Mozo[] mozos = new Mozo[10];
		Pedido[] pedidos = new Pedido[50];
		Comida[] comidas = new Comida[10];
		Bebida[] bebidas = new Bebida[5];

		Mesa mesa = new Mesa(01, 6, Boolean.TRUE);
		Mesa mesa2 = new Mesa(02, 4, Boolean.TRUE);
		Restaurant restaurant = new Restaurant("Insertar nombre de restaurant", mozos, mesas, pedidos, comidas,
				bebidas);

		restaurant.agregarUnaMesa(mesa);
		restaurant.agregarUnaMesa(mesa2);
		restaurant.reservarUnaMesa(01, 4);

		Boolean valorObtenido = restaurant.reservarUnaMesa(01, 5);

		assertFalse(valorObtenido);
	}

	@Test
	public void queNoSePuedaReservarUnaMesaSiHayMasComensalesQueElLimite() {
		Mesa[] mesas = new Mesa[10];
		Mozo[] mozos = new Mozo[10];
		Pedido[] pedidos = new Pedido[50];
		Comida[] comidas = new Comida[10];
		Bebida[] bebidas = new Bebida[5];

		Mesa mesa = new Mesa(01, 6, Boolean.TRUE);
		Mesa mesa2 = new Mesa(02, 4, Boolean.TRUE);
		Restaurant restaurant = new Restaurant("Insertar nombre de restaurant", mozos, mesas, pedidos, comidas,
				bebidas);

		restaurant.agregarUnaMesa(mesa);
		restaurant.agregarUnaMesa(mesa2);
		Boolean valorObtenido = restaurant.reservarUnaMesa(01, 7);

		assertFalse(valorObtenido);
	}

	@Test
	public void queSePuedaAgregarUnaComidaAlRestaurant() {
		Mesa[] mesas = new Mesa[10];
		Mozo[] mozos = new Mozo[10];
		Pedido[] pedidos = new Pedido[50];
		Comida[] comidas = new Comida[10];
		Bebida[] bebidas = new Bebida[5];
		Restaurant restaurant = new Restaurant("Insertar nombre de restaurant", mozos, mesas, pedidos, comidas,
				bebidas);
		Comida comida = new Comida("Milanesa", 150.0);

		
		Boolean valorObtenido = restaurant.agregarUnaComidaAlMenu(comida);

		assertTrue(valorObtenido);
	}
	
	@Test
	public void queSePuedaAgregarUnaBebidaAlRestaurant() {
		Mesa[] mesas = new Mesa[10];
		Mozo[] mozos = new Mozo[10];
		Pedido[] pedidos = new Pedido[50];
		Comida[] comidas = new Comida[10];
		Bebida[] bebidas = new Bebida[5];
		Restaurant restaurant = new Restaurant("Insertar nombre de restaurant", mozos, mesas, pedidos, comidas,
				bebidas);
		Bebida bebida = new Bebida("Agua", 100.0);

		
		Boolean valorObtenido = restaurant.agregarUnaBebidaAlMenu(bebida);

		assertTrue(valorObtenido);
	}

}
