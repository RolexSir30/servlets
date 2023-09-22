package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class Sql {

	 static ArrayList<User> identifiants = new ArrayList<>();
	public static void main(String[] args) {
		
		for(User c :  connection())
		System.out.println(c.getNom()+" "+c.getPassword());
	}
	public static void bonjour() {
		System.out.println("hello");
	}
	
	public static ArrayList<String >a() {
		ArrayList<String > a =new ArrayList<>();
		a.add("bonjour");
	    return a;
	}
	
	
	public static   ArrayList<User> connection(){
			
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/book","root","");
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM livres");
            
			
			while(result.next()) {
				String id=result.getString("id");
				String password=result.getString("password");
				
				
				User s =new User();
				s.setNom(id);
				s.setPassword(password);
				identifiants.add(s);

			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		//System.out.println("id : "+identifiants);
		return identifiants;
		
		
		
	}
	
	public static void ajouterUtilisateur(User utilisateur) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		try {	Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/book","root","");

			PreparedStatement statement = c.prepareStatement("insert into livres values(?,?)");
			statement.setString(1, utilisateur.getNom());
            statement.setString(2, utilisateur.getPassword());
            statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
}
