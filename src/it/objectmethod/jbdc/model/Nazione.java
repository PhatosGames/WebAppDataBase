package it.objectmethod.jbdc.model;

public class Nazione {
	private String nomeNazione;
	public String codiceNazione;
	private int popolazioneNazione;
	public String getNomeNazione() {
		return nomeNazione;
	}
	public void setNomeNazione(String nomeNazione) {
		this.nomeNazione = nomeNazione;
	}
	public int getPopolazioneNazione() {
		return popolazioneNazione;
	}
	public void setPopolazioneNazione(int popolazioneNazione) {
		this.popolazioneNazione=popolazioneNazione;
	}
	public String getCodiceNazione() {
		return codiceNazione;
	}
	public void setCodiceNazione(String codiceNazione) {
		this.codiceNazione = codiceNazione;
	}
}

