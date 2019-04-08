package practica2.parte2.bakery;

import java.util.concurrent.atomic.AtomicInteger;

public class LockBakery {

	public static int n = 0;
	public static int numProcesses;
	volatile public static int [] turn;
	volatile public static AtomicInteger number = new AtomicInteger(1);
	volatile public static int next = 1;
	
	public static void main(String [] args) throws InterruptedException {
		
		int N = 10;
		int M = 10;
		numProcesses = 2*M;
		turn = new int[2*M + 1];
		
		Decrementor [] dcs = new Decrementor[M];
		Incrementor [] ics = new Incrementor[M];
		
		for(int i = 0; i <= 2*M; i++) {
			turn[i] = 0;
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
	
	public static int max(int [] turn) {
		int result = turn[1];
		for(int i = 2; i <= numProcesses; i++) {
			if (result < turn[i])
				result = turn[i];
		}
		return result;
	}
	
	public static boolean mayor(int a, int b, int c, int d) {
		if(a > c) return true;
		else if (a == c && b > d) return true;
		else return false;
	}
}