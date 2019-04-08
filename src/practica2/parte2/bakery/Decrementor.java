package practica2.parte2.bakery;

public class Decrementor extends Thread {
	
	private int N;
	private int i;
	
	public Decrementor(int n, int i) {
		this.N = n;
		this.i = i;
	}
	
	public void run() {
		for(int veces = 0; veces < N; veces++) {
			//Entry protocol
			LockBakery.turn[i] = 1;
			LockBakery.turn[i] = LockBakery.max(LockBakery.turn) + 1;
			for(int j = 1; j <= N; j++) {
				if(j != i) {
					while(LockBakery.turn[j] != 0 && LockBakery.mayor(LockBakery.turn[i], i, LockBakery.turn[j], j));
				}
			}
			//Critical section
			LockBakery.n--;
			//Exit protocol
			LockBakery.turn[i] = 0;
		}
	}

}
