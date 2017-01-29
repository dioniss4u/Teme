package Apis;

import Controllers.ProfesorController;
import Controllers.UserController;
import Entities.Profesor;
import Entities.User;
import com.google.gson.Gson;

import java.io.IOException;



/**
 * Created by dioni on 1/26/2017.
 */
public class LoginServlet extends javax.servlet.http.HttpServlet{
    private static final String NEWPROFESOR = "/login/profesor/new";
    private static final String NEWSTUDENT = "/login/student/new";
    private static final String STUDENT = "/login/student";
    private static final String PROFESOR = "/login/profesor";


    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        processRequest(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        processRequest(request,response);
        System.out.println(request.getServletPath());

    }

    private void processRequest(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)  throws javax.servlet.ServletException, IOException {
        String path = request.getServletPath();
        System.out.println(path);
        if (path.equals(NEWPROFESOR)) {

            String nume=request.getParameter("nume");
            String prenume=request.getParameter("prenume");
            String email=request.getParameter("email");
            String pass=request.getParameter("pass");
            String materie=request.getParameter("materie");
            String specializari=request.getParameter("specializari");
            ProfesorController.AddNew(nume,prenume,email,pass,materie,specializari);

        }
        if (path.equals(NEWSTUDENT)) {

            String nume=request.getParameter("nume");
            String prenume=request.getParameter("prenume");
            String email=request.getParameter("email");
            String pass=request.getParameter("pass");
            String an_sc=request.getParameter("an");
            UserController.AddNew(nume,prenume,email,pass,Integer.parseInt(an_sc));


        }
        if (path.equals(STUDENT)) {
            User u=UserController.loginUser(request.getParameter("email"),request.getParameter("pass"));
            String json = new Gson().toJson(u);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);

        }
        if (path.equals(PROFESOR)) {
            Profesor p=ProfesorController.loginUser(request.getParameter("email"),request.getParameter("pass"));
            String json = new Gson().toJson(p);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        }

    }
    }
