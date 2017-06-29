import java.sql.Date;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class Contrato {
	private Date fechaEmision;
	private Date fechaVen;
	private Cliente cliente;
	private Cochera cochera;
	private Auto auto;
	private float importe;
	private int numero;
	private static int ultnro;
	private MediosPago mediospago;  
	private CtaCte ctacte;
	
	public Contrato(Date fechaEmision, Date fechaVen, Cliente cli, Cochera coc, Auto auto, float importe, MediosPago mp){
		this.fechaEmision = fechaEmision;
		this.fechaVen = fechaVen;
		cliente = cli;
		cochera = coc;
		this.auto = auto;
		this.importe = importe;
		numero = getUltnro();		
		mediospago = mp;
		ctacte = new CtaCte("OK", 0);
	}

	private static int getUltnro() {
		return ultnro++;
	}
	
	public void setfechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;		
	}

	public void setfechaVen(Date fechaVen) {
		this.fechaVen = fechaVen;		
	}

	public void setNumero(int numero) {
		this.numero = numero;		
	}

	public void setImporte(float importe) {
		this.importe = importe;		
	}
	
	public boolean existeContrato(int numero) {
		if(this.numero == numero)
			return true;
		return false;
	}

	public boolean Vencimiento() {
		Date hoy = (Date) Calendar.getInstance().getTime();
		if(hoy.after(fechaVen))
				return true;
		return false;
	}

	public void generarDeuda() {                                                       
		ctacte.generarDeuda(importe, numero, mediospago);		
	}

	public Cochera getCochera() {
		return cochera;
	}

	public Cochera cocheraVencida() {
		if(ctacte.getSaldo() < 0){
			Date hoy = (Date) Calendar.getInstance().getTime();
			if(diasDiferencia(fechaVen, hoy) > 15){
				return cochera;				
			}
		}
		return null;
	}
	
	private static long diasDiferencia(Date d1, Date d2) {
	    long diff = d2.getTime() - d1.getTime();
	    return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public MediosPago getMediosPago() {
		return mediospago;		
	}

	public void procesarPago(float importe, int numero) {
		ctacte.agregarMovimiento(importe, numero, mediospago);		
	}

	public ContratoView crearVista() {
		ContratoView cv = new ContratoView(fechaEmision, fechaVen, cliente, numero, cochera, auto, importe, mediospago, ctacte);
		return cv;
	}
	
}
