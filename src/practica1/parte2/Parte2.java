package practica1.parte2;

public class Parte2 {

	public static int n = 0;
	
	public static void main(String [] args) throws InterruptedException {
		
		assert args.length == 2: "Debes especificar el valor de M";
		
		int N = Integer.parseInt(args[0]);
		int M = Integer.parseInt(args[1]);
		
		Decrementor [] dcs = new Decrementor[M];
		Incrementor [] ics = new Incrementor[M];
		
		for(int i = 0; i < M; i++) {
			dcs[i] = new Decrementor(N);
			ics[i] = new Incrementor(N);
			dcs[i].start();
			ics[i].start();
		}
		
		for(int i = 0; i < M; i++) {
			dcs[i].join();
			ics[i].join();
		}
		
		System.out.println("Todos los procesos han terminado.\nEl valor de n es: " + n);
		
	}
}
