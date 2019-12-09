package com.itp.studentskasluzba.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import com.itp.studentskasluzba.dto.Predmet;

public class PredmetDAO {

	public static Vector<Predmet> getAll() {
		Vector<Predmet> retVal = new Vector<Predmet>();
		Connection conn = null;
		java.sql.PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT * FROM  predmet";

		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next())
				retVal.add(new Predmet(rs.getInt(1), rs.getString(2), rs.getBoolean(3),rs.getInt(4)));
		} catch (SQLException e) {
			e.printStackTrace();
			DBUtilities.getInstance().showSQLException(e);
		} finally {
			ConnectionPool.getInstance().checkIn(conn);
			DBUtilities.getInstance().close(ps, rs);
		}
		return retVal;
	}
	
	
	public static boolean dodajPredmet(Predmet pred) {
		boolean retVal = false;
		Connection conn = null;
		java.sql.PreparedStatement ps = null;

		String query = "INSERT INTO predmet (naziv,obavezanPredmet,ects) VALUES (?,?,?)";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setString(1, pred.getNaziv());
			ps.setBoolean(2, pred.isObavezanPredmet());
			ps.setInt(3, pred.getEcts());
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
	
	
	
	public static boolean azurirajPredmet(int predmetId, String naziv, boolean obavezanPredmet, int ects) {
		boolean retVal = false;
		Connection conn = null;
		java.sql.PreparedStatement ps = null;

		String query = "UPDATE predmet SET naziv=?,obavezanPredmet=?,ects=? WHERE predmetId=?";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setInt(1, predmetId);
			ps.setString(2, naziv);
			ps.setBoolean(3, obavezanPredmet);
			ps.setInt(4, ects);
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
	
	
	
	public static boolean obrisiPredmet(int predmetId) {
		boolean retVal = false;
		Connection conn = null;
		java.sql.PreparedStatement ps = null;

		String query = "DELETE FROM predmet WHERE predmetId=?";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setInt(1, predmetId);

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
	
	
	
	
	public static Predmet getById(int predmetic) {
		Predmet retVal = new Predmet();
		Connection conn = null;
		java.sql.PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT * FROM  predmet WHERE predmetId=?";

		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setInt(1, predmetic);
			rs = ps.executeQuery();

			while (rs.next()) {
				retVal.setPredmetId(rs.getInt(1));
				retVal.setNaziv(rs.getString(2));
				retVal.setObavezanPredmet(rs.getBoolean(3));
				retVal.setEcts(rs.getInt(4));
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
