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
public class RicercaServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//salvataggio parametro da input utente
		try {
		String nomeCitta = request.getParameter("capitale");
		String boxCapitali= request.getParameter("checkbox");
		String codiceNazione= request.getParameter("countrycode");
		String maxPopolazione= request.getParameter("maxpopulation");
		String minPopolazione= request.getParameter("minpopulation");
		if (nomeCitta.isEmpty()!=true) {
			nomeCitta="%"+nomeCitta+"%";
		}
		else {
			nomeCitta="%%";
		}

		if (boxCapitali!= null) {
			boxCapitali="22";
		}else {
			boxCapitali="0";
		}

		if (maxPopolazione.isEmpty()==true){
			maxPopolazione="0";
		}
		if (minPopolazione.isEmpty()==true) {
			minPopolazione="0";
		}
		int maxPopolazioneInt = Integer.parseInt(maxPopolazione);
		int minPopolazioneInt = Integer.parseInt(minPopolazione);
		int boxCapitaliInt = Integer.parseInt(boxCapitali);



			IDaoCitta daoCitta = new DaoCitta();
			List<Citta> list = daoCitta.RicercaTotale(codiceNazione,maxPopolazioneInt,minPopolazioneInt,boxCapitaliInt,nomeCitta);
			request.setAttribute("citta", list);
			request.getRequestDispatcher("/TabCitta.jsp").forward(request, response);



		} catch (Exception e) {

			e.printStackTrace();
		}



	}
}
