package com.shoeservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoeclub.DAO;
import com.shoeclub.Shoe;

/**
 * Servlet implementation class addToDB
 */
@WebServlet("/addToDB")
public class addToDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addToDB() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Shoe addToDB = new Shoe();
		
		addToDB.setManufacturer(request.getParameter("manufacturer"));
		addToDB.setShoeType(request.getParameter("shoe_type"));
		addToDB.setShoeSize(Double.parseDouble(request.getParameter("shoe_size")));
		addToDB.setShoePrice(Double.parseDouble(request.getParameter("shoe_price")));
		
		DAO.writeToDatabase(addToDB);
		
		request.getRequestDispatcher("index.html").forward(request, response);
	}

}
