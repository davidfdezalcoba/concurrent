package practica1.parte1;

public class Parte1 {
	
	public static void main(String [] args) throws InterruptedException {
		
		assert args.length == 2: "Debes especificar N y T";
		
		MiThread [] threads = new MiThread[Integer.parseInt(args[0])];
		
		for (int i = 0; i < Integer.parseInt(args[0]); i++) {
			threads[i] = new MiThread("" + i, Integer.parseInt(args[1]));
			threads[i].start();
		}
		
		for (MiThread mt : threads)
			mt.join();
		
		System.out.println("Principal: Todos los threads han terminado");
		
	}
}
