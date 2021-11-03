package no.hvl.dat100.jplab11.oppgave4;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave3.*;

public class SkrivBlogg {

	public static boolean skriv(Blogg samling, String mappe, String filnavn) {

		boolean success=false;
		PrintWriter skriver=null;
		String location="" + mappe + filnavn;
		try {
			skriver=new PrintWriter(location);
			skriver.println(samling.toString());
			success=true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			if(skriver!=null) {
				skriver.close();
			}
		}
		return success;
	}
}
