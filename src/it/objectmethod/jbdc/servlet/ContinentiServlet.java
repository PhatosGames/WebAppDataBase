package it.objectmethod.jbdc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.jbdc.dao.IDaoContinenti;
import it.objectmethod.jbdc.dao.IDaoNazioni;
import it.objectmethod.jbdc.dao.impl.DaoContinenti;
import it.objectmethod.jbdc.dao.impl.DaoNazioni;
import it.objectmethod.jbdc.model.Continente;

public class ContinentiServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		IDaoNazioni daoNazioni = new DaoNazioni();
		IDaoContinenti daoContinenti = new DaoContinenti();

		List<Continente> list = daoContinenti.getAllContinenti();
		List<String> list2= daoNazioni.getAllCodici();

		request.setAttribute("continenti", list);
		request.setAttribute("codicenazione",list2);
		request.getRequestDispatcher("/TabContinenti.jsp").forward(request, response);

	}
}
