package com.itp.studentskasluzba.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import com.itp.studentskasluzba.dto.Studenti;

public class StudentiDAO {

	public static Vector<Studenti> getAll() {
		Vector<Studenti> retVal = new Vector<Studenti>();
		Connection conn = null;
		java.sql.PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT * FROM  studenti";

		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next())
				retVal.add(new Studenti(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
		} catch (SQLException e) {
			e.printStackTrace();
			DBUtilities.getInstance().showSQLException(e);
		} finally {
			ConnectionPool.getInstance().checkIn(conn);
			DBUtilities.getInstance().close(ps, rs);
		}
		return retVal;
	}
	
	
	public static boolean dodajStudenti(Studenti stu) {
		boolean retVal = false;
		Connection conn = null;
		java.sql.PreparedStatement ps = null;

		String query = "INSERT INTO studenti (ime, prezime, broj_indexa, godina_upisa) VALUES (?,?,?,?)";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setString(1, stu.getIme());
			ps.setString(2, stu.getPrezime());
			ps.setString(3, stu.getBrojIndexa());
			ps.setString(4, stu.getGodinaUpisa());

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
	
	
	
	public static boolean azurirajStudenti(int studentId, String ime, String prezime, String brojIndexa, String godinaUpisa) {
		boolean retVal = false;
		Connection conn = null;
		java.sql.PreparedStatement ps = null;

		String query = "UPDATE studenti SET ime=?,prezime=?,brojIndexa=?,godinaUpisa=? WHERE studentId=?";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setInt(1, studentId);
			ps.setString(2, ime);
			ps.setString(3, prezime);
			ps.setString(4, brojIndexa);
			ps.setString(4, godinaUpisa);
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
	
	
	
	public static boolean obrisiStudenti(int studentId) {
		boolean retVal = false;
		Connection conn = null;
		java.sql.PreparedStatement ps = null;

		String query = "DELETE FROM ciklus WHERE studentId=?";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setInt(1, studentId);

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
	
	
	
	
	public static Studenti getById(int stud) {
		Studenti retVal = new Studenti();
		Connection conn = null;
		java.sql.PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT * FROM  studenti WHERE id_studenti=?";

		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setInt(1, stud);
			rs = ps.executeQuery();

			while (rs.next()) {
				retVal.setStudentId(rs.getInt(1));
				retVal.setIme(rs.getString(2));
				retVal.setPrezime(rs.getString(3));
				retVal.setBrojIndexa(rs.getString(4));
				retVal.setGodinaUpisa(rs.getString(5));
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
