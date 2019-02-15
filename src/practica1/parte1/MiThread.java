package practica1.parte1;

public class MiThread extends Thread {
	
	private String id;
	private int timeToSleep;

	public MiThread (String id, int t) {
		this.id = id;
		this.timeToSleep = t;
	}
	
	public void run() {
		System.out.println("Thread " + id + ": Soy el thread " + id);
		try {
			sleep(timeToSleep);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Thread " + id + ": He terminado.");
	}
}
