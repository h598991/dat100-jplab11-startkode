package no.hvl.dat100.jplab11.oppgave2;

import no.hvl.dat100.jplab11.common.TODO;

public class Bilde extends Tekst {

	String url;
	
	public Bilde(int id, String bruker, String dato, String tekst, String url) {
		super(id, bruker, dato, tekst);
		this.url=url;
	}

	public Bilde(int id, String bruker, String dato, int likes, String tekst, String url) {
		super(id, bruker, dato, likes, tekst);
		this.url=url;
	}
	
	public String getUrl() {
		return url;

	}

	public void setUrl(String url) {
		this.url=url;
	}

	@Override
	public String toString() {
		String str="BILDE";
		str+="\n";
		str+=id;
		str+="\n";
		str+=bruker;
		str+="\n";
		str+=dato;
		str+="\n";
		str+=likes;
		str+="\n";
		str+="et bilde";
		str+="\n";
		str+=url;
		str+="\n";
		return str;

	}

	// Metoden nedenfor er kun for valgfri oppgave 6
	public String toHTML() {
		
		super.toHTML();
		String str="<p>" + tekst + "<p>";
		str+="\n";
		str+="<iframe src=\"" + url + "\" height=600 width=800></iframe>";
		str+="\n";
		str+="<hr>";
		
		return str;		
	}
}
