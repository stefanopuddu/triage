package it.haltardhrim.triage;

import java.sql.*;
import java.util.Scanner;

public class Menu {
	// Dichiarazione variabili
    Scanner scanner;
    String scanLine;
    String query;

    public void run() {
    	// Dichiarazione variabili
    	scanner = new Scanner(System.in);

    	// Scrivi menu
		System.out.println("---Pronto Soccorso CLI---");
		System.out.println("1: Create");
		System.out.println("2: Read");
		System.out.println("3: Update");

		// Leggi input
		scanLine = scanner.nextLine(); 

		// Esegui scelta
	    switch(scanLine) {
	    case "1": {
	    	System.out.println("Run Create...");
	    	runCreate();
	    }
	    case "2": {
	    	System.out.println("Run Read...");
	    	runRead();
	    }
	    case "3": {
	    	System.out.println("Run Update...");
	    	runUpdate();
	    }
	    default:  {
	    	System.out.println("Comando non riconosciuto, chiusura...");
	    }}

	    // Chiusura risorse
	    scanner.close();
	}

	private void runCreate() {
		// Dichiarazione variabili
		String codfisc = "";
		Integer prioritaIniz = 0;

		// Lettura dati in input
		System.out.println("Inserire dati nuovo paziente.");

		do {
			System.out.print("Cod.Fiscale: ");
	        scanLine = scanner.nextLine();
	        if (scanLine.length() == 16) {
	        	codfisc = scanLine.toUpperCase();
	        }
		} while (codfisc == "");

		do {
			System.out.print("Priorita (1=Rosso, 2=Giallo, 3=Verde, 4=Bianco): ");
			scanLine = scanner.nextLine();
			if ((scanLine.equals("1")) || (scanLine.equals("2")) || (scanLine.equals("3")) || (scanLine.equals("4"))) {
				prioritaIniz = Integer.parseInt(scanLine);
			}
		} while (prioritaIniz == 0);

		// Esecuzione ordine
		query = "INSERT INTO Pazienti (id,codfisc,prioritaIniz,priorita,stato,userInsert,timeInsert,userUpdate,timeUpdate) "
			  + "VALUES (default," + codfisc + "," + prioritaIniz + "," + prioritaIniz + ","
			  + "1,\"Menu\",CURRENT_TIMESTAMP,\"\",\"0001-01-01-00:00:00.0\");";
		runQuery();
	}

	private void runUpdate() {
		System.exit(0);
	}

	private void runRead() {
		System.exit(0);
	}

	private void runQuery() {
		try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/triage", "postgres", "postgres");
				PreparedStatement statement = conn.prepareStatement(query);) {
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				System.out.println("Funziona!");
			}

		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
