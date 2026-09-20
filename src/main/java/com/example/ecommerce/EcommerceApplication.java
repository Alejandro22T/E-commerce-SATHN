package com.example.ecommerce;

import com.example.ecommerce.model.Carrito;
import com.example.ecommerce.model.Producto;
import com.example.ecommerce.model.Usuario;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcommerceApplication {

	public static void main(String[] args) {

		SpringApplication.run(EcommerceApplication.class, args);

		// --- PRUEBA DE FUNCIONAMIENTO ---
		System.out.println("\n=== INICIANDO PRUEBA DE E-COMMERCE ===");

		// 1. Crear Usuario
		Usuario usuario = new Usuario(1, "Juan Pérez", "juan@example.com", "pass123");
		System.out.println("Usuario creado: " + usuario.getNombre());

		// 2. Crear Productos
		Producto p1 = new Producto(2, "Laptop", "Laptop Gamer 16GB RAM", 1200.00, 5);
		Producto p2 = new Producto(3, "Mouse", "Mouse Inalámbrico", 25.50, 10);

		// 3. Agregar al Carrito
		Carrito carrito = new Carrito();
		carrito.agregarProducto(p1);
		carrito.agregarProducto(p2);

		System.out.println("Productos en carrito: " + carrito.getProductos().size());
		System.out.println("Total a pagar: $" + carrito.getTotal());

		// 4. Remover un producto
		carrito.removerProducto(3);
		System.out.println("Total tras remover Mouse: $" + carrito.getTotal());
	}

}
