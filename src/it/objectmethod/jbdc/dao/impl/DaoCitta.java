package it.objectmethod.jbdc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.objectmethod.jbdc.config.ConnectionManager;
import it.objectmethod.jbdc.dao.IDaoCitta;
import it.objectmethod.jbdc.model.Citta;

public class DaoCitta implements IDaoCitta {


	@Override
	public List<Citta> getCittaByCodiceNazione(String codiceNazione) {

		List<Citta> list = new ArrayList<Citta>();
		PreparedStatement stmt = null;
		Connection conn = ConnectionManager.getConnection();

		try {
			//ricerca citta' per nazione

			String sql = "SELECT C.Name , C.District  , C.Population , C.CountryCode , C.ID " + 
					" FROM city C" + 
					" join country ON C.CountryCode=Country.Code" + 
					" Where C.CountryCode = ?";

			stmt = conn.prepareStatement(sql);
			stmt.setString(1, codiceNazione);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Citta n = new Citta();
				n.setNomeCitta(rs.getString("Name"));
				n.setCodiceCitta(rs.getString("District"));
				n.setPopolazioneCitta(rs.getInt("Population"));
				n.setCodiceNazione(rs.getString("CountryCode"));
				n.setIdCitta(rs.getInt("ID"));

				list.add(n);
			}

			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException se2) {
				se2.printStackTrace();
			}
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		return list;
	}

	
	@Override
	public void eliminaCitta(int IdCitta){


		PreparedStatement stmt = null;
		Connection conn = ConnectionManager.getConnection();

		try {
			//eliminazione citta'
			String sql = "Delete from city where city.id= ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, IdCitta);
			stmt.executeUpdate();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException se2) {
				se2.printStackTrace();
			}
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

	}

        public List<Citta> RicercaTotale(String codiceNazione,int maxPopolazioneInt,int minPopolazioneInt,int boxCapitaliInt,String nomeCitta) {
		List<Citta> list = new ArrayList<Citta>();
		PreparedStatement stmt = null;
		Connection conn = ConnectionManager.getConnection();

		try {
			//ricerca per nome

			String sql = "SELECT C.Name , C.District  , C.Population , C.CountryCode , C.ID"
					+" from city c"
					+" join country ON C.CountryCode=Country.Code"
					+" where c.CountryCode =?"
					+" and (c.Population > ? or ?=0)"
					+" and (c.Population < ? or ?=0)"
					+" and (c.ID = country.Capital or ?=0)"
					+" and c.Name like ?"; 

			stmt = conn.prepareStatement(sql);
			stmt.setString(1, codiceNazione);
			stmt.setInt(2, minPopolazioneInt);
			stmt.setInt(3, minPopolazioneInt);
			stmt.setInt(4, maxPopolazioneInt);
			stmt.setInt(5, maxPopolazioneInt);
			stmt.setInt(6, boxCapitaliInt);
			stmt.setString(7, nomeCitta);


			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Citta n = new Citta();
				n.setNomeCitta(rs.getString("Name"));
				n.setCodiceCitta(rs.getString("District"));
				n.setPopolazioneCitta(rs.getInt("Population"));
				n.setCodiceNazione(rs.getString("CountryCode"));
				n.setIdCitta(rs.getInt("ID"));

				list.add(n);
			}

			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException se2) {
				se2.printStackTrace();
			}
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		return list;}



}