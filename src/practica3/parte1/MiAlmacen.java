package practica3.parte1;

public class MiAlmacen implements Almacen {
	
	private Producto producto;
	
	public MiAlmacen() {
		producto = null;
	}

	@Override
	public void almacenar(Producto producto) {
		this.producto = producto;
	}

	@Override
	public Producto extraer() {
		return this.producto;
	}

}
