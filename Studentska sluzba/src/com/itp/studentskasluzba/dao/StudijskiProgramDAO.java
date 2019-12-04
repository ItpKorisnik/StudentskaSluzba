package com.itp.studentskasluzba.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.itp.studentskasluzba.dto.Ciklus;
import com.itp.studentskasluzba.dto.StudijskiProgram;

public class StudijskiProgramDAO {

	
	public static Vector<StudijskiProgram> getAll() {
		Vector<StudijskiProgram> retVal = new Vector<StudijskiProgram>();
		Connection conn = null;
		java.sql.PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT * FROM  studijski_program";

		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next())
				retVal.add(new StudijskiProgram(rs.getInt(1), rs.getString(2), CiklusDAO.getById(rs.getInt(3))));
		} catch (SQLException e) {
			e.printStackTrace();
			DBUtilities.getInstance().showSQLException(e);
		} finally {
			ConnectionPool.getInstance().checkIn(conn);
			DBUtilities.getInstance().close(ps, rs);
		}
		return retVal;
	}

	
	
	public static boolean dodajStudijskiProgram(StudijskiProgram sp) {
		boolean retVal = false;
		Connection conn = null;
		java.sql.PreparedStatement ps = null;

		String query = "INSERT INTO studijski_program (naziv) VALUES (?)";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setString(1, sp.getNaziv());
			ps.setInt(1, sp.getCiklus(Ciklus.ciklus));
			retVal = ps.executeUpdate() == 1;
		} catch (SQLException e) {
			e.printStackTrace();
			DBUtilities.getInstance().showSQLException(e);
		} finally {
			ConnectionPool.getInstance().checkIn(conn);
			DBUtilities.getInstance().close(ps);
		}
		return retVal;
	}
	
	
}
