package it.objectmethod.jbdc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.jbdc.dao.IDaoNazioni;
import it.objectmethod.jbdc.dao.impl.DaoNazioni;
import it.objectmethod.jbdc.model.Nazione;

public class NazioniServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String codiceNazione=request.getParameter("continente");

		IDaoNazioni daoNazioni = new DaoNazioni();
		List<Nazione> list = daoNazioni.getAllNazioni(codiceNazione);
		request.setAttribute("nazioni", list);
		request.getRequestDispatcher("/TabNazioni.jsp").forward(request, response);

	}
}
