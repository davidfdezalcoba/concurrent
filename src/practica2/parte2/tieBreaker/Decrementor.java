package practica2.parte2.tieBreaker;

public class Decrementor extends Thread {
	
	private int N;
	private int i;
	
	public Decrementor(int n, int i) {
		this.N = n;
		this.i = i;
	}
	
	public void run() {
		for(int veces = 0; veces < N; veces++) {
			for(int j = 1; j <= LockRompeEmpate.numProcesses; j++) {
				// Remember process i is in stage j and is last
				LockRompeEmpate.last[j] = i; LockRompeEmpate.in[i] = j;
				for(int k = 1; k <= LockRompeEmpate.numProcesses; k++) {
					if (k != i) {
						//Wait if process k is in higher numbered stage and process i was the last to enter
						while(LockRompeEmpate.in[k] >= LockRompeEmpate.in[i] && LockRompeEmpate.last[j] == i);
					}
				}
			}
			//Critical section
			LockRompeEmpate.n--;
			//Exit protocol
			LockRompeEmpate.in[i] = 0;
		}
	}

}
