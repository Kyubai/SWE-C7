package daten;

import java.util.List;

public class Studiengang {
	private List<Modul> module;

	private String name;
	private int ben�tigteCredits;
	private int anzSemester;
	private int anzWahl;
	private int anzSoftskill;
	private int maxVerbleibendeVersuche;

	public Studiengang(List<Modul> module, String name, int ben�tigteCredits, int anzSemester, int anzWahl,
			int anzSoftskill, int maxVerbleibendeVersuche) {
		this.module = module;
		this.name = name;
		this.ben�tigteCredits = ben�tigteCredits;
		this.anzSemester = anzSemester;
		this.anzWahl = anzWahl;
		this.anzSoftskill = anzSoftskill;
		this.maxVerbleibendeVersuche = maxVerbleibendeVersuche;
	}

	public float durchschnittsNote() {
		return 0;
	}

	public Modul getModul(int i) {
		return module.get(i);
	}

	public int getModuleSize() {
		return module.size();
	}

	public List<Modul> getModule() {
		return module;
	}

	public String getName() {
		return name;
	}

	public int getBen�tigteCredits() {
		return ben�tigteCredits;
	}

	public int getAnzSemester() {
		return anzSemester;
	}

	public int getAnzWahl() {
		return anzWahl;
	}

	public int getAnzSoftskill() {
		return anzSoftskill;
	}

	public int getMaxVerbleibendeVersuche() {
		return maxVerbleibendeVersuche;
	}

}
