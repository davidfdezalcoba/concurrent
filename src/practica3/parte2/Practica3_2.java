package practica3.parte2;

import java.util.concurrent.Semaphore;

public class Practica3_2 {

	public static final int NUM_PRODUCTORES = 5;
	public static final int NUM_CONSUMIDORES = 10;
	public static final int NUM_PRODUCTOS = 500;
	public static final int TAM_ALMACEN = 10;
	public static Semaphore vacio, lleno, mutexc, mutexp;
	public static MiAlmacenN almacen = new MiAlmacenN(TAM_ALMACEN);

	public static void main(String[] args) {

		vacio = new Semaphore(TAM_ALMACEN);
		lleno = new Semaphore(0);
		mutexc = new Semaphore(1);
		mutexp = new Semaphore(1);
		Productor[] p = new Productor[NUM_PRODUCTORES];
		Consumidor[] c = new Consumidor[NUM_CONSUMIDORES];

		for (int i = 0; i < NUM_PRODUCTORES; i++) {
			p[i] = new Productor(NUM_PRODUCTOS/NUM_PRODUCTORES);
		}

		for (int i = 0; i < NUM_CONSUMIDORES; i++) {
			c[i] = new Consumidor(NUM_PRODUCTOS/NUM_CONSUMIDORES);
		}

		for (int i = 0; i < NUM_PRODUCTORES; i++) {
			p[i].start();
		}

		for (int i = 0; i < NUM_CONSUMIDORES; i++) {
			c[i].start();
		}

		for (int i = 0; i < NUM_PRODUCTORES; ++i) {
			try {
				p[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		for (int i = 0; i < NUM_CONSUMIDORES; ++i) {
			try {
				c[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Todos los procesos han terminado");
	}

}
