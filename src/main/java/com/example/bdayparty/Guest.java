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
    public void setJmeno(String j) { this.jmeno = j; }
    public String getDarek() { return darek; }
    public void setDarek(String d) { this.darek = d; }
    public String getStatus() { return status; }
    public void setStatus(String s) { this.status = s; }

    @Override
    public String toString() { return jmeno; }
}