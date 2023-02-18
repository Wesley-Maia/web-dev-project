package br.com.connection;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		System.out.println("Example Connection Test");

		String query = "SELECT * FROM propriedade"; // query to be run

		// Step 1: Establishing a Connection
		Connection conn = ConnectionDB.connectPostGre();

		// Step 2:Create a statement using connection object
		// Step 3: Execute the query or update query
		// Step 4: Process the ResultSet object.
		Statement st;
		ResultSet rs;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				int id = rs.getInt("id");
				String descricao = rs.getString("descricao");
				String nome = rs.getString("nome");
				System.out.println(id + " / " + descricao + " / " + nome);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
					System.out.println("Close connection.");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
