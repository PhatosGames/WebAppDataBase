package it.objectmethod.jbdc.dao;

import java.util.List;

import it.objectmethod.jbdc.model.Citta;

public interface IDaoCitta {

	public List<Citta> getAllCitta(String chiavecit);

}