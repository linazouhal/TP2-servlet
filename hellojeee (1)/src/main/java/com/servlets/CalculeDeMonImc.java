package com.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import com.metier.IMC;



@WebServlet("/CalculeDeMonImc")
public class CalculeDeMonImc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculeDeMonImc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 response.setContentType("text/html");
		    PrintWriter out = response.getWriter();

		    String poidsParam = request.getParameter("poids");
		    String tailleParam = request.getParameter("taille");

		    double poids = Double.parseDouble(poidsParam);
		    double taille = Double.parseDouble(tailleParam);

		    
		    IMC imcObjet = new IMC(taille, poids);

		    double resultat = imcObjet.calcul();

		    out.println("<html><body>");
		    out.println("<h1>Résultat IMC</h1>");
		    out.println("<p>IMC = " + resultat + "</p>");
		    out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        

       
        String poidsParam = request.getParameter("poids");
        String tailleParam = request.getParameter("taille");

        double poids = Double.parseDouble(poidsParam);
        double taille = Double.parseDouble(tailleParam);

        double imc = poids / (taille * taille);

        out.println("<!DOCTYPE html>");
        out.println("<html><head><meta charset='UTF-8'><title>IMC</title></head><body>");
        out.println("<h1>Résultat IMC</h1>");
        out.println("<p>Votre IMC est : " + imc + "</p>");
        out.println("</body></html>");
		doGet(request, response);
	}

}
