package com.sorm.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sorm.DTO.placeDTO;

public class clientDAO {

	public void close(PreparedStatement pstmt) throws SQLException {
		if (pstmt != null)
			pstmt.close();
	}

	public void closeAll(PreparedStatement pstmt, ResultSet rs) throws SQLException {
		if (pstmt != null)
			pstmt.close();

		if (rs != null)
			rs.close();
	}

	public List<String> signIn(Connection conn) throws SQLException {

		List<String> correctIdentify = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "select client_id as id, client_pw as pw from client";

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String id = rs.getNString("id");
				String pw = rs.getNString("pw");

				correctIdentify.add(id);
				correctIdentify.add(pw);

			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			closeAll(pstmt, rs);
		}

		return correctIdentify;

	}

	public boolean signUp(Connection conn, List<String> list) throws SQLException {
		boolean isCreated = true;
		PreparedStatement pstmt = null;

		try {
			String sql = "insert into client (client_no, client_id, client_pw, phone) "
					+ "values (memos_seq.nextval, ?, ?, ?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, list.get(0));
			pstmt.setNString(2, list.get(1));
			pstmt.setNString(3, list.get(2));

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			close(pstmt);
		}

		return isCreated;
	}

	public List<placeDTO> inspectPlaces(Connection conn) throws SQLException {

		List<placeDTO> resList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "select place_no, place_nm as name from place";

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int no = rs.getInt("place_no");
				String name = rs.getNString("name");

				placeDTO dto = new placeDTO(no, name);

				resList.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			closeAll(pstmt, rs);
		}

		return resList;
	}
}
