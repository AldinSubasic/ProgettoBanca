package it.unipv.sfw.conti;
import it.unipv.sfw.persona.Persona;

public class ContoWeb implements Conto {
	private TypeConti type;
	private String iban;
	private Persona p;
	private double saldo;
	private String password;

	
	public ContoWeb (TypeConti type, String iban, Persona p ){
		this.iban = iban;
		String cf = p.getCf();
		saldo = 0;
		this.password = "default";
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public String getIban() {
		return iban;
	}
	
	public double preleva (double a) {
		if (Math.abs(a) > saldo) {
			System.out.println("la quantità prelevata è maggiore del saldo");
			return 0;
		}
		else {
			saldo = saldo - a;
		};
		return saldo;
	}
	
	public double deposita (double a) {
		if (a > 0) {
			return saldo+=a;
		}
		else {
			System.out.println("Operazione non valida");
		};
		return saldo;
	}
}
