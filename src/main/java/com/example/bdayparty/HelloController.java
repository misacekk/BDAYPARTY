package com.example.bdayparty;

import com.example.demolistview.model.Guest; // Předpokládám přejmenování třídy
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private ListView<Guest> guestListView;
    @FXML
    private Label jmenoLabel, darekLabel, statusLabel, searchLabel;
    @FXML
    private TextField jmenoField, darekField, statusField, searchField;

    public void initialize() {
        try {
            // Testovací data pro tvoji oslavu
            guestListView.getItems().add(new Guest("Petr Novák", "Lego Star Wars", "Potvrzeno"));
            guestListView.getItems().add(new Guest("Jana Malá", "Láhev vína", "Možná"));
            guestListView.getItems().add(new Guest("Karel Velký", "Desková hra", "Nepotvrzeno"));
        } catch (Exception e) {
            System.out.println("Chyba při načítání seznamu hostů: " + e.getMessage());
        }
    }

    @FXML
    public void handleVyberHosta() {
        try {
            Guest vybrany = guestListView.getSelectionModel().getSelectedItem();
            if (vybrany == null) return;

            jmenoLabel.setText("Jméno: " + vybrany.getJmeno());
            darekLabel.setText("Dárek: " + vybrany.getDarek());
            statusLabel.setText("Status: " + vybrany.getStatus());
        } catch (Exception e) {
            System.out.println("Chyba při výběru hosta: " + e.getMessage());
        }
    }

    @FXML
    private void handlePridejHosta() {
        try {
            String jmeno = jmenoField.getText();
            String darek = darekField.getText();
            String status = statusField.getText();

            if (isEmpty(jmeno) || isEmpty(darek) || isEmpty(status)) return;

            guestListView.getItems().add(new Guest(jmeno, darek, status));
            vycistiPole();

        } catch (Exception e) {
            System.out.println("Chyba při přidávání hosta: " + e.getMessage());
        }
    }

    @FXML
    private void handleSearchHosta() {
        try {
            String hledaneJmeno = searchField.getText();
            if (isEmpty(hledaneJmeno)) {
                searchLabel.setText("Zadej jméno!");
                return;
            }

            boolean nalezeno = false;
            for (Guest g : guestListView.getItems()) {
                if (g.getJmeno().toLowerCase().contains(hledaneJmeno.toLowerCase().trim())) {
                    guestListView.getSelectionModel().select(g);
                    handleVyberHosta();
                    nalezeno = true;
                    searchLabel.setText("Nalezeno!");
                    break;
                }
            }

            if (!nalezeno) searchLabel.setText("Nenalezen");

        } catch (Exception e) {
            System.out.println("Chyba při hledání: " + e.getMessage());
        }
    }

    @FXML
    private void handleUpravHosta() {
        try {
            Guest vybrany = guestListView.getSelectionModel().getSelectedItem();
            if (vybrany == null) return;

            vybrany.setJmeno(jmenoField.getText());
            vybrany.setDarek(darekField.getText());
            vybrany.setStatus(statusField.getText());

            guestListView.refresh();
            handleVyberHosta(); // Aktualizuje labely

        } catch (Exception e) {
            System.out.println("Chyba při úpravě: " + e.getMessage());
        }
    }

    @FXML
    private void handleOdeberHosta() {
        try {
            Guest vybrany = guestListView.getSelectionModel().getSelectedItem();
            if (vybrany != null) {
                guestListView.getItems().remove(vybrany);
                vycistiLabely();
            }
        } catch (Exception e) {
            System.out.println("Chyba při odebírání: " + e.getMessage());
        }
    }

    // Pomocné metody pro čistší kód
    private boolean isEmpty(String s) {
        return s == null || s.isBlank();
    }

    private void vycistiPole() {
        jmenoField.clear();
        darekField.clear();
        statusField.clear();
    }

    private void vycistiLabely() {
        jmenoLabel.setText("Jméno: --");
        darekLabel.setText("Dárek: --");
        statusLabel.setText("Status: --");
    }
}