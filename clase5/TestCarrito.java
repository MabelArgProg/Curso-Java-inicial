package clase5;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class TestCarrito {

	@Test
	void testCostoFinalDescuentoFijo() {
		Producto producto1 = new Producto("arroz", "17125", 300);
		Producto producto2 = new Producto("pollo", "417p", 2500);
		Producto producto3 = new Producto("salsa", "9567s", 250);
		Carrito miCarrito = new Carrito(producto1, producto2, producto3,LocalDateTime.parse("2023-03-19T18:10:00"));
		Descuento desFijo = new DescuentoFijo(50);
		
		float valorFinal = miCarrito.costoFinal(desFijo);
		assertEquals(valorFinal, 3000);
	}

	@Test
	void testCostoFinalDescuentoPorcentaje() {
		Producto producto1 = new Producto("arroz", "17125", 300);
		Producto producto2 = new Producto("pollo", "417p", 2500);
		Producto producto3 = new Producto("salsa", "9567s", 200);
		Carrito miCarrito = new Carrito(producto1, producto2, producto3,LocalDateTime.parse("2023-03-19T18:10:00"));
		Descuento desPorcentaje = new DescuentoPorcentaje(0.10f);
		
		float valorFinal = miCarrito.costoFinal(desPorcentaje);
		assertEquals(valorFinal, 2700);
	}
	
	@Test
	void testCostoFinalDescuentoPorcentajeConTope() {
		Producto producto1 = new Producto("arroz", "17125", 300);
		Producto producto2 = new Producto("pollo", "417p", 2500);
		Producto producto3 = new Producto("salsa", "9567s", 200);
		Carrito miCarrito = new Carrito(producto1, producto2, producto3,LocalDateTime.parse("2023-03-19T18:10:00"));
		Descuento desPorcentajeConTope = new DescuentoPorcentajeConTope(0.50f);
		desPorcentajeConTope.setValorDesc(0.10f);
		
		float valorFinal = miCarrito.costoFinal(desPorcentajeConTope);
		assertEquals(valorFinal, 2700);
	}
}
