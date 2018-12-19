package daten;

import java.time.LocalDate;
import java.util.Date;



/**
 * Speichert alle daten die �ber ein modul verf�gbar sind. nur die wunschnote
 * ist ver�nderbar.
 *
 */
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

	/**
	 * initialisiert das modul mit den werten aus einer csv zeile. um daten aus
	 * einer html datein hinzuzuf�gen muss loadQIS() benutzt werden
	 * 
	 * @param csvZeile
	 *            die geparste zeile aus der csv datei
	 * @throws CSVLeseException
	 *             wenn beim lesen der CSV daten ein Fehler auftritt.
	 */


	/**
	 * initialisiert das modul mit den gegebenen werten.
	 */
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

	/**
	 * l�d die daten aus einer html datei
	 * 
	 * @param htmlZeile
	 *            die geparste zeile aus der html datei (eine zeile aus der
	 *            tabelle)
	 * @throws HTMLLeseException
	 *             wenn beim lesen der HTML daten ein Fehler auftritt.
	 */


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
