package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;

public class Program {

	public static void main(String[] args) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Connection conn = null;
		
		PreparedStatement st = null;
		try {
			conn = DB.getConnection();
			
			st = conn.prepareStatement(
					"INSERT INTO seller " + "(name, email, birthdate, basesalary, departmentId, id)" + "VALUES " + "(?, ?, ?, ?, ?, ?)");

			st.setString(1, "Carl purple");
			st.setString(2, "carl@gmail.com");
			st.setDate(3, new java.sql.Date(sdf.parse("22/04/1985").getTime()));
			st.setDouble(4, 5000.0);
			st.setInt(5, 4);
			st.setInt(6, 7);
			int rowsAffected = st.executeUpdate();
			System.out.println("Done! RowsAffected: " + rowsAffected);
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		catch (ParseException pe) {
			pe.printStackTrace();
		}
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}
}
