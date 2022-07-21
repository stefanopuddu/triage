package it.haltardhrim.triage;

public class Paziente {

	public Integer id;
	public String  codfisc;
	public Integer prioritaIniz; //1=Rosso, 2=Giallo, 3=Verde, 4=Bianco
	public Integer priorita;     //1=Rosso, 2=Giallo, 3=Verde, 4=Bianco
	public Integer stato;        //1=Da visitare, 2=In visita, 3=In intervento, 4=In osservazione, 5=Evaso
	public String  userInsert;
	public String  timeInsert;
	public String  userUpdate;
	public String  timeUpdate;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCodfisc() {
		return codfisc;
	}
	public void setCodfisc(String codfisc) {
		this.codfisc = codfisc;
	}
	public Integer getPrioritaIniz() {
		return prioritaIniz;
	}
	public void setPrioritaIniz(Integer prioritaIniz) {
		this.prioritaIniz = prioritaIniz;
	}
	public Integer getPriorita() {
		return priorita;
	}
	public void setPriorita(Integer priorita) {
		this.priorita = priorita;
	}
	public Integer getStato() {
		return stato;
	}
	public void setStato(Integer stato) {
		this.stato = stato;
	}
	public String getUserInsert() {
		return userInsert;
	}
	public void setUserInsert(String userInsert) {
		this.userInsert = userInsert;
	}
	public String getTimeInsert() {
		return timeInsert;
	}
	public void setTimeInsert(String timeInsert) {
		this.timeInsert = timeInsert;
	}
	public String getUserUpdate() {
		return userUpdate;
	}
	public void setUserUpdate(String userUpdate) {
		this.userUpdate = userUpdate;
	}
	public String getTimeUpdate() {
		return timeUpdate;
	}
	public void setTimeUpdate(String timeUpdate) {
		this.timeUpdate = timeUpdate;
	}
}