package com.example.bdayparty;

public class Guest {
    private String jmeno;
    private String darek;
    private String status;

    public Guest(String jmeno, String darek, String status) {
        this.jmeno = jmeno;
        this.darek = darek;
        this.status = status;
    }

    public String getJmeno() { return jmeno; }
    public void setJmeno(String jmeno) { this.jmeno = jmeno; }
    public String getDarek() { return darek; }
    public void setDarek(String darek) { this.darek = darek; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return jmeno; // Důležité, aby se v seznamu objevilo jméno
    }
}
