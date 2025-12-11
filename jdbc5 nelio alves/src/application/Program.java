package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;
import db.DbIntegrityException;

public class Program {

	public static void main(String[] args) {
		
		Connection conn = null;
		
		PreparedStatement st = null;
		
		try {
			conn = DB.getConnection();
			
			st = conn.prepareStatement("Delete from department "
					+ "where "
					+ "Id > ?");
			
			
			
			st.setInt(1, 2);
			
			int rowsAffected = st.executeUpdate();
			
			System.out.println("Done! ROWS AFFECTED " + rowsAffected);
		} catch(SQLException sqle) {
		throw new DbIntegrityException(sqle.getMessage());
		}
		finally {
			DB.closeStatement(st);
			
			DB.closeConnection();
		}
	}
}