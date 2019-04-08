package practica3.parte2;

import practica3.parte1.Producto;
import practica3.parte1.Almacen;

public class MiAlmacenN implements Almacen {

	private Producto[] productos;
	private int tamaño;
	public int insertIn; // Lugar en el que insertar el proximo elemento
	public int inserted; // Lugar en el que insertar el proximo elemento
	public int extracted; // Lugar en el que insertar el proximo elemento
	public int extractFrom; // Lugar en el que insertar el proximo elemento

	public MiAlmacenN(int tamaño) {
		productos = new Producto[tamaño];
		this.tamaño = tamaño;
		this.inserted = 0;
		this.extracted = 0;
		this.insertIn = 0;
		this.extractFrom = 0;
	}

	@Override
	public void almacenar(Producto producto) {
		if (inserted - extracted < tamaño) { // queda hueco para el siguiente producto
			productos[insertIn] = producto;
			insertIn = (insertIn + 1) % tamaño;
			inserted = inserted + 1;
		} else {
			System.out.println("No se puede insertar");
		}
	}

	@Override
	public Producto extraer() {
		Producto dev = null;
		if (inserted - extracted > 0) { // hay algun producto
			dev = productos[extractFrom];
			extractFrom = (extractFrom + 1) % tamaño;
			extracted = extracted + 1;
		} else {
			System.out.println("Error al extraer, no hay ningun elemento");
		}
		return dev;
	}

}
