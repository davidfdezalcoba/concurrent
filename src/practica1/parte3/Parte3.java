package practica1.parte3;

public class Parte3 {
	
	static final int N = 4;

	public static void main(String [] args) throws InterruptedException {
		
		MiThread [] mt = new MiThread[N];
		
		int [][] M1 = new int [N][N];
		int [][] M2 = new int [N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				M1[i][j] = i;
				M2[i][j] = j;
			}
		}
		
		for(int i = 0; i < N; i ++) {
			mt[i] = new MiThread(M1[i], M2);
			mt[i].start();
		}
		
		for(MiThread i : mt)
			i.join();
		
		System.out.println("Todos los procesos han terminado\nEl resultado es: ");
		for(MiThread i : mt) {
			System.out.print("[ ");
			for(int j = 0; j < N; j++)
				System.out.print(i.getRes()[j] + " ");
			System.out.println("]");
		}
	}
}
