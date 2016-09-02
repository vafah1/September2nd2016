package com.shoeclub;

import java.sql.*;
import java.util.ArrayList;

public class DAO {

	static final String JDBC_Driver = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/?user=root&autoReconnect=true&useSSL=false";
	static final String USER = "root";
	static final String PASSWORD = "root";

	static Connection CONN = null;
	static Statement STMT = null;
	static PreparedStatement PREP_STMT = null;
	static ResultSet RES_SET = null;
	
	public static final ArrayList<Shoe> ourshoes = new ArrayList<>();

	/**
	 *
	 * This method connects to the sql db
	 *
	 */
	public static void connToDB() {

		try {
			//needs to be here for TomCat to work
			Class.forName(JDBC_Driver);
			
			//connects to DB
			System.out.println("Trying to connect to the DB...");
			CONN = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			System.out.println("Connected to DB.");

			//failed connection
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Connection failed");
			e.printStackTrace();
		}

	}

	/**
	 *
	 * This method reads the shoe data from the database and prints it out
	 *
	 */
	public static void readFromDB() {

		//connecting to the database
		connToDB();

		try {
			//prepares query to get data from db
			PREP_STMT = CONN.prepareStatement("SELECT * FROM shoe_club.shoe_closet;");
			
			//running the statement that actually gets the shoes from the db
			RES_SET = PREP_STMT.executeQuery();

			//looping over all shoes returned from the db
			while (RES_SET.next()) {

				//making empty instance of shoe
				Shoe shoeInDB = new Shoe();
				
				//set all the properties on the shoe with the data from the databse
				shoeInDB.setShoeID(RES_SET.getInt("shoe_id"));
				shoeInDB.setManufacturer(RES_SET.getString("manufacturer"));
				shoeInDB.setShoeType(RES_SET.getString("shoe_type"));
				shoeInDB.setShoeSize(RES_SET.getDouble("shoe_size")); 
				shoeInDB.setShoePrice(RES_SET.getDouble("shoe_price"));

				//add each shoe into the ourshoes array
				ourshoes.add(shoeInDB);

			}

			//for every shoes in the ourshoes array print out the shoe
			for(Shoe shoe : ourshoes) {
				System.out.println(shoe);
			}
		
		} catch (SQLException e) {
			//error msg if i had an issue with the database
			e.printStackTrace();
		}

	}

	/**
	 *
	 * writes an individual shoe to the database
	 *
	 * @param  shoe  The instance of shoe that we want to add to the database
	 */
	public static void writeToDatabase(Shoe shoe) {

		try {
			//connecting to DB
			connToDB();

			//setting up your query refer to line 103
			PREP_STMT = CONN.prepareStatement("INSERT INTO shoe_club.shoe_closet (manufacturer, shoe_type, shoe_size, shoe_price) VALUES (?,?,?,?);");

			//setting value of data and dropping it in order of query sequence 
			PREP_STMT.setString(1, shoe.getManufacturer());
			PREP_STMT.setString(2, shoe.getShoeType());
			PREP_STMT.setDouble(3, shoe.getShoeSize());
			PREP_STMT.setDouble(4, shoe.getShoePrice());
			
			//Prints our value of created shoe/ completed query
			System.out.println(PREP_STMT);
			
			//says run the query and input in db
			PREP_STMT.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}//write
	
	/**
	 *
	 * deletes an individual shoe from the database
	 *
	 * @param  shoeID  The id of the shoe to delete
	 */	
	public static void deleteFromDB(int shoeID){
		
		try
		{
			PREP_STMT = CONN.prepareStatement("DELETE FROM shoe_club.shoe_closet WHERE shoe_id = ?");
			
			PREP_STMT.setInt(1, shoeID);
			
			PREP_STMT.executeUpdate();
			
		} catch (SQLException e)
		{
			e.printStackTrace();
		} 
		
	}//delete
	
	/**
	 *
	 * updates info about pre-existing shoe in db
	 *
	 * @param  shoe  The instance of shoe that we want to update in the database
	 */
	public static void updateDatabase(Shoe shoe) {

		try {
			//connecting to DB
			connToDB();

			//setting up your query refer to line 103
			PREP_STMT = CONN.prepareStatement("UPDATE shoe_club.shoe_closet SET  manufacturer = ?, shoe_type = ?, shoe_size = ?, shoe_price = ? WHERE shoe_id = ?;");

			//setting value of data to be updated for selected shoe user wants to update 
			PREP_STMT.setString(1, shoe.getManufacturer());
			PREP_STMT.setString(2, shoe.getShoeType());
			PREP_STMT.setDouble(3, shoe.getShoeSize());
			PREP_STMT.setDouble(4, shoe.getShoePrice());
			PREP_STMT.setInt(5, shoe.getShoeID());
			
			//Prints our value of updated shoe/ completed query
			System.out.println(PREP_STMT);
			
			//says run the query and input update in db
			PREP_STMT.executeUpdate();

		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}//update


	

} // class
