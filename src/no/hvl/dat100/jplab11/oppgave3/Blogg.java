package no.hvl.dat100.jplab11.oppgave3;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;

public class Blogg {
	Innlegg[] innleggtabell;
	int nesteLedig;
	
	public Blogg() {
		innleggtabell=new Innlegg[20];
		nesteLedig=0;
	}

	public Blogg(int lengde) {
		innleggtabell=new Innlegg[lengde];
		nesteLedig=0;
	}

	public int getAntall() {
		return nesteLedig;
	}
	
	public Innlegg[] getSamling() {
		return innleggtabell;

	}
	
	public int finnInnlegg(Innlegg innlegg) {
		int pos=-1;
		int i=0;
		boolean funnet=false;
		while (!funnet&&i<nesteLedig){
			if(innleggtabell[i].erLik(innlegg)) {
				pos=i;
				funnet=true;
			}
			i++;
		}
		
		return pos;
	}

	public boolean finnes(Innlegg innlegg) {
		if (finnInnlegg(innlegg)>=0) {
			return true;
		}
		return false;
	}

	public boolean ledigPlass() {
		if(nesteLedig<innleggtabell.length) {
			return true;
		}
		return false;
	}
	
	public boolean leggTil(Innlegg innlegg) {
		if(!finnes(innlegg)) {
			innleggtabell[nesteLedig]=innlegg;
			nesteLedig++;
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		String str="";
		str+= nesteLedig;
		str+="\n";
		for (int i=0; i<nesteLedig; i++) {
			str+=innleggtabell[i].toString();
		}
		return str;
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		int newLength=innleggtabell.length*2;
		Innlegg[] newTable = new Innlegg[newLength];
		for(int i=0; i<nesteLedig; i++) {
			newTable[i]=innleggtabell[i];
		}
		innleggtabell=newTable;
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {
		if (!finnes(innlegg)) {
			if (nesteLedig>= innleggtabell.length) {
				utvid();
			}
			return leggTil(innlegg);
		}
		return false;
	}
	
	public boolean slett(Innlegg innlegg) {
		
		int pos=finnInnlegg(innlegg);
		if(pos>=0) {
			innleggtabell[pos]=innleggtabell[nesteLedig-1];
			nesteLedig--;
			innleggtabell[nesteLedig]=null;
			return true;
		}
		return false;
	}
	
	public int[] search(String keyword) {
		
		int[] result = new int[nesteLedig];
		int nextResult=0;
		for (int i=0; i<nesteLedig; i++) {
			if(innleggtabell[i].toString().contains(keyword)) {
				result[nextResult]=innleggtabell[i].getId();
				nextResult++;
				}
		}
		return result;

	}
}