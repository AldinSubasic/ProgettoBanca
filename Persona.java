package it.unipv.sfw.persona;

public class Persona {
	private String cf;
	private String nome, cognome;
	
	
	//costruttore
	public Persona(String a, String b) {
		nome = a;
		cognome = b;
		cf = nome + cognome;
	}
	
	//metodi
	public String getCf () {
		return cf;
	}

}
