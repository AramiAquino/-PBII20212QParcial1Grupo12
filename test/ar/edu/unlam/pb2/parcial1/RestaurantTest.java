package ar.edu.unlam.pb2.parcial1;

import static org.junit.Assert.*;

import org.junit.Test;

public class RestaurantTest {

	@Test
	public void queSePuedanCrearLasClases() {
		Mesa mesa = new Mesa(01, 6, Boolean.TRUE);
		Comida comida = new Comida ("Pizza", 800.0);
		Bebida bebida = new Bebida("Cerveza", 350.0);
		Mozo mozo = new Mozo("Juan", 123456, 123, 2);
		Comensal comensal = new Comensal("Maria", 7894561, mesa);
		Pedido pedido = new Pedido(comida, bebida, mozo, mesa);
		Restaurant restaurant = new Restaurant("Insertar nombre de restaurant");
	}

}
