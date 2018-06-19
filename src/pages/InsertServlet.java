package pages;

import function.LogFunction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

import static function.DatabaseFunction.*;
import static function.DatabaseFunction.closeConn;

import static function.DatabaseFunction.getConnection;

@WebServlet("/insert")
public class InsertServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        LogFunction logger = new LogFunction();
        String archeology = request.getParameter("archeology");
        String tip = request.getParameter("tip");
        String secol = request.getParameter("secol");
        String denumire = request.getParameter("denumire");
        String descriere = request.getParameter("descriere");

        Connection conn1 = null;

        int ok=0;

        try {
            conn1 = getConnection("artifacty");

            insertArtefact(archeology,tip,secol,denumire,descriere, conn1);


        }catch (Exception e) {
            e.printStackTrace();
        }
        closeConn(conn1);

    }
}

