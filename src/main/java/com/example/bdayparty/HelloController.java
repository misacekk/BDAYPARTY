package com.example.bdayparty;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML private ListView<Guest> guestListView;
    @FXML private Label jmenoLabel, darekLabel, statusLabel, searchLabel;
    @FXML private TextField jmenoField, darekField, statusField, searchField;

    @FXML
    public void initialize() {
        // Hned po startu tam něco hodíme, ať vidíš, že to jede
        guestListView.getItems().add(new Guest("Pepa Zdepa", "Ponožky", "Ano"));
        guestListView.getItems().add(new Guest("Alena Modrá", "Kytka", "Možná"));
    }

    @FXML
    public void handleVyberHosta() {
        Guest vybrany = guestListView.getSelectionModel().getSelectedItem();
        if (vybrany != null) {
            jmenoLabel.setText("Jméno: " + vybrany.getJmeno());
            darekLabel.setText("Dárek: " + vybrany.getDarek());
            statusLabel.setText("Status: " + vybrany.getStatus());
        }
    }

    @FXML
    private void handlePridejHosta() {
        if (!jmenoField.getText().isBlank()) {
            guestListView.getItems().add(new Guest(jmenoField.getText(), darekField.getText(), statusField.getText()));
            jmenoField.clear(); darekField.clear(); statusField.clear();
        }
    }

    @FXML
    private void handleOdeberHosta() {
        Guest vybrany = guestListView.getSelectionModel().getSelectedItem();
        if (vybrany != null) guestListView.getItems().remove(vybrany);
    }

    @FXML
    private void handleUpravHosta() {
        Guest vybrany = guestListView.getSelectionModel().getSelectedItem();
        if (vybrany != null) {
            vybrany.setJmeno(jmenoField.getText());
            vybrany.setDarek(darekField.getText());
            vybrany.setStatus(statusField.getText());
            guestListView.refresh();
        }
    }

    @FXML
    private void handleSearchHosta() {
        String hledane = searchField.getText().toLowerCase();
        for (Guest g : guestListView.getItems()) {
            if (g.getJmeno().toLowerCase().contains(hledane)) {
                guestListView.getSelectionModel().select(g);
                handleVyberHosta();
                return;
            }
        }
    }
}