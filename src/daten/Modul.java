package daten;

import java.util.Date;

public class Modul {
	private int modulnummer;
	private String name;
	private int credits;
	private float note;
	private int versuche;
	private Date ablaufdatum;
	private int semester;
	private String typ;

	public Modul(int modulnummer, String name, int credits, float note, int versuche, Date ablaufdatum, int semester,
			String typ) {
		this.modulnummer = modulnummer;
		this.name = name;
		this.credits = credits;
		this.note = note;
		this.versuche = versuche;
		this.ablaufdatum = ablaufdatum;
		this.semester = semester;
		this.typ = typ;
	}

	public int getModulnummer() {
		return modulnummer;
	}

	public String getName() {
		return name;
	}

	public int getCredits() {
		return credits;
	}

	public float getNote() {
		return note;
	}

	public int getVersuche() {
		return versuche;
	}

	public Date getAblaufdatum() {
		return ablaufdatum;
	}

	public int getSemester() {
		return semester;
	}

	public String getTypr() {
		return typ;
	}

	@Override
	public String toString() {
		return "modulnummer: " + modulnummer + " name: " + name + " credits: " + credits + " note: " + note
				+ " versuche: " + versuche + " ablaufdatum: " + ablaufdatum + " semseter: " + semester + " typ: " + typ;
	}
}
