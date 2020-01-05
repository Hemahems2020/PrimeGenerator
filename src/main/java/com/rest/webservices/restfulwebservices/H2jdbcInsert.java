package com.rest.webservices.restfulwebservices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class H2jdbcInsert {
	public int insert(InsertBean insertbean) {
// JDBC driver name and database URL
		final String JDBC_DRIVER = "org.h2.Driver";
		final String DB_URL = "jdbc:h2:~/test";

		// Database credentials
		final String USER = "hema";
		final String PASS = "";

		Connection conn = null;
		Statement stmt = null;
		try {
			// STEP 1: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// STEP 2: Open a connection
			System.out.println("Connecting to a selected database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected database successfully...");

			SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");

			Date now = new Date();

			String strTime = sdfTime.format(now);

			// STEP 3: Execute a query
			stmt = conn.createStatement();
			String sql = "INSERT INTO Prime (Time,User,Upperlimit,LowerLimit,ElapsedTime,Algorithm,NoPrimeReturned) "
					+ "values ('" + strTime + "','" + insertbean.getUser() + "','" + insertbean.getUpperLimit() + "','"
					+ insertbean.getLowerLimit() + "','" + insertbean.ElapsedTime + "','" + insertbean.getAlgorithm()
					+ "'," + insertbean.getNoPrimeReturned() + ")";

			stmt.executeUpdate(sql);
			System.out.println("Inserted records into the table...");
			// STEP 4: Clean-up environment
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		System.out.println("Goodbye!");
		return 1;

	}
}