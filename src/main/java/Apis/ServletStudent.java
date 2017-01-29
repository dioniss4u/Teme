package Apis;

import Controllers.UserController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dioni on 1/26/2017.
 */
@WebServlet(name = "ServletStudent")
public class ServletStudent extends HttpServlet {
    private static final String UPDATE = "/user/update";
    private static final String INCARCA = "/user/buy";
    private static final String PLATESTE = "/user/pay";


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }
    private void processRequest(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)  throws javax.servlet.ServletException, IOException {
        String path = request.getServletPath();
        System.out.println(path);
        if (path.equals(UPDATE)) {

            UserController.updateUser(request.getParameter("nume"),request.getParameter("prenume"),request.getParameter("email"),request.getParameter("pass"),Integer.parseInt(request.getParameter("id")));
        }
        if(path.equals(INCARCA)){

            UserController.IncarcaCredite(Integer.parseInt(request.getParameter("id")),Integer.parseInt(request.getParameter("credite")));
        }
        if(path.equals(PLATESTE)){
            UserController.ScadeCredite(Integer.parseInt(request.getParameter("id")),Integer.parseInt(request.getParameter("credite")));
        }
        }




    }

