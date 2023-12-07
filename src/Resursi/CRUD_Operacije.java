package Resursi;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import Helperi.Helper;
import Helperi.Prikaz;
import Izuzeci.Greska;


public class CRUD_Operacije {
	 static Prikaz Prikaz = new Prikaz();

	static Helper Helper = new Helper();
	static Prikaz PrikazHelp = new Prikaz();
	
	public static String prikaz(JTable table) {
		String query = "SELECT * FROM meni";
		PrikazHelp.PopuniTabelu(query, table);
		return query;
	}
 
	public static void Dodaj(String Naziv, String Cena, String Vrsta) throws Greska {
    	if(Naziv.equals("") ||  Cena.equals("") || Vrsta.equals("")) {
    		throw new Greska("Polja nisu popunjena");
		}else { 
			
			Connection conn = Helperi.Helper.DBSetup();
			String query = "INSERT INTO meni(naziv, cena, vrsta) VALUES ('"+Naziv+"', '"+Integer.valueOf(Cena)+"', '"+Vrsta+"')";
			
			try {
				
						java.sql.Statement stm = conn.createStatement();
						stm.execute(query);
						conn.close();
				
			}
			catch(Exception be){
					be.printStackTrace();
			}
			
					}
    }
	
	public static void Izmeni(String Naziv, String Cena, String Vrsta, String ID) throws Greska {
    	if(Naziv.equals("") ||  Cena.equals("") || Vrsta.equals("")) {
    		throw new Greska("Polja nisu popunjena");
		}else { 
			
			Connection conn = Helperi.Helper.DBSetup();
			String query = "UPDATE meni SET naziv ='"+Naziv+"', cena = '"+Integer.valueOf(Cena)+"', vrsta ='"+Vrsta+"' WHERE ID = "+ID+"";
			
			try {
				
						java.sql.Statement stm = conn.createStatement();
						stm.execute(query);
						conn.close();
				
			}
			catch(Exception be){
					be.printStackTrace();
			}
		}		
    }


    public static void Obrisi(String Naziv, String Cena, String Vrsta, String ID) throws Greska {
    	Connection connect = Helperi.Helper.DBSetup();
		String sql = "DELETE FROM meni WHERE ID = " + ID;
		System.out.print(sql);
		
		Statement stm;
		try {
			
						stm = connect.createStatement();
						stm.execute(sql);
						connect.close();	
					
		} catch (SQLException e) {
			throw new Greska("Desila se greška usled brisanja");
		}
	}
}