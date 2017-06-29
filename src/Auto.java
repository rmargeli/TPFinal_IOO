import java.util.Date;

public class Auto {
	private String patente;
	private String marca;
	private String modelo;
	private Date fechaEntrada;
	
	public Auto(String patente, String marca, String modelo, Date fechaEntrada){
		this.patente = patente;
		this.marca = marca;
		this.modelo = modelo;
		this.fechaEntrada = fechaEntrada;
	}

	public boolean existeAuto(String patente) {
		if(this.patente.equals(patente))
    		return true;
    	return false;
	}
	
}
