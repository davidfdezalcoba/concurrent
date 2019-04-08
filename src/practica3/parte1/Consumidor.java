package practica3.parte1;

public class Consumidor extends Thread {

	private int N;

	public Consumidor(int N) {
		this.N = N;
	}

	public void run() {
		for (int i = 0; i < N; i++) {
			try {
				Practica3_1.lleno.acquire();
				Practica3_1.mutexc.acquire();
				Practica3_1.almacen.extraer();
				Practica3_1.mutexc.release();
				Practica3_1.vacio.release();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
