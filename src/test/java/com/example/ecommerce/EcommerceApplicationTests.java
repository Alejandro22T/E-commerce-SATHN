package com.example.ecommerce;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.ecommerce.model.Carrito;
import com.example.ecommerce.model.ProductoDigital;
import com.example.ecommerce.model.ProductoFisico;
import com.example.ecommerce.model.Producto;
import com.example.ecommerce.model.Usuario;

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

	@Test
	void modelosRechazanDatosInvalidosDesdeConstructoresYMutadores() {
		Producto producto = new Producto(1, "Teclado", "Mecánico", 25.00, 5);
		Usuario usuario = new Usuario(1, "Ana", "ana@example.com", "secreto");

		assertThrows(IllegalArgumentException.class, () -> producto.setPrecio(-1));
		assertThrows(IllegalArgumentException.class, () -> producto.setPrecio(Double.NaN));
		assertThrows(IllegalArgumentException.class, () -> producto.setStock(-1));
		assertThrows(IllegalArgumentException.class,
				() -> new Producto(1, " ", "Descripción", 1, 1));
		assertThrows(IllegalArgumentException.class, () -> usuario.setCorreoElectronico("correo-invalido"));
		assertThrows(IllegalArgumentException.class,
				() -> new Usuario(1, "Ana", "correo-invalido", "secreto"));
		assertThrows(IllegalArgumentException.class,
				() -> new ProductoFisico(2, "Mesa", "Madera", 10, 1, -1.0, 10.0));
		assertThrows(IllegalArgumentException.class,
				() -> new ProductoDigital(3, "Libro", "E-book", 5, 1, "Personal", "ftp://ejemplo.com"));
	}

	@Test
	void carritoProtegeSuListaYActualizaTotalAlCambiarPrecio() {
		Producto producto = new Producto(1, "Teclado", "Mecánico", 25.00, 5);
		Carrito carrito = new Carrito();
		carrito.agregarProducto(producto);

		assertThrows(UnsupportedOperationException.class,
				() -> carrito.getProductos().clear());
		assertEquals(25.00, carrito.getTotal(), 0.001);

		producto.setPrecio(30.00);

		assertEquals(30.00, carrito.getTotal(), 0.001);
		assertEquals(1, carrito.getProductos().size());
	}

}
