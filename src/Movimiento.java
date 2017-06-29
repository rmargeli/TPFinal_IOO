import java.util.Calendar;
import java.util.Date;

public class Movimiento {
	private float monto;
	private int nroContrato;
	private MediosPago mediopago;     
	private Date fecha;
	
	public Movimiento(float importe, int numero, MediosPago mp){              
		monto = -importe;
		nroContrato = numero;
		mediopago = mp;
		fecha = Calendar.getInstance().getTime();
	}
	
}
