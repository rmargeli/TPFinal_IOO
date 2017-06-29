import java.sql.Date;

public class ContratoView {
	private Date fechaEmision;
	private Date fechaVen;
	private Cliente cliente;
	private Cochera cochera;
	private Auto auto;
	private float importe;
	private int numero;	
	private MediosPago mediospago;  
	private CtaCte ctacte;
	
	public ContratoView(Date fechaEmision, Date fechaVen, Cliente cli, int numero, Cochera coc, Auto auto, float importe, MediosPago mp, CtaCte ctacte){
		this.fechaEmision = fechaEmision;
		this.fechaVen = fechaVen;
		cliente = cli;
		cochera = coc;
		this.numero = numero;
		this.auto = auto;
		this.importe = importe;
		mediospago = mp;
		this.ctacte = ctacte; 
	}
}
