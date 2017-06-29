import java.sql.Date;
import java.util.ArrayList;

public class SistemaControlador {
	private ArrayList <Cliente> clientes = new ArrayList <Cliente>();
	private ArrayList <Contrato> contratos = new ArrayList <Contrato>();
	private ArrayList <Cochera> cocheras = new ArrayList <Cochera>();

	public boolean verificarCliente(String dni){
		Cliente cl = this.buscarCliente(dni);
		if(cl != null)
			return false;
		return true;		
	}

	private Cliente buscarCliente(String dni) {
		for(int i = 0; i < clientes.size(); i++){
			Cliente cli = clientes.get(i);
			if(cli.existeCliente(dni))
				return cli;				
		}
		return null;
	}	
	
	public void altaCliente(String nombre, String dni, String domicilio, String telefono, String mail){
		Cliente c = new Cliente(nombre, domicilio, telefono, mail, dni);
		clientes.add(c);		
	}
	
	public void bajaCliente(String dni){
		Cliente c = this.buscarCliente(dni);
		if(c != null){
			clientes.remove(c);
		}
	}
	
	public ClienteView mostrarCliente(String dni){
		Cliente c = this.buscarCliente(dni);
		if(c != null){
			ClienteView cv = c.crearVista();
			return cv;
		}
		return null;		
	}
	
	public void modificarCliente(String nombre, String dni, String domicilio, String telefono, String mail){
		Cliente c = this.buscarCliente(dni);
		if(c != null){
			c.setNombre(nombre);
			c.setDomicilio(domicilio);
			c.setTelefono(telefono);
			c.setMail(mail);
		}
	}
	
	public void altaAuto(String dni, String patente, String marca, String modelo, Date fechaEntrada){
		Cliente c = this.buscarCliente(dni);
		c.agregarAuto(patente, marca, modelo, fechaEntrada);	
	}
	
	public void altaEfectivo(String dni, String nombre){
		Cliente c = this.buscarCliente(dni);
		if(c != null){
			c.agregarEfectivo(nombre);
		}
	}
	
	public void altaCredito(String dni, String nombre, String entEmisora, String numero, Date fechaVen){
		Cliente c = this.buscarCliente(dni);
		if(c != null){
			c.agregarCredito(nombre, entEmisora, numero, fechaVen);
		}
	}
	
	public void altaCBU(String dni, String nombre, String entBancaria, String CBU){
		Cliente c = this.buscarCliente(dni);
		if(c != null){
			c.agregarCBU(nombre, entBancaria, CBU);
		}
	}
	
	public void bajaMediosPago(String dni, String nombre){
		Cliente c = this.buscarCliente(dni);
		if(c != null){
			c.eliminarMediosPago(nombre);
		}
	}
	
	public void altaContrato(Date fechaEm, Date fechaVen, String dni, String patente, int cochera, String mediopago){
		Cliente cl = this.buscarCliente(dni);
		if(cl != null){
			Auto au = cl.buscarAuto(patente);
			if(au != null){
				MediosPago mp = cl.buscarMediopago(mediopago);
				if(mp != null){
					Cochera coc = this.buscarCochera(cochera);
					if(coc != null){
						float importe = coc.calcularImporte(cochera);
						Contrato  c = new Contrato(fechaEm, fechaVen, cl, coc, au, importe, mp);
						contratos.add(c);
						coc.Reservada();
					}
				}
			}
		}
	}


	private Cochera buscarCochera(int cochera) {
		for(int i = 0; i < cocheras.size(); i++){
			Cochera coc = cocheras.get(i);
			if(coc.existeCochera(cochera))
				return coc;
		}
		return null;
	}
	
	public void bajaContrato(int numero){
		Contrato  c = this.buscarContrato(numero);
		if(c != null){
			contratos.remove(c);
			Cochera coc = c.getCochera();
			coc.Disponible();
		}
	}

	private Contrato buscarContrato(int numero) {
		for(int i = 0; i < contratos.size(); i++){
			Contrato c = contratos.get(i);
			if(c.existeContrato(numero))
				return c;
		}		
		return null;
	}
	
	public ContratoView mostrarContrato(int numero){
		Contrato c = this.buscarContrato(numero);
		if(c != null){
			ContratoView cv = c.crearVista();
			return cv;
		}
		return null;		
	}
	
	public void modificarContrato(Date fechaEmision, Date fechaVen, int numero, float importe){
		Contrato c = this.buscarContrato(numero);
		if(c != null){
			c.setfechaEmision(fechaEmision);
			c.setfechaVen(fechaVen);
			c.setNumero(numero);
			c.setImporte(importe);			
		}		
	}
	
	public void mostrarCocheras(){
		for(int i = 0; i < cocheras.size(); i++){
			Cochera c = cocheras.get(i);
			mostrarMapa(c);					
		}
	}
	
	private CocheraView mostrarMapa(Cochera c){
		return c.crearVista();
	}
	
	public void generarDeuda(){
		for(int i = 0; i < contratos.size(); i++){
			Contrato c = contratos.get(i);
			if(c.Vencimiento())
				c.generarDeuda();			
		}
	}
	
	public void bloquearCochera(){
		for(int i = 0; i < contratos.size(); i++){
			Contrato c = contratos.get(i);
			Cochera coc = c.cocheraVencida();
			if(coc != null)
				coc.BloquearCochera();
		}
	}
	
	public void procesarPago(int numero, float importe){
		Contrato c = this.buscarContrato(numero);
		c.procesarPago(importe, numero);
	}	
}
