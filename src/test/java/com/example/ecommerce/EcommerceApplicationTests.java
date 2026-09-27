package com.example.ecommerce;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.ecommerce.model.Carrito;
import com.example.ecommerce.model.ProductoDigital;
import com.example.ecommerce.model.ProductoFisico;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class EcommerceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void carritoAdmiteSobrecargasYProductosDeClasesDerivadas() {
		ProductoDigital digital = new ProductoDigital(
				1, "Libro electrónico", "Guía de Java", 12.50, 20,
				"Personal", "https://ejemplo.com");
		ProductoFisico fisico = new ProductoFisico(
				2, "Teclado", "Teclado mecánico", 45.00, 8, 0.8, 35.0);
		Carrito carrito = new Carrito();

		carrito.agregarProducto(digital);
		carrito.agregarProducto(2, List.of(digital, fisico));
		carrito.agregarProducto("Servicio", 5.00);

		assertEquals(3, carrito.getProductos().size());
		assertEquals(62.50, carrito.getTotal(), 0.001);
		assertTrue(carrito.mostrarDetallesProductos().contains("Tipo de licencia: Personal"));
		assertTrue(carrito.mostrarDetallesProductos().contains("Peso: 0.8 kg"));
		assertThrows(IllegalArgumentException.class,
				() -> carrito.agregarProducto(99, List.of(digital, fisico)));
	}

}
