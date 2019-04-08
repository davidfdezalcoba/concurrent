package practica3.parte2;

import practica3.parte1.Producto;

public class Productor extends Thread{
	
	private int N;

	public Productor(int N){
		this.N = N;
	}

	public void run() {
		for (int i = 0; i < N; i++) {
			try {
				Practica3_2.vacio.acquire();
				Practica3_2.mutexp.acquire();
				Practica3_2.almacen.almacenar(new Producto());
				Practica3_2.mutexp.release();
				Practica3_2.lleno.release();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
