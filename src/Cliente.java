import java.util.Date;
import java.util.ArrayList;

public class Cliente {
	private String nombre;
	private String domicilio;
	private String telefono;
	private String mail;
	private String dni;
	private ArrayList <Auto> autos;
	private ArrayList <MediosPago> mediospago;

	
	public Cliente(String nombre, String domicilio, String telefono, String mail, String dni){
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.mail = mail;
		this.dni = dni;
		ArrayList <Auto> autos = new ArrayList <Auto>();
		ArrayList <MediosPago> mediospago = new ArrayList <MediosPago>();
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;		
	}
	
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;		
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;		
	}
	
	public void setMail(String mail) {
		this.mail = mail;		
	}

	public boolean existeCliente(String dni) {
		if(this.dni.equals(dni)){
    		return true;
    	}
    	return false;
	}

	public void agregarAuto(String patente, String marca, String modelo, Date fechaEntrada){
		Auto a = new Auto(patente, marca, modelo, fechaEntrada);
		autos.add(a);		
	}

	public Auto buscarAuto(String patente) {
		for(int i = 0; i < autos.size(); i++){
			Auto a = autos.get(i);
			if(a.existeAuto(patente))
				return a;		
		}
		return null;
	}

	public MediosPago buscarMediopago(String mediopago) {
		for(int i = 0; i < mediospago.size(); i++){
			MediosPago mp = mediospago.get(i);
			if(mp.existeMediopago(mediopago))
				return mp;
		}		
		return null;
	}

	public void agregarEfectivo(String nombre) {
		Efectivo e = new Efectivo(nombre);
		mediospago.add(e);		
	}

	public void agregarCredito(String nombre, String entEmisora, String numero, Date fechaVen) {
		Credito c = new Credito(nombre, entEmisora, numero, fechaVen);
		mediospago.add(c);		
	}

	public void agregarCBU(String nombre, String entBancaria, String CBU) {
		CBU cbu = new CBU(nombre, entBancaria, CBU);
		mediospago.add(cbu);		
	}

	public void eliminarMediosPago(String nombre) {
		MediosPago mp = this.buscarMediopago(nombre);
		mediospago.remove(mp);		
	}

	public ClienteView crearVista() {
		ClienteView cv = new ClienteView(nombre, domicilio, telefono, mail, dni);
		return cv;
	}

	

}
