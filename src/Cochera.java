
public abstract class Cochera {
	private int numero;
	private boolean disponibilidad;
	protected float precio;
	private int estado;
	
	public abstract float calcularImporte(int cochera);

	public boolean existeCochera(int cochera) {
		if(numero == cochera)
			return true;
		return false;
	}

	public void Reservada() {
		disponibilidad = false;		
	}

	public void Disponible() {
		disponibilidad = true;		
	}

	public void BloquearCochera() {
		estado = -1;		
	}

	public CocheraView crearVista() {
		CocheraView cv = new CocheraView(numero, disponibilidad, precio, estado);
		return cv;
	}
	
}
