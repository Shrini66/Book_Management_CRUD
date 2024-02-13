package in.shri.backend;

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
@WebServlet("/editurl")
public class EditContent extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EditContent() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/books","root","root");
			String name=request.getParameter("bookName");
			String edition=request.getParameter("bookEdition");
			float price=Float.parseFloat(request.getParameter("bookPrice"));
			int id=Integer.parseInt(request.getParameter("id"));
			PreparedStatement ps=con.prepareStatement("update bookdata set bookname=? , edition =?, price=? where id=?");
			ps.setString(1, name);
			ps.setString(2, edition);
			ps.setFloat(3, price);
			ps.setInt(4, id);
			int res=ps.executeUpdate();
			
			if(res>0) {
				response.sendRedirect("Register.jsp");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
