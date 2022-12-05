package it.unipv.sfw.conti;

public interface Conto {
	public double getSaldo();
	public String getIban();
	public double preleva (double a);
	public double deposita(double a);
}
