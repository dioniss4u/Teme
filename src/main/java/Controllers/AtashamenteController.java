package Controllers;

import Entities.Atashamente;
import Utils.AbstractController;
import Utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by dioni on 1/26/2017.
 */
public class AtashamenteController extends AbstractController {
    public static void AddNew(int tip, String path,int id_tema){
        PreparedStatement pst;
        ResultSet rs;
        Connection con= DBConnection.getConnection();
        try {
            pst=con.prepareStatement("insert into atasari(tip,path,id_tema) values(?,?,?)");
            pst.setInt(1,tip);
            pst.setString(2,path);
            pst.setInt(3,id_tema);
            pst.executeUpdate();
        }catch (Exception ex){

        }
    }
    public static ArrayList<Atashamente> getAll(){
        PreparedStatement pst;
        ResultSet rs;
        Connection con= DBConnection.getConnection();
        ArrayList<Atashamente> files=new ArrayList<Atashamente>();
        try {
            pst=con.prepareStatement("select * from atasari");
            rs=pst.executeQuery();
            while(rs.next()){
                Atashamente a=new Atashamente();
                a.setId(rs.getInt("id"));
                a.setId_tema(rs.getInt("id_tema"));
                a.setPath(rs.getString("path"));
                a.setTip(rs.getInt("tip"));
                files.add(a);

            }
        }catch (Exception ex){

        }
        return files;
    }
    public static ArrayList<Atashamente> getAllByTema(int id_tema){
        PreparedStatement pst;
        ResultSet rs;
        Connection con= DBConnection.getConnection();
        ArrayList<Atashamente> files=new ArrayList<Atashamente>();
        try {
            pst=con.prepareStatement("select * from atasari where id_tema=?");
            pst.setInt(1,id_tema);
            rs=pst.executeQuery();
            while(rs.next()){
                Atashamente a=new Atashamente();
                a.setId(rs.getInt("id"));
                a.setId_tema(id_tema);
                a.setPath(rs.getString("path"));
                a.setTip(rs.getInt("tip"));
                files.add(a);

            }
        }catch (Exception ex){

        }
        return files;
    }
    public static ArrayList<Atashamente> getAllByTipe(int tip){
        PreparedStatement pst;
        ResultSet rs;
        Connection con= DBConnection.getConnection();
        ArrayList<Atashamente> files=new ArrayList<Atashamente>();
        try {
            pst=con.prepareStatement("select * from atasari where tip=?");
            pst.setInt(1,tip);
            rs=pst.executeQuery();
            while(rs.next()){
                Atashamente a=new Atashamente();
                a.setId(rs.getInt("id"));
                a.setId_tema(rs.getInt("id_tema"));
                a.setPath(rs.getString("path"));
                a.setTip(tip);
                files.add(a);

            }
        }catch (Exception ex){

        }
        return files;
    }

}
