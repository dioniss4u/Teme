package Controllers;

import Entities.Tema;
import Utils.AbstractController;
import Utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * Created by dioni on 1/26/2017.
 */
public class TemaController extends AbstractController{
    public static void temanoua(int id_elev,int valoare,String titlu,int urgent){
        PreparedStatement pst;
        ResultSet rs;
        Connection con= DBConnection.getConnection();
        try {
            pst=con.prepareStatement("insert into tema(id_elev,valoare,titlu,status,data,urgent) values(?,?,?,?,?,?)");
            pst.setInt(1,id_elev);
            pst.setInt(2,valoare);
            pst.setString(3,titlu);
            pst.setInt(4,0);
            pst.setInt(5,urgent);
            pst.setTimestamp(5,new Timestamp(System.currentTimeMillis()));

            pst.executeUpdate();

        }catch (Exception ex){

        }
    }
    public static void temaInLucru(int id, int id_prof){
        PreparedStatement pst;
        ResultSet rs;
        Connection con= DBConnection.getConnection();
        try {
            pst=con.prepareStatement("update tema set id_profesor=?,status=? where id=?");
            pst.setInt(1,id_prof);
            pst.setInt(2,1);
            pst.setInt(3,id);
            pst.executeUpdate();
        }catch (Exception ex){

        }
    }
    public static void rezolvaTema(int id){
        PreparedStatement pst;
        ResultSet rs;
        Connection con= DBConnection.getConnection();
        try {
            pst=con.prepareStatement("update tema set status=?,data_finalizare=? where id=?");
            pst.setInt(1,2);
            pst.setTimestamp(2,new Timestamp(System.currentTimeMillis()));
            pst.setInt(3,id);
        }catch (Exception ex){

        }
        int id_elev=0;
        int credite=0;
        try {
            pst=con.prepareStatement("select id_elev,valoare from tema where id=?");
            pst.setInt(1,id);
            rs=pst.executeQuery();
            while(rs.next()){
                id_elev=rs.getInt("id_elev");
                credite=rs.getInt("valoare");
            }
        }catch (Exception ex){

        }
        UserController.ScadeCredite(id_elev,credite);
    }
    public static void valideazaTema(int id){
        PreparedStatement pst;
        ResultSet rs;
        Connection con= DBConnection.getConnection();
        try {
            pst=con.prepareStatement("update tema set status=? where id=?");
            pst.setInt(1,3);

            pst.setInt(2,id);
        }catch (Exception ex){

        }
        int id_prof=0;
        int credite=0;
        try {
            pst=con.prepareStatement("select id_profesor,valoare from tema where id=?");
            pst.setInt(1,id);
            rs=pst.executeQuery();
            while(rs.next()){
                id_prof=rs.getInt("id_elev");
                credite=rs.getInt("valoare");
            }
        }catch (Exception ex){

        }
        ProfesorController.IncarcaCredite(id_prof,credite);



    }
    public static ArrayList<Tema> getAll(){
        PreparedStatement pst;
        ResultSet rs;
        Connection con= DBConnection.getConnection();
        ArrayList<Tema> teme=new ArrayList<Tema>();
        try {
            pst=con.prepareStatement("select * from tema");
            rs=pst.executeQuery();
            while(rs.next()){
                Tema t=new Tema();
                t.setId(rs.getInt("id"));
                t.setData(rs.getTimestamp("data"));
                t.setData_finalizare(rs.getTimestamp("data_finalizare"));
                t.setId_elev(rs.getInt("id_elev"));
                t.setId_profesor(rs.getInt("id_profesor"));
                t.setTitlu(rs.getString("titlu"));
                t.setStatus(rs.getInt("status"));
                t.setValoare(rs.getInt("valoare"));
                t.setUrgent(rs.getInt("urgent"));
                teme.add(t);
            }
        }catch (Exception ex){

        }
        return teme;
    }
    public static ArrayList<Tema> getAllbyElev(int id_elev){
        PreparedStatement pst;
        ResultSet rs;
        Connection con= DBConnection.getConnection();
        ArrayList<Tema> teme=new ArrayList<Tema>();
        try {
            pst=con.prepareStatement("select * from tema where id_elev=?");
            pst.setInt(1,id_elev);
            rs=pst.executeQuery();
            while(rs.next()){
                Tema t=new Tema();
                t.setId(rs.getInt("id"));
                t.setData(rs.getTimestamp("data"));
                t.setData_finalizare(rs.getTimestamp("data_finalizare"));
                t.setId_elev(rs.getInt("id_elev"));
                t.setId_profesor(rs.getInt("id_profesor"));
                t.setTitlu(rs.getString("titlu"));
                t.setStatus(rs.getInt("status"));
                t.setValoare(rs.getInt("valoare"));
                t.setUrgent(rs.getInt("urgent"));
                teme.add(t);
            }
        }catch (Exception ex){

        }
        return teme;
    }
    public static ArrayList<Tema> getAllByProf(int id_prof){
        PreparedStatement pst;
        ResultSet rs;
        Connection con= DBConnection.getConnection();
        ArrayList<Tema> teme=new ArrayList<Tema>();
        try {
            pst=con.prepareStatement("select * from tema where id_profesor=?");
            pst.setInt(1,id_prof);
            rs=pst.executeQuery();
            while(rs.next()){
                Tema t=new Tema();
                t.setId(rs.getInt("id"));
                t.setData(rs.getTimestamp("data"));
                t.setData_finalizare(rs.getTimestamp("data_finalizare"));
                t.setId_elev(rs.getInt("id_elev"));
                t.setId_profesor(rs.getInt("id_profesor"));
                t.setTitlu(rs.getString("titlu"));
                t.setStatus(rs.getInt("status"));
                t.setValoare(rs.getInt("valoare"));
                t.setUrgent(rs.getInt("urgent"));
                teme.add(t);
            }
        }catch (Exception ex){

        }
        return teme;
    }
    public static ArrayList<Tema> getAllByStatus(int status){
        PreparedStatement pst;
        ResultSet rs;
        Connection con= DBConnection.getConnection();
        ArrayList<Tema> teme=new ArrayList<Tema>();
        try {
            pst=con.prepareStatement("select * from tema where status=?");
            pst.setInt(1,status);
            rs=pst.executeQuery();
            while(rs.next()){
                Tema t=new Tema();
                t.setId(rs.getInt("id"));
                t.setData(rs.getTimestamp("data"));
                t.setData_finalizare(rs.getTimestamp("data_finalizare"));
                t.setId_elev(rs.getInt("id_elev"));
                t.setId_profesor(rs.getInt("id_profesor"));
                t.setTitlu(rs.getString("titlu"));
                t.setStatus(rs.getInt("status"));
                t.setValoare(rs.getInt("valoare"));
                t.setUrgent(rs.getInt("urgent"));
                teme.add(t);
            }
        }catch (Exception ex){

        }
        return teme;
    }
    public static Tema getById(int id){
        PreparedStatement pst;
        ResultSet rs;
        Connection con= DBConnection.getConnection();
        Tema t=new Tema();
        try {
            pst=con.prepareStatement("select * from tema where id=?");
            pst.setInt(1,id);
            rs=pst.executeQuery();
            while(rs.next()){

                t.setId(rs.getInt("id"));
                t.setData(rs.getTimestamp("data"));
                t.setData_finalizare(rs.getTimestamp("data_finalizare"));
                t.setId_elev(rs.getInt("id_elev"));
                t.setId_profesor(rs.getInt("id_profesor"));
                t.setTitlu(rs.getString("titlu"));
                t.setStatus(rs.getInt("status"));
                t.setValoare(rs.getInt("valoare"));
                t.setUrgent(rs.getInt("urgent"));

            }
        }catch (Exception ex){

        }
        return t;
    }
}
