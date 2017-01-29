package Controllers;

import Entities.Profesor;
import Entities.User;
import Utils.AbstractController;
import Utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by dioni on 1/26/2017.
 */
public class ProfesorController extends AbstractController{
    public static void AddNew(String n,String p, String e,String pass,String mat,String spec){
        PreparedStatement pst;
        ResultSet rs;
        Connection con= DBConnection.getConnection();
        try {
            pst=con.prepareStatement("insert INTO profesor(nume,prenume,parola, email,materie,specializari) values(?,?,?,?,?,?)");
            pst.setString(1,n);
            pst.setString(2,p);
            pst.setString(3,pass);
            pst.setString(4,e);
            pst.setString(5,mat);
            pst.setString(6,spec);
            pst.executeUpdate();
        }catch (Exception ex){

        }
    }
    public static void updateUser(String n,String p, String e,String pass,String mat,String spec,int id){
        PreparedStatement pst;
        ResultSet rs;
        Connection con= DBConnection.getConnection();
        try {
            pst=con.prepareStatement("UPDATE profesor set nume=?,prenume=?,parola=?,email=?,materie=?,specializari=? where id=?");
            pst.setString(1,n);
            pst.setString(2,p);
            pst.setString(3,pass);
            pst.setString(4,e);
            pst.setString(5,mat);
            pst.setString(6,spec);
            pst.setInt(7,id);
            pst.executeUpdate();
        }catch (Exception ex){

        }
    }
    public static String ScadeCredite(int id,int cr){
        String raspuns="Credite insuficiente";
        int credite=0;
        PreparedStatement pst;
        ResultSet rs;
        Connection con= DBConnection.getConnection();
        try {
            pst=con.prepareStatement("select credite from profesor where id=?");
            pst.setInt(1,id);
            rs=pst.executeQuery();
            while(rs.next()){
                credite=rs.getInt("credite");
            }
        }catch (Exception ex){

        }
        if(credite!=0 && credite >= cr){
            try {
                pst=con.prepareStatement("update profesor set credite=? where id=?");
                pst.setInt(1,cr-credite);
                pst.setInt(2,id);
                pst.executeUpdate();
                return "Operatie reusita!";
            }catch (Exception ex){

            }
        }
        return raspuns;
    }
    public static void IncarcaCredite(int id,int cr){

        int credite=0;
        PreparedStatement pst;
        ResultSet rs;
        Connection con= DBConnection.getConnection();
        try {
            pst=con.prepareStatement("select credite from profesor where id=?");
            pst.setInt(1,id);
            rs=pst.executeQuery();
            while(rs.next()){
                credite=rs.getInt("credite");
            }
        }catch (Exception ex){

        }

        try {
            pst=con.prepareStatement("update profesor set credite=? where id=?");
            pst.setInt(1,cr+credite);
            pst.setInt(2,id);
            pst.executeUpdate();

        }catch (Exception ex){

        }
    }
    public static Profesor loginUser(String email, String pass){
        Profesor u=new Profesor();
        PreparedStatement pst;
        ResultSet rs;
        Connection con= DBConnection.getConnection();
        try {
            pst=con.prepareStatement("select * from profesor");
            rs=pst.executeQuery();
            while(rs.next()){
                if(email.equals(rs.getString("email")) && pass.equals(rs.getString("pass"))){
                    u.setId(rs.getInt("id"));
                    u.setCredite(rs.getInt("credite"));
                    u.setEmail(email);
                    u.setNume(rs.getString("nume"));
                    u.setPrenume(rs.getString("prenume"));
                   u.setMaterie(rs.getString("materie"));
                    u.setSpecializari(rs.getString("specializari"));
                }
            }
        }catch (Exception ex){

        }
        return u;
    }
    public static ArrayList<Profesor> getAll(){
        ArrayList<Profesor> profesori=new ArrayList<Profesor>();

        PreparedStatement pst;
        ResultSet rs;
        Connection con= DBConnection.getConnection();
        try {
            pst=con.prepareStatement("select * from profesor");
            rs=pst.executeQuery();
            while(rs.next()){
                Profesor u=new Profesor();
                    u.setId(rs.getInt("id"));
                    u.setCredite(rs.getInt("credite"));
                    u.setEmail(rs.getString("email"));
                    u.setNume(rs.getString("nume"));
                    u.setPrenume(rs.getString("prenume"));
                    u.setMaterie(rs.getString("materie"));
                    u.setSpecializari(rs.getString("specializari"));
                profesori.add(u);
            }
        }catch (Exception ex){

        }
        return profesori;
    }
    public static ArrayList<Profesor> getAllByMaterie(String mat){
        ArrayList<Profesor> profesori=new ArrayList<Profesor>();

        PreparedStatement pst;
        ResultSet rs;
        Connection con= DBConnection.getConnection();
        try {
            pst=con.prepareStatement("select * from profesor where materie=?");
            pst.setString(1,mat);
            rs=pst.executeQuery();
            while(rs.next()){
                Profesor u=new Profesor();
                u.setId(rs.getInt("id"));
                u.setCredite(rs.getInt("credite"));
                u.setEmail(rs.getString("email"));
                u.setNume(rs.getString("nume"));
                u.setPrenume(rs.getString("prenume"));
                u.setMaterie(rs.getString("materie"));
                u.setSpecializari(rs.getString("specializari"));
                profesori.add(u);
            }
        }catch (Exception ex){

        }
        return profesori;
    }
    public static Profesor GetById(int id){
        Profesor p=new Profesor();
        PreparedStatement pst;
        ResultSet rs;
        Connection con= DBConnection.getConnection();
        try {
            pst=con.prepareStatement("select * from profesor where id=?");
            pst.setInt(1,id);
            rs=pst.executeQuery();
            while(rs.next()){
                p.setId(rs.getInt("id"));
                p.setCredite(rs.getInt("credite"));
                p.setEmail(rs.getString("email"));
                p.setNume(rs.getString("nume"));
                p.setPrenume(rs.getString("prenume"));
                p.setMaterie(rs.getString("materie"));
                p.setSpecializari(rs.getString("specializari"));
            }
        }catch (Exception ex){

        }
        return p;
    }

}

