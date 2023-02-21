package com.training.ejb.simple.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.UUID;

import javax.ejb.Stateless;

import com.training.ejb.simple.SimpleDataSourceAccess;
import com.training.ejb.simple.util.DataSourceServiceFactory;

@Stateless(mappedName = "SimpleDataSourceAccessImpl", name = "SimpleDataSourceAccessImpl")
public class SimpleDataSourceAccessImpl implements SimpleDataSourceAccess {
	public boolean isConnected() {
		boolean isAbleToConnect = false;

		DataSourceServiceFactory dataSourceServiceFactory = new DataSourceServiceFactory();
		try {
			Connection connection = dataSourceServiceFactory.getConnection();
			if (!connection.isClosed()) {
				isAbleToConnect = true;
			}
			connection.close();
		} catch (SQLException e) {
			System.err.println("SQLException : " + e.getMessage());
		} catch (Exception e) {
			System.err.println("Exception : " + e.getMessage());
		}

		return isAbleToConnect;
	}

	public List<Hashtable<String, String>> getPesertaTraining() {
		List<Hashtable<String, String>> daftarPesertaTraining = new ArrayList<Hashtable<String, String>>();
		DataSourceServiceFactory dataSourceServiceFactory = new DataSourceServiceFactory();
		try {
			Connection conn = dataSourceServiceFactory.getConnection();
			String sqlSelectQuery = "select id, name, job_position, division from peserta_training";

			PreparedStatement preparedStatement = conn.prepareStatement(sqlSelectQuery);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String id = resultSet.getString("id");
				String name = resultSet.getString("name");
				String jobPosition = resultSet.getString("job_position");
				String division = resultSet.getString("division");

				Hashtable<String, String> row = new Hashtable<String, String>();
				row.put("id", id);
				row.put("name", name);
				row.put("jobPosition", jobPosition);
				row.put("division", division);
				daftarPesertaTraining.add(row);
			}
			preparedStatement.close();
			dataSourceServiceFactory.closeConnection();
		} catch (SQLException e) {
			System.err.println("SQLException : " + e.getMessage());
		} catch (Exception e) {
			System.err.println("Exception : " + e.getMessage());
		}
		return daftarPesertaTraining;

	}

	public void insertPesertaTraining(String name, String jobPosition, String division) {
		DataSourceServiceFactory dataSourceServiceFactory = new DataSourceServiceFactory();
		try {
			Connection conn = dataSourceServiceFactory.getConnection();
			String sqlInsertQuery = "insert into peserta_training(id, name, job_position, division) "
					+ "values(?,?,?,?)";

			PreparedStatement preparedStatement = conn.prepareStatement(sqlInsertQuery);
			preparedStatement.setString(1, UUID.randomUUID().toString().replace("-", ""));
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, jobPosition);
			preparedStatement.setString(4, division);

			preparedStatement.executeUpdate();
			preparedStatement.close();
			dataSourceServiceFactory.closeConnection();
		} catch (SQLException e) {
			System.err.println("SQLException : " + e.getMessage());
		} catch (Exception e) {
			System.err.println("Exception : " + e.getMessage());
		}
	}
}
