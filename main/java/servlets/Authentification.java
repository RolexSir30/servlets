package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Sql;
import bean.User;

/**
 * Servlet implementation class Authentification
 */
@WebServlet("/Authentification")
public class Authentification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//request.setAttribute("er", null);

		this.getServletContext().getRequestDispatcher("/WEB-INF/Authentification.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String name =request.getParameter("name");
		String password=request.getParameter("mdp");
		request.setAttribute("name", name);
		request.setAttribute("password", password);
		
		Sql s =new Sql();
		
		//User users = new User(name,password);
		//request.setAttribute("utilisateurs",Sql.connection());

		String ya="Pas dans la BDD";
		String su="Pas dans la BDD";
		for(User u :s.connection()) {
			if(u.getNom().equals(name)&&u.getPassword().equals(password)) {
				
				su="Utilisateur Connu";
			};
		}
		ya=su;
		if(ya.equals("Utilisateur Connu")) {
			
			HttpSession session = request.getSession();
			session.setAttribute("name", name);
			this.getServletContext().getRequestDispatcher("/WEB-INF/Livre.jsp").forward(request, response);

		}else {
	
			this.getServletContext().getRequestDispatcher("/WEB-INF/Authentification.jsp").forward(request, response);
            
		}
		
	
		request.setAttribute("utilisateurs",Sql.connection());
		
		
	}

}
