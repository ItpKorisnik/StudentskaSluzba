package com.itp.studentskasluzba.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.itp.studentskasluzba.dto.Ciklus;
import com.itp.studentskasluzba.dto.OglasnaPloca;

public class OglasnaPlocaDAO {

	
	public static Vector<OglasnaPloca> getAll() {
		Vector<OglasnaPloca> retVal = new Vector<OglasnaPloca>();
		Connection conn = null;
		java.sql.PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT * FROM  oglasna_ploca";

		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next())
				retVal.add(new OglasnaPloca(rs.getInt(1), rs.getString(2)));
		} catch (SQLException e) {
			e.printStackTrace();
			DBUtilities.getInstance().showSQLException(e);
		} finally {
			ConnectionPool.getInstance().checkIn(conn);
			DBUtilities.getInstance().close(ps, rs);
		}
		return retVal;
	}
	
	
	public static boolean dodajOglasnaPloca(OglasnaPloca op) {
		boolean retVal = false;
		Connection conn = null;
		java.sql.PreparedStatement ps = null;

		String query = "INSERT INTO oglasna_ploca (oglasnaPloca) VALUES (?)";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setString(1, op.getOglasnaPloca());

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
	
	
	public static boolean azurirajOglasnaPloca(int plocaId, String oglasnaPloca) {
		boolean retVal = false;
		Connection conn = null;
		java.sql.PreparedStatement ps = null;

		String query = "UPDATE oglasna_ploca SET oglasna_ploca=? WHERE ploca_id=?";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setInt(1, plocaId);
			ps.setString(2, oglasnaPloca);
			

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
	
	
	public static boolean obrisiOglasnaPloca(int plocaId) {
		boolean retVal = false;
		Connection conn = null;
		java.sql.PreparedStatement ps = null;

		String query = "DELETE FROM oglasna_ploca WHERE ploca_id=?";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setInt(1, plocaId);

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
	
	
	public static Ciklus getById(int ogp) {
		Ciklus retVal = new Ciklus();
		Connection conn = null;
		java.sql.PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT * FROM  oglasna_ploca WHERE ploca_id=?";

		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setInt(1, ogp);
			rs = ps.executeQuery();

			while (rs.next()) {
				retVal.setCiklusId(rs.getInt(1));
				retVal.setNaziv(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			DBUtilities.getInstance().showSQLException(e);
		} finally {
			ConnectionPool.getInstance().checkIn(conn);
			DBUtilities.getInstance().close(ps, rs);
		}
		return retVal;
	}
	
	
}
