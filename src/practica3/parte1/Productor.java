package practica3.parte1;

public class Productor extends Thread{
	
	private int N;

	public Productor(int N){
		this.N = N;
	}

	public void run() {
		for (int i = 0; i < N; i++) {
			try {
				Practica3_1.vacio.acquire();
				Practica3_1.mutexp.acquire();
				Practica3_1.almacen.almacenar(new Producto());
				Practica3_1.mutexp.release();
				Practica3_1.lleno.release();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
