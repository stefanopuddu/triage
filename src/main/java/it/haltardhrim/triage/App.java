package it.haltardhrim.triage;

public class App {

	public static void main(String[] args) {
		// Inizializza servizio
		PazienteService pazServ = new PazienteService();

		// Test 1: Crea un nuovo Paziente e inseriscilo in tabella
		Paziente paz = new Paziente();
		paz.setCodfisc("MRNMTT91S29G489T");
		paz.setPrioritaIniz(paz.ROSSO);
		pazServ.accogliPaziente(paz);
		System.out.println("Paziente " + paz.getCodfisc() + " inserito con priorita " + paz.getPrioritaIniz() + ".");
	}
}
