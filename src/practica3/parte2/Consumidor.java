package practica3.parte2;

public class Consumidor extends Thread {

	private int N;

	public Consumidor(int N) {
		this.N = N;
	}

	public void run() {
		for (int i = 0; i < N; i++) {
			try {
				Practica3_2.lleno.acquire();
				Practica3_2.mutexc.acquire();
				Practica3_2.almacen.extraer();
				Practica3_2.mutexc.release();
				Practica3_2.vacio.release();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
