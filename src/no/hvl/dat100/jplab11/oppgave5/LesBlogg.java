package no.hvl.dat100.jplab11.oppgave5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;
import no.hvl.dat100.jplab11.oppgave2.*;
import no.hvl.dat100.jplab11.oppgave3.*;

import javax.swing.JOptionPane;

public class LesBlogg {

	private static String TEKST = "TEKST";
	private static String BILDE = "BILDE";

	public static Blogg les(String mappe, String filnavn) {

		BufferedReader scanner=null;
		String location="" + mappe + filnavn;
		try {
			scanner =new BufferedReader(new FileReader(location));
			int length=java.lang.Integer.parseInt(scanner.readLine());
			Blogg innlest = new Blogg(length);
			
			for(int i=0; i<length; i++) {
				String type=scanner.readLine();
				if(type.equals(TEKST)) {
					int id= java.lang.Integer.parseInt(scanner.readLine());
					String bruker=scanner.readLine();
					String dato=scanner.readLine();
					int likes=java.lang.Integer.parseInt(scanner.readLine());
					String tekst=scanner.readLine();
					Tekst tekstInnlegg=new Tekst(id, bruker, dato, likes, tekst);
					innlest.leggTil(tekstInnlegg);
					
				}else if(type.equals(BILDE)) {
					int id= java.lang.Integer.parseInt(scanner.readLine());
					String bruker=scanner.readLine();
					String dato=scanner.readLine();
					int likes=java.lang.Integer.parseInt(scanner.readLine());
					String bildetekst=scanner.readLine();
					String url =scanner.readLine();
					Bilde bildeInnlegg=new Bilde(id, bruker, dato, likes, bildetekst, url);
					innlest.leggTil(bildeInnlegg);
				}
			}
			return innlest;
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}finally {
			if(scanner!=null) {
			try {
				scanner.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			}
		}
		return null;

	}
}
