package practica1.parte3;

public class MiThread extends Thread {
	
	private int [] row;
	private int [][] matrix;
	private int [] res;
	
	public MiThread(int [] row, int [][] matrix) {
		this.row = row;
		this.matrix = matrix;
		this.res = new int[row.length];
	}
	
	public void run() {
		
		for(int i = 0; i < row.length; i++) {
			res[i] = 0;
			for(int j = 0; j < row.length; j++) {
				res[i] += row[j] * matrix[j][i];
			}
		}
	}
	
	public int [] getRes() {
		return this.res;
	}
	
}
