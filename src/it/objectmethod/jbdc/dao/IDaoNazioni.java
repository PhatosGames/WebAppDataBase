package it.objectmethod.jbdc.dao;

import java.util.List;

import it.objectmethod.jbdc.model.Nazione;

public interface IDaoNazioni {

	public List<Nazione> getAllNazioni(String chiavenat);

}
