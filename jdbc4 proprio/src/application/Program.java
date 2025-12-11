package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import db.DB;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Tell me the id to be removed");
		
		int id = sc.nextInt();
		
		Connection conn = null;
		
		PreparedStatement st = null;
		
		try {
			
			conn = DB.getConnection();
			
			st = conn.prepareStatement("delete from seller where id = " + id);
			
			int rowsAffected = st.executeUpdate();
			System.out.println("Done! Rows Affected " + rowsAffected);
			
		} catch (SQLException sqle) {
			sqle.getStackTrace();
		}
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}
}
