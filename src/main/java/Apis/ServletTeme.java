package Apis;

import Controllers.ProfesorController;
import Controllers.TemaController;
import Entities.Tema;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by dioni on 1/29/2017.
 */
@WebServlet(name = "ServletTeme")
public class ServletTeme extends HttpServlet {
    private static final String NEW = "/tema/new";
    private static final String INLUCRU = "/tema/lucru";
    private static final String REZOLVA = "/tema/rezolva";
    private static final String VALIDEAZA = "/tema/valideaza";
    private static final String GETALL = "/tema/getall";
    private static final String GETBYELEV = "/tema/byelev";
    private static final String GETBYPROF = "/tema/byprof";
    private static final String GETBYSTATUS = "/tema/bystatus";
    private static final String GETBYID = "/tema/byid";


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String path = request.getServletPath();
        System.out.println(path);
        if (path.equals(NEW)) {
            TemaController.temanoua(Integer.parseInt(request.getParameter("id_elev")),Integer.parseInt(request.getParameter("valoare")),request.getParameter("titlu"),Integer.parseInt(request.getParameter("urgent")));


        }
        if (path.equals(INLUCRU)) {
            TemaController.temaInLucru(Integer.parseInt(request.getParameter("id")),Integer.parseInt("id_prof"));

        }
        if (path.equals(REZOLVA)) {
            TemaController.rezolvaTema(Integer.parseInt(request.getParameter("id")));

        }
        if (path.equals(VALIDEAZA)) {
            TemaController.valideazaTema(Integer.parseInt(request.getParameter("id")));

        }
        if (path.equals(GETALL)) {

           ArrayList<Tema> teme=TemaController.getAll();
            String json = new Gson().toJson(teme);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        }
        if (path.equals(GETBYELEV)) {

            ArrayList<Tema> teme=TemaController.getAllbyElev(Integer.parseInt(request.getParameter("id_elev")));
            String json = new Gson().toJson(teme);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);

        }
        if (path.equals(GETBYPROF)) {
            ArrayList<Tema> teme=TemaController.getAllByProf(Integer.parseInt(request.getParameter("id_profesor")));
            String json = new Gson().toJson(teme);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);

        }
        if (path.equals(GETBYID)) {
            Tema t=TemaController.getById(Integer.parseInt("id"));
            String json = new Gson().toJson(t);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);

        }
        if (path.equals(GETBYSTATUS)) {
            ArrayList<Tema> teme=TemaController.getAllByStatus(Integer.parseInt(request.getParameter("status")));
            String json = new Gson().toJson(teme);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);

        }

    }
}
