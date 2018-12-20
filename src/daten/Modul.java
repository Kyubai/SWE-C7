package daten;

import java.time.LocalDate;

import exceptions.CSVLeseException;
<<<<<<< HEAD
=======
import exceptions.HTMLLeseException;
import exceptions.TypFormatException;
>>>>>>> refs/remotes/origin/prototype

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

<<<<<<< HEAD
	public Modul(int modulnummer, String name, int credits, float note, int versuche, LocalDate ablaufdatum,
			LocalDate pruefungsDatum, int semester, Typ typ, float planNote) {
=======
	/**
	 * initialisiert das modul mit den werten aus einer csv zeile. um daten aus
	 * einer html datein hinzuzuf�gen muss loadQIS() benutzt werden
	 * 
	 * @param csvZeile
	 *            die geparste zeile aus der csv datei
	 * @throws CSVLeseException
	 *             wenn beim lesen der CSV daten ein Fehler auftritt.
	 */
	public Modul(List<String> csvZeile) throws CSVLeseException {
		this(0, null, 0, 0, 0, null, null, 0, null, 0);
		try {
			modulnummer = Integer.parseInt(csvZeile.get(0));
			name = csvZeile.get(1);
			credits = Integer.parseInt(csvZeile.get(3));
			semester = Integer.parseInt(csvZeile.get(2));
			typ = Typ.parseTyp(csvZeile.get(4));
		} catch (NumberFormatException | TypFormatException e) {
			throw new CSVLeseException("Ung�ltiger Wert (" + e.getMessage() + ")");
		} catch (IndexOutOfBoundsException e) {
			throw new CSVLeseException("Fehlender Wert");
		}
	}

	/**
	 * initialisiert das modul mit den gegebenen werten.
	 */
	public Modul(int modulnummer, String name, int credits, float note, int versuche, Date ablaufdatum,
			Date pruefungsDatum, int semester, Typ typ, float planNote) {
>>>>>>> refs/remotes/origin/prototype
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
	public void loadQIS(String[] htmlZeile) throws HTMLLeseException {
		if (htmlZeile == null) {
			return;
		}
		try {
			note = Float.parseFloat(htmlZeile[3].replaceAll(",", "."));
			versuche = (int) Float.parseFloat(htmlZeile[3].replaceAll(",", "."));
		} catch (NumberFormatException e) {
			e.printStackTrace();
			throw new HTMLLeseException(
					"Ung�ltiger Wert (" + e.getMessage() + ")\"" + note + "\"+\"" + versuche + "\"");
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
