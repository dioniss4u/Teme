package Entities;

import java.sql.Timestamp;

/**
 * Created by dioni on 1/26/2017.
 */
public class Tema {
    private int id;
    private int valoare;
    private int id_elev;
    private int id_profesor;
    private int status;
    private String titlu;
    private Timestamp data;
    private Timestamp data_finalizare;
    private int urgent;

    public int getUrgent() {
        return urgent;
    }

    public void setUrgent(int urgent) {
        this.urgent = urgent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValoare() {
        return valoare;
    }

    public void setValoare(int valoare) {
        this.valoare = valoare;
    }

    public int getId_elev() {
        return id_elev;
    }

    public void setId_elev(int id_elev) {
        this.id_elev = id_elev;
    }

    public int getId_profesor() {
        return id_profesor;
    }

    public void setId_profesor(int id_profesor) {
        this.id_profesor = id_profesor;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }

    public Timestamp getData_finalizare() {
        return data_finalizare;
    }

    public void setData_finalizare(Timestamp data_finalizare) {
        this.data_finalizare = data_finalizare;
    }
}
