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
	public List<Citta> getAllCitta(String chiavecit) {

		List<Citta> list = new ArrayList<Citta>();
		PreparedStatement stmt = null;
		Connection conn = ConnectionManager.getConnection();
		
		try {


			String sql = "SELECT C.Name as citname , C.District as citcode , C.population as citpop" + 
					" FROM CITY C" + 
					" join country ON C.CountryCode=Country.Code" + 
					" Where country.name = ?"; //TODO non va bene usare come chiave il nome della nazione.

			stmt = conn.prepareStatement(sql);
			stmt.setString(1, chiavecit);
			
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Citta n = new Citta();
				n.setCitname(rs.getString("citname"));
				n.setCitcode(rs.getString("citcode"));
				n.setCitpop(rs.getInt("citpop"));
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

}
