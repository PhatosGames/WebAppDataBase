package it.objectmethod.jbdc.dao;

import java.util.List;

import it.objectmethod.jbdc.model.Citta;

public interface IDaoCitta {

	public List<Citta> getAllCitta(String chiavecit); //TODO dare ai metodi nomi che siano espliciti, ad esempio getCittaByCodiceNazione

}
