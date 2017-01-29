package Apis;

import Controllers.ProfesorController;
import Controllers.UserController;
import Entities.Profesor;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by dioni on 1/26/2017.
 */
@WebServlet(name = "ServletProfesor")
public class ServletProfesor extends HttpServlet {
    private static final String UPDATE = "/profesor/update";
    private static final String SCADE="/profesor/scade";
    private static final String INCARCA="/profesor/incarca";
    private static final String GETP="/profesor/get";
    private static final String GETALL="/profesor/getall";
    private static final String GETBYMAT="/profesor/get-mat";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String path = request.getServletPath();
        System.out.println(path);
        if (path.equals(UPDATE)) {

            ProfesorController.updateUser(request.getParameter("nume"),request.getParameter("prenume"),request.getParameter("email"),request.getParameter("pass"),request.getParameter("materie"),request.getParameter("specializari"),Integer.parseInt(request.getParameter("id")));

        }
        if (path.equals(SCADE)) {

            ProfesorController.ScadeCredite(Integer.parseInt(request.getParameter("id")),Integer.parseInt(request.getParameter("credite")));
        }
        if (path.equals(INCARCA)) {

            ProfesorController.IncarcaCredite(Integer.parseInt(request.getParameter("id")),Integer.parseInt(request.getParameter("credite")));
        }
        if (path.equals(GETALL)) {
            ArrayList<Profesor> profi=ProfesorController.getAll();
            String json = new Gson().toJson(profi);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        }
        if (path.equals(GETP)) {
            Profesor p=ProfesorController.GetById(Integer.parseInt(request.getParameter("id")));
            String json = new Gson().toJson(p);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        }
        if (path.equals(GETBYMAT)) {
            ArrayList<Profesor> profi=ProfesorController.getAllByMaterie(request.getParameter("materie"));
            String json = new Gson().toJson(profi);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        }

    }
}

