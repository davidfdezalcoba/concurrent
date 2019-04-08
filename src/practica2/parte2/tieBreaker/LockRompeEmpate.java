package practica2.parte2.tieBreaker;

public class LockRompeEmpate {

	public static int n = 0;
	public static int numProcesses;
	volatile public static int [] in;
	volatile public static int [] last;
	
	public static void main(String [] args) throws InterruptedException {
		
		int N = 3500;
		int M = 10;
		numProcesses = 2*M;
		
		Decrementor [] dcs = new Decrementor[M];
		Incrementor [] ics = new Incrementor[M];
		in = new int[2*M + 1];
		last = new int[2*M + 1];
		
		for(int i = 0; i <= 2*M; i++) {
			in[i] = 0;
			last[i] = 0;
		}
		
		for(int i = 0; i < M; i++) {
			ics[i] = new Incrementor(N, 2*i + 1);
			dcs[i] = new Decrementor(N, 2*i + 2);
		}
		
		for(int i = 0; i < M; i++) {
			ics[i].start();
			dcs[i].start();
		}
		
		for(int i = 0; i < M; i++) {
			ics[i].join();
			dcs[i].join();
		}
	
		System.out.println("Todos los procesos han terminado.\nEl valor de n es: " + n);
		
	}
}