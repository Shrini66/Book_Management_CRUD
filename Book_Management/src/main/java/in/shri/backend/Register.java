package in.shri.backend;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/books","root","root");
			String name=request.getParameter("bookName");
			String edition=request.getParameter("edition");
			float price=Float.parseFloat(request.getParameter("price"));
			
			PreparedStatement ps=con.prepareStatement("insert into bookdata (bookname,edition,price) values (?,?,?)");
			ps.setString(1, name);
			ps.setString(2, edition);
			ps.setFloat(3, price);
			
			int res=ps.executeUpdate();
			if(res>0) {
				RequestDispatcher rd=request.getRequestDispatcher("list");
				rd.include(request, response);
			}else {
				out.print("Something went Wrong");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
