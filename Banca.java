package it.unipv.sfw.banca;
import java.util.HashMap;
import it.unipv.sfw.conti.*;
import it.unipv.sfw.persona.Persona;

public class Banca {
	private String nome;
	private int ContiAttivi;         			   
	private HashMap <String, Conto> elenco;
	private String Radice;

	
	//costruttore
	public Banca () {
		nome = "BancaPopolare";
		ContiAttivi = 0;
		Radice = "IT000";
		elenco = new HashMap<String, Conto>();
	}
	
	public Boolean aggConto (TypeConti type, Persona p) {
		boolean res = true;
		switch(type) {
			case CONTOCORRENTE:
				Conto c = new ContoCorrente(type, genIban(), p);
				elenco.put(genIban(), c);
				ContiAttivi++;
				break;
			case CONTODEPOSITO:
				Conto c2 = new ContoDeposito(type, genIban(), p);
				elenco.put(genIban(), c2);
				ContiAttivi++;
				break;
			case CONTOWEB:
				Conto c3 = new ContoWeb(type, genIban(), p);
				elenco.put(genIban(), c3);
				ContiAttivi++;
				break;
			default:
				res = false;
				return res;
		}
		return res;
	}
	
	
	public double operazioneBancaria (double a, ContoCorrente x) {
		double soldi = 0;
		if(a < 0) {
			soldi = x.preleva(a);
		}
		else if (a > 0) {
			soldi = x.deposita(a);
		}
		return soldi;
	}
	
	
	
	public double totSaldi () {
	    double tot = 0;
	    for(Conto a:elenco.values()) {
	    	tot += a.getSaldo();
	    }
	    return tot;
	}
	
	public Conto retConto(String iban) {
		Conto a = elenco.get(iban);
		return a;
	}
	
	public String genIban() {
		String iban = Radice + String.valueOf(ContiAttivi); 
		return iban;
	}
	
}
