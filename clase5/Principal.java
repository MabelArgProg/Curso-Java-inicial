package clase5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

public class Principal {

	public static void main(String[] args) {
		String archivoEntrada = "Compras.txt";
		try {
			List<String> lista = Files.readAllLines(Paths.get(archivoEntrada));
			String[] datosProducto1 = lista.get(1).split(" "); //línea1 del archivo "40 jabón 123f.split(" ")==[40 jabón 123f]
			String[] datosProducto2 = lista.get(2).split(" ");
			String[] datosProducto3 = lista.get(3).split(" ");
			
			Producto producto1 = new Producto(datosProducto1[1], datosProducto1[2], Float.parseFloat(datosProducto1[0]));
			Producto producto2 = new Producto(datosProducto2[1], datosProducto2[2], Float.parseFloat(datosProducto2[0]));
			Producto producto3 = new Producto(datosProducto3[1], datosProducto3[2], Float.parseFloat(datosProducto3[0]));
			
			Carrito carrito = new Carrito (producto1, producto2, producto3,LocalDateTime.parse("2023-03-19T18:10:00"));
			
			Persona persona1 = new Persona("Lunita", "Perez", LocalDateTime.parse("2020-04-19T18:10:00"), carrito);
			
			Carrito unCarrito = persona1.getCarrito();
			
			Descuento desFijo = new DescuentoFijo(50);
			Descuento desPorcentaje = new DescuentoPorcentaje(0.10F);
			Descuento desPorcentajeConTope = new DescuentoPorcentajeConTope(0.30F);
			
			desPorcentajeConTope.setValorDesc(0.20f);
			
			float resultado = unCarrito.costoFinal(desPorcentajeConTope);
			
			System.out.println("El costo final es " + resultado);
			
		}catch (IOException e) {
			System.out.println("Ocurrió un error " + e);
		}
	}
}
