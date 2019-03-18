package it.objectmethod.jbdc.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.objectmethod.jbdc.config.ConnectionManager;
import it.objectmethod.jbdc.dao.IDaoNazioni;
import it.objectmethod.jbdc.model.Nazione;

public class DaoNazioni implements IDaoNazioni {
	

	@Override
	public List<Nazione> getAllNazioni(String chiavenat) {

		List<Nazione> list = new ArrayList<Nazione>();
		Statement stmt = null;
		Connection conn = ConnectionManager.getConnection();
		
		try {


			String sql = "SELECT c.Name as natname, c.population as natpop" + 
					" From Country c" + 
					" Where c.Continent ='"+chiavenat+"'";

			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Nazione n = new Nazione();
				n.setNatname(rs.getString("natname"));
				n.setNatpop(rs.getInt("natpop"));
				
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
