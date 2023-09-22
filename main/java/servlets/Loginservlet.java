package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogIn
 */

@WebServlet("/Loginservlet")
public class Loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	   public Loginservlet() {
	        super();
	        // TODO Auto-generated constructor stub
	    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());


		this.getServletContext().getRequestDispatcher("/WEB-INF/Loginservlet.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
        PrintWriter out = response.getWriter();

		String name=request.getParameter("name");
		String mdp=request.getParameter("password");

		if(name.equals("J2EE")&mdp.equals("J2EE")) {
			this.getServletContext().getRequestDispatcher("/WEB-INF/FormulaireURL.jsp").forward(request, response);

			String url=request.getParameter("url");
			response.sendRedirect(url);
		}else {
			out.println("Erreur de connection ! ");
		}
				
		
	}

}
