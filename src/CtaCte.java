import java.util.ArrayList;

public class CtaCte {
	private String estado;
	private float saldo;
	private ArrayList <Movimiento> movimientos;
	
	
	public CtaCte(String estado, float saldo){
		this.estado = estado;
		this.saldo = saldo;
		ArrayList <Movimiento> movimientos = new ArrayList <Movimiento>(); 
	}

	public void generarDeuda(float importe, int numero, MediosPago mp) {
		saldo = saldo - importe;
		Movimiento m = new Movimiento(importe, numero, mp);
		movimientos.add(m);				
	}

	public float getSaldo() {
		return saldo;
	}

	public void agregarMovimiento(float importe, int numero, MediosPago mediospago) {
		saldo = saldo + importe;
		Movimiento m = new Movimiento(importe, numero, mediospago);
		movimientos.add(m);		
	}
	
	

}
