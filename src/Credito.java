import java.util.Date;

public class Credito extends MediosPago{
	private String entidadEmisora;
    private String numero;  
    private Date fechaVen;

	public Credito(String nombre, String entEmisora, String numero, Date fechaVen) {
		super(nombre);
		entidadEmisora = entEmisora;
		this.numero = numero;
		this.fechaVen = fechaVen;		
	}

}
