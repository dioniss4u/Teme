package Entities;

/**
 * Created by dioni on 1/26/2017.
 */
public class Profesor {
    private int id;
    private String email;
    private String nume;
    private String prenume;
    private String pass;
    private String materie;
    private String specializari;
    private int credite;

    public int getCredite() {
        return credite;
    }

    public void setCredite(int credite) {
        this.credite = credite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getMaterie() {
        return materie;
    }

    public void setMaterie(String materie) {
        this.materie = materie;
    }

    public String getSpecializari() {
        return specializari;
    }

    public void setSpecializari(String specializari) {
        this.specializari = specializari;
    }
}
