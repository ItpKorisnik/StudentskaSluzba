package com.itp.studentskasluzba.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.itp.studentskasluzba.dto.Ciklus;
import com.itp.studentskasluzba.dto.Nastavnik;

public class NastavnikDAO {

	public static Vector<Nastavnik> getAll() {
		Vector<Nastavnik> retVal = new Vector<Nastavnik>();
		Connection conn = null;
		java.sql.PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT * FROM  nastavnik";

		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next())
				retVal.add(new Nastavnik(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
		} catch (SQLException e) {
			e.printStackTrace();
			DBUtilities.getInstance().showSQLException(e);
		} finally {
			ConnectionPool.getInstance().checkIn(conn);
			DBUtilities.getInstance().close(ps, rs);
		}
		return retVal;
	}
	
	
	public static boolean dodajNastavnika(Nastavnik ns) {
		boolean retVal = false;
		Connection conn = null;
		java.sql.PreparedStatement ps = null;

		String query = "INSERT INTO nastavnik (naziv, prezime, zvanje) VALUES (?,?,?)";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setString(1, ns.getIme());
			ps.setString(1, ns.getPrezime());
			ps.setString(1, ns.getZvanje());
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
	
	
	public static boolean azurirajNastavnik(int nastavnikId,String ime, String prezime, String zvanje) {
		boolean retVal = false;
		Connection conn = null;
		java.sql.PreparedStatement ps = null;

		String query = "UPDATE nastavnik SET ime=?, prezime=?, zvanje=? WHERE id_ciklus=?";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setInt(1, nastavnikId);
			ps.setString(2, ime);
			ps.setString(3, prezime);
			ps.setString(3, zvanje);
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
	
	
	public static boolean obrisiNastavnik(int nastavnikId) {
		boolean retVal = false;
		Connection conn = null;
		java.sql.PreparedStatement ps = null;

		String query = "DELETE FROM nastavnik WHERE nastavnikId=?";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setInt(1, nastavnikId);

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
	
	
	
	public static Nastavnik getById(int nas) {
		Nastavnik retVal = new Nastavnik();
		Connection conn = null;
		java.sql.PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT * FROM  nastavnik WHERE nastavnikId=?";

		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setInt(1, nas);
			rs = ps.executeQuery();

			while (rs.next()) {
				retVal.setNastavnikId(rs.getInt(1));
				retVal.setIme(rs.getString(2));
				retVal.setPrezime(rs.getString(3));
				retVal.setZvanje(rs.getString(4));
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
