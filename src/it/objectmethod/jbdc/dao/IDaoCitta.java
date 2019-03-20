package it.objectmethod.jbdc.dao;

import java.util.List;

import it.objectmethod.jbdc.model.Citta;

public interface IDaoCitta {


	public List<Citta> getCittaByCodiceNazione(String codiceNazione);
	public void eliminaCitta(int idCitta);
	public List<Citta> RicercaTotale(String codiceNazione,int maxPopolazioneInt,int minPopolazioneInt,int boxCapitaliInt,String nomeCitta);

}
