package Apis;

import Controllers.AtashamenteController;
import Controllers.TemaController;
import Entities.Atashamente;
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
@WebServlet(name = "ServletFisiere")
public class ServletFisiere extends HttpServlet {
    private static final String NEW = "/files/new";
    private static final String GETALL = "/files/getall";
    private static final String BYTEMA = "/files/allbytema";
    private static final String BYTIP = "/files/allbytipe";


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
            AtashamenteController.AddNew(Integer.parseInt(request.getParameter("tip")), request.getParameter("path"), Integer.parseInt(request.getParameter("id_tema")));


        }
        if (path.equals(GETALL)) {
            ArrayList<Atashamente> files=AtashamenteController.getAll();
            String json = new Gson().toJson(files);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        }
        if (path.equals(BYTEMA)) {
            ArrayList<Atashamente> files=AtashamenteController.getAllByTema(Integer.parseInt(request.getParameter("id_tema")));
            String json = new Gson().toJson(files);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);

        }
        if (path.equals(BYTIP)) {
            ArrayList<Atashamente> files=AtashamenteController.getAllByTipe(Integer.parseInt(request.getParameter("tip")));
            String json = new Gson().toJson(files);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);


        }

    }
}
