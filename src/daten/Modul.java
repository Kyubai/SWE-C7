package daten;

import java.time.LocalDate;
import java.util.List;

import exceptions.CSVLeseException;
import exceptions.TypFormatException;

public class Modul {

	private int modulnummer;
	private String name;
	private int credits;
	private float note;
	private int versuche;
	private LocalDate ablaufdatum;
	private LocalDate pruefungsDatum;
	private int semester;
	private Typ typ;
	private float planNote;

	public Modul(List<String> csvZeile) throws CSVLeseException {
		this(0, null, 0, 0, 0, null, null, 0, null, 0);
		try {
			modulnummer = Integer.parseInt(csvZeile.get(0));
			name = csvZeile.get(1);
			credits = Integer.parseInt(csvZeile.get(3));
			semester = Integer.parseInt(csvZeile.get(2));
			typ = Typ.parseTyp(csvZeile.get(4));
		} catch (NumberFormatException | TypFormatException e) {
			throw new CSVLeseException("Ung�ltiger Wert");
		} catch (IndexOutOfBoundsException e) {
			throw new CSVLeseException("Fehlender Wert");
		}
	}

	public Modul(int modulnummer, String name, int credits, float note, int versuche, LocalDate ablaufdatum,
			LocalDate pruefungsDatum, int semester, Typ typ, float planNote) {
		this.modulnummer = modulnummer;
		this.name = name;
		this.credits = credits;
		this.note = note;
		this.versuche = versuche;
		this.ablaufdatum = ablaufdatum;
		this.pruefungsDatum = pruefungsDatum;
		this.semester = semester;
		this.typ = typ;
		this.planNote = planNote;
	}

	public void loadQIS(String[] htmlZeile) throws CSVLeseException {
		if (htmlZeile == null) {
			return;
		}
		try {
			note = Float.parseFloat(htmlZeile[2].replaceAll(",", "."));
			versuche = Integer.parseInt(htmlZeile[4]);
		} catch (NumberFormatException e) {
			throw new CSVLeseException("Ung�ltiger Wert");
		}
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

	public LocalDate getAblaufdatum() {
		return ablaufdatum;
	}

	public LocalDate getPruefungsDatum() {
		return pruefungsDatum;
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
