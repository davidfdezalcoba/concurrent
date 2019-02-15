package practica1.parte2;

public class Incrementor extends Thread {

	private int N;
	
	public Incrementor(int n) {
		this.N = n;
	}
	
	public void run() {
		for(int i = 0; i < N; i++)
		Parte2.n++;
	}
}
