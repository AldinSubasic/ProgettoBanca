package it.unipv.sfw.conti;

import it.unipv.sfw.persona.Persona;

public class ContoDeposito implements Conto{
	private TypeConti type;
	private String iban;
	private Persona p;
	private double saldo;
	
	public ContoDeposito (TypeConti type, String iban, Persona p ){
		this.iban = iban;
		String cf = p.getCf();
		saldo = 0;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public String getIban() {
		return iban;
	}
	
	public double preleva (double a) {
		System.out.println("Operazion non valida");
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
