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
 * Servlet implementation class updateShoe
 */
@WebServlet("/updateShoe")
public class updateShoe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateShoe() {
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
		addToDB.setShoeID(Integer.parseInt(request.getParameter("shoe_id")));
		
		DAO.updateDatabase(addToDB);
	}

}
