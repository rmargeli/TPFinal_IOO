
public abstract class MediosPago {
	private String nombre;

	public MediosPago(String nombre) {
		this.nombre = nombre;
	}

	public boolean existeMediopago(String mediopago) {
		if(nombre.equals(mediopago))
			return true;
		return false;
	}

	
}
