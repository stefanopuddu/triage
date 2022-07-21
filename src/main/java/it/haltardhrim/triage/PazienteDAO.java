package it.haltardhrim.triage;

import java.sql.*;
import java.util.*;

/**
 * Questa classe fa parte del pattern DAO.
 * Risponde alla domanda: come gestisco un Paziente nel DB?
 * Contiene i metodi CRUD necessari per manipolare i Pazienti nel DB.
 */
public class PazienteDAO {

	private final String CREATE_PAZIENTE =
		"INSERT INTO pazienti (id,codfisc,prioritaIniz,priorita,stato,userInsert,timeInsert,userUpdate,timeUpdate)" +
		"VALUES (default,?,?,?,?,?,?,?,?)";
	private final String READ_PAZIENTI_IN_CODA =
		"SELECT * FROM pazienti WHERE stato <> 5 ORDER BY priorita,timeInsert";
	private final String UPDATE_PAZIENTE_STATO =
		"UPDATE pazienti SET stato = ?, userUpdate = \"PazDAO\", timeUpdate = CURRENT_TIMESTAMP WHERE id = ?";
	private final String UPDATE_PAZIENTE_PRIORITA =
		"UPDATE pazienti SET priorita = ?, userUpdate = \"PazDAO\", timeUpdate = CURRENT_TIMESTAMP WHERE id = ?";
	private final String DELETE_PAZIENTE =
		"DELETE FROM pazienti WHERE id = ?";

	public Connection getConnection() {
		Connection conn = null;

		try {
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/triage", "postgres", "postgres");
		} catch (Exception e) {
			System.err.println("Errore in fase di connessione al DB");
			e.printStackTrace();
		}

		return conn;
	}

	public void createPaziente(Paziente paz) {
		Connection conn = null;
		PreparedStatement query = null;

		try {
			conn = this.getConnection();
			query = conn.prepareStatement(CREATE_PAZIENTE);
			query.setString(1, paz.getCodfisc());
			query.setInt(2, paz.getPrioritaIniz());
			query.setInt(3, paz.getPrioritaIniz());
			query.setInt(4, paz.DA_VISITARE);
			query.setString(5, "PazDAO");
			query.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
			query.setString(7, "");
			query.setTimestamp(8, new Timestamp(0));
			query.executeUpdate();
			query.close();
			conn.close();
		} catch (SQLException e) {
			System.err.println("Errore in fase di esecuzione INSERT createPaziente");
			e.printStackTrace();
		}
	}

	public List<Paziente> readPazientiInCoda() {
		//TODO
		System.out.println("Funzione non ancora implementata");
		ArrayList<Paziente> list = new ArrayList<Paziente>();
		return list;
	}
	public void updatePazienteStato(Paziente paz) {
		//TODO
		System.out.println("Funzione non ancora implementata");
	}
	public void updatePazientePriorita(Paziente paz) {
		//TODO
		System.out.println("Funzione non ancora implementata");
	}
	public void deletePaziente(Paziente paz) {
		//TODO
		System.out.println("Funzione non ancora implementata");
	}
}
