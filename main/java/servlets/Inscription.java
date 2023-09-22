package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Sql;
import bean.User;

/**
 * Servlet implementation class Inscription
 */
@WebServlet("/Inscription")
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inscription() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/WEB-INF/Inscription.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String password = request.getParameter("mdp");
		
		User u =new User(name,password);
		
		//if(!u.getNom().equals(name)&&u.getPassword().equals(password)) {//Si l'utilisateur n'est pas dans la BDD
			
		ArrayList<String> identifiants = new ArrayList<>();
		ArrayList<User> utilisateurs = Sql.connection();
		for(User e: utilisateurs) {
			identifiants.add(e.getNom());
		}
		String bool="";
		if(!identifiants.contains(name)) {
		Sql.ajouterUtilisateur(u);
		bool="OK";
		}else {
			bool="f";

		}
		request.setAttribute("bool", bool);
		String id=u.getNom();
		
		request.setAttribute("utilisateurs", utilisateurs);
		request.setAttribute("id",id);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/Inscription.jsp").forward(request, response);
	}

}
