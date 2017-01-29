package Controllers;

import Entities.User;
import Utils.AbstractController;
import Utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by dioni on 1/25/2017.
 */
public class UserController extends AbstractController {

    public static void AddNew(String n,String p, String e,String pass,int an){
        PreparedStatement pst;
        ResultSet rs;
        Connection con= DBConnection.getConnection();
        try {
            pst=con.prepareStatement("insert INTO student(nume,prenume,parola, email,an) values(?,?,?,?,?)");
            pst.setString(1,n);
            pst.setString(2,p);
            pst.setString(3,pass);
            pst.setString(4,e);
            pst.setInt(5,an);
            pst.executeUpdate();
        }catch (Exception ex){

        }
    }
    public static void updateUser(String n,String p, String e,String pass,int id){
        PreparedStatement pst;
        ResultSet rs;
        Connection con= DBConnection.getConnection();
        try {
            pst=con.prepareStatement("UPDATE student set nume=?,prenume=?,parola=?,email=? where id=?");
            pst.setString(1,n);
            pst.setString(2,p);
            pst.setString(3,pass);
            pst.setString(4,e);
            pst.setInt(5,id);
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
            pst=con.prepareStatement("select credite from student where id=?");
            pst.setInt(1,id);
            rs=pst.executeQuery();
            while(rs.next()){
                credite=rs.getInt("credite");
            }
        }catch (Exception ex){

        }
        if(credite!=0 && credite >= cr){
            try {
                pst=con.prepareStatement("update student set credite=? where id=?");
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
            pst=con.prepareStatement("select credite from student where id=?");
            pst.setInt(1,id);
            rs=pst.executeQuery();
            while(rs.next()){
                credite=rs.getInt("credite");
            }
        }catch (Exception ex){

        }

            try {
                pst=con.prepareStatement("update student set credite=? where id=?");
                pst.setInt(1,cr+credite);
                pst.setInt(2,id);
                pst.executeUpdate();

            }catch (Exception ex){

            }
    }
    public static User loginUser(String email, String pass){
        User u=new User();
        PreparedStatement pst;
        ResultSet rs;
        Connection con= DBConnection.getConnection();
        try {
            pst=con.prepareStatement("select * from student");
            rs=pst.executeQuery();
            while(rs.next()){
                if(email.equals(rs.getString("email")) && pass.equals(rs.getString("parola"))){
                    u.setId(rs.getInt("id"));
                    u.setCredite(rs.getInt("credite"));
                    u.setEmail(email);
                    u.setNume(rs.getString("nume"));
                    u.setPrenume(rs.getString("prenume"));
                    u.setStatus(rs.getInt("status"));
                    u.setAn(rs.getInt("an"));
                }
            }
        }catch (Exception ex){

        }
        return u;
    }
}
