package it.objectmethod.jbdc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.jbdc.dao.IDaoContinenti;
import it.objectmethod.jbdc.dao.impl.DaoContinenti;
import it.objectmethod.jbdc.model.Continente;

public class QueryInizialeServlet  extends HttpServlet { //TODO nome servlet non va bene


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		IDaoContinenti daoContinenti = new DaoContinenti();
		List<Continente> list = daoContinenti.getAllContinenti();
		request.setAttribute("continenti", list);
		request.getRequestDispatcher("/TabContinenti.jsp").forward(request, response);

	}
}
