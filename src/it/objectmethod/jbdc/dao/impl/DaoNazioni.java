package it.objectmethod.jbdc.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

import it.objectmethod.jbdc.config.ConnectionManager;
import it.objectmethod.jbdc.dao.IDaoNazioni;
import it.objectmethod.jbdc.model.Nazione;

public class DaoNazioni implements IDaoNazioni {


	@Override
	public List<Nazione> getAllNazioni(String codiceContinente) {

		List<Nazione> list = new ArrayList<Nazione>();
		PreparedStatement stmt = null;
		Connection conn = ConnectionManager.getConnection();

		try {


			String sql = "SELECT c.Name as nomeNazione, c.Population as popolazioneNazione, c.Code as CountryCode" + 
					" From country c" + 
					" Where c.Continent = ?";

			stmt = conn.prepareStatement(sql);
			stmt.setString(1, codiceContinente);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Nazione n = new Nazione();
				n.setNomeNazione(rs.getString("nomeNazione"));
				n.setCodiceNazione(rs.getString("CountryCode"));
				n.setPopolazioneNazione(rs.getInt("popolazioneNazione"));

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
	public List<String> getAllCodici() {

		List<String> list = new ArrayList<String>();
		Statement stmt = null;
		Connection conn = ConnectionManager.getConnection();

		try {


			String sql = "Select C.Code" + 
					" FROM Country C ";

			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				String c =new String();
				c=(rs.getString("Code"));

				list.add(c);
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
