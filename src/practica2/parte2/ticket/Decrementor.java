package practica2.parte2.ticket;

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
			LockTicket.turn[i] = LockTicket.number.getAndAdd(1);
			while(LockTicket.turn[i] != LockTicket.next);
			//Critical section
				LockTicket.n--;
			//Exit protocol
			LockTicket.next++;
		}
	}

}
