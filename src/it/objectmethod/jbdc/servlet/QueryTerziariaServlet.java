package it.objectmethod.jbdc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.jbdc.dao.IDaoCitta;
import it.objectmethod.jbdc.dao.impl.DaoCitta;
import it.objectmethod.jbdc.model.Citta;
public class QueryTerziariaServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//salvataggio parametro da input utente
		String chiavecit=request.getParameter("nazione").toString();

		IDaoCitta daoCitta = new DaoCitta();
		List<Citta> list = daoCitta.getAllCitta(chiavecit);
		request.setAttribute("citta", list);
		request.getRequestDispatcher("/TabCitta.jsp").forward(request, response);
	}
}
