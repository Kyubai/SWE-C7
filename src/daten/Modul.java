package daten;

import java.util.Date;
import java.util.List;

import exceptions.CSVLeseException;
import exceptions.TypFormatException;

public class Modul {

	private int modulnummer;
	private String name;
	private int credits;
	private float note;
	private int versuche;
	private Date ablaufdatum;
	private Date pr�fungsDatum;
	private int semester;
	private Typ typ;
	private float planNote;

	public Modul() {
		modulnummer = 0;
		name = null;
		credits = 0;
		note = 0;
		versuche = 0;
		ablaufdatum = null;
		pr�fungsDatum = null;
		semester = 0;
		typ = null;
		planNote = 0;
	}

	public Modul(List<String> csvZeile) throws CSVLeseException {
		this();
		try {
			modulnummer = Integer.parseInt(csvZeile.get(0));
			name = csvZeile.get(1);
			credits = Integer.parseInt(csvZeile.get(3));
			semester = Integer.parseInt(csvZeile.get(2));
			typ = Typ.parseTyp(csvZeile.get(4));
		} catch (NumberFormatException | TypFormatException e) {
			throw new CSVLeseException("Ung�ltiger Wert", 0);
		} catch (IndexOutOfBoundsException e) {
			throw new CSVLeseException("Fehlender Wert", 0);
		}
	}

	public void loadQIS(String[] htmlZeile) throws CSVLeseException {
		if (htmlZeile == null) {
			return;
		}
		try {
			note = Float.parseFloat(htmlZeile[2].replaceAll(",", "."));
			versuche = Integer.parseInt(htmlZeile[4]);
		} catch (NumberFormatException e) {
			throw new CSVLeseException("Ung�ltiger Wert", 0);
		}
	}

	public Modul(int modulnummer, String name, int credits, float note, int versuche, Date ablaufdatum,
			Date pr�fungsDatum, int semester, Typ typ, float planNote) {
		this.modulnummer = modulnummer;
		this.name = name;
		this.credits = credits;
		this.note = note;
		this.versuche = versuche;
		this.ablaufdatum = ablaufdatum;
		this.pr�fungsDatum = pr�fungsDatum;
		this.semester = semester;
		this.typ = typ;
		this.planNote = planNote;
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

	public Date getPr�fungsDatum() {
		return pr�fungsDatum;
	}

	public int getSemester() {
		return semester;
	}

	public Typ getTyp() {
		return typ;
	}

	public void setPlanNote(float planNote) {
		this.planNote = planNote;
	}

	public float getPlanNote() {
		return planNote;
	}

	@Override
	public String toString() {
		return "modulnummer: " + modulnummer + " name: " + name + " credits: " + credits + " note: " + note
				+ " versuche: " + versuche + " ablaufdatum: " + ablaufdatum + " semseter: " + semester + " typ: " + typ;
	}

	public boolean isGeschrieben() {
		return note != 0.0f;
	}
}
