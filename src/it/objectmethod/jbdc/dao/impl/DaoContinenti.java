package it.objectmethod.jbdc.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.objectmethod.jbdc.config.ConnectionManager;
import it.objectmethod.jbdc.dao.IDaoContinenti;
import it.objectmethod.jbdc.model.Continente;

public class DaoContinenti implements IDaoContinenti {

	@Override
	public List<Continente> getAllContinenti() {

		List<Continente> list = new ArrayList<Continente>();
		Statement stmt = null;
		Connection conn = ConnectionManager.getConnection();
		try {
			
			String sql = "SELECT C.continent" + 
					" FROM country C\r\n" + 
					" GROUP BY C.Continent";

			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Continente n = new Continente();
				n.setContinent(rs.getString("continent"));
//				n.setPop(rs.getLong("pop"));
				
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
