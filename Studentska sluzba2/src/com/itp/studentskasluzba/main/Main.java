package com.itp.studentskasluzba.main;
// https://github.com/ItpKorisnik/StudentskaSluzba
import java.sql.SQLException;
import java.util.Scanner;
import java.util.Vector;

import com.itp.studentskasluzba.dao.CiklusDAO;
import com.itp.studentskasluzba.dao.StudijskiProgramDAO;
import com.itp.studentskasluzba.dto.Ciklus;
import com.itp.studentskasluzba.dto.StudijskiProgram;

public class Main {


	@SuppressWarnings("resource")
	public static void main(String[] args) throws SQLException {
		// Prikaz svih filmova
		Vector<Ciklus> ciklusi = CiklusDAO.getAll();
		System.out.println("U bazi je "+ ciklusi.size() + " ciklusa.");
		System.out.println("Spisak ciklusa: ");
		ciklusi.forEach((i)->System.out.println(i.getNaziv()));
		
		
		Vector<StudijskiProgram> sp = StudijskiProgramDAO.getAll();
		System.out.println("U bazi je "+ sp.size() + " sp-a.");
		System.out.println("Spisak sp: ");
		sp.forEach((i)->System.out.println(i.getNaziv() + " sa ciklusa " + i.getCiklus().getNaziv()));
		
		// Dodavanje novog filma
		Scanner sc = new Scanner(System.in);
		Ciklus c = new Ciklus();
		System.out.println("*** DODAVANJE NOVOG CIKLUSA ***");
		System.out.println("Unesite naziv: ");
		c.setNaziv(sc.nextLine());
		boolean uspjesno = CiklusDAO.dodajCiklus(c);
		String bool = uspjesno ? "Uspjesno ste dodali ciklus.":"Dogodila se greska pri dodavanju ciklusa.";
		System.out.println(bool);
		/*
		System.out.println("**********AZURIRAJ FILM***********");
		System.out.println("Unesite ID filma: ");
		String idFilma=sc.nextLine();
		System.out.println("Unesite novi naziv filma:");
		String nazivFilma=sc.nextLine();
		uspjesno=StudentskaSluzbaDAO.azurirajFilm(idFilma, nazivFilma);
		if(uspjesno)
			System.out.println("Uspjesno ste azurirali film.");
		else
			System.out.println("Azuriranje nije uspjelo.");
		
		System.out.println("************BRISANJE FILMA***********");
		System.out.println("Unesite ID filma:");
		idFilma=sc.nextLine();
		uspjesno=StudentskaSluzbaDAO.obrisiFilm(idFilma);
		if(uspjesno)
			System.out.println("Uspjesno ste obrisali film.");
		else
			System.out.println("Brisanje nije uspjelo.");
		sc.close();
	}
*/
}
	}
