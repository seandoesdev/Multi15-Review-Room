package com.sorm.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.sorm.DAO.clientDAO;
import com.sorm.DTO.placeDTO;

public class clientService {

	clientDAO dao = new clientDAO();

	public void close(Connection conn) throws Exception {
		if (conn != null)
			conn.close();
	}

	public clientService() throws Exception {
		try {
			Class.forName(config.driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public List<String> signIn() throws Exception {

		List<String> correctIdentify = null;
		boolean isCreated = false;
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(config.dbUrl, config.dbUsername, config.dbPassword);

			correctIdentify = dao.signIn(conn);

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			close(conn);
		}

		return correctIdentify;
	}

	public boolean signUp(List<String> list) throws Exception {

		boolean isNotCreated = false;
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(config.dbUrl, config.dbUsername, config.dbPassword);
			isNotCreated = dao.signUp(conn, list);

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			close(conn);
		}

		return isNotCreated;
	}

	public List<placeDTO> inspectPlaces() throws Exception {

		List<placeDTO> list = null;
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(config.dbUrl, config.dbUsername, config.dbPassword);
			list = dao.inspectPlaces(conn);

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			close(conn);
		}

		return list;
	}
}
