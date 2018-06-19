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
        String localizare = request.getParameter("localiz");
        String tip1=request.getParameter("tip1");
        String rol=request.getParameter("rol");
        String tip = request.getParameter("tip");
        String secol = request.getParameter("secol");
        String denumire = request.getParameter("denumire");
        String descriere = request.getParameter("descriere");
        String valoare= request.getParameter("valoare");
        String longitudine=request.getParameter("longitudine");
        String latitudine= request.getParameter("latitudine");
        String link=request.getParameter("link");
        Connection conn1 = null;

        int ok=0;

        try {
            conn1 = getConnection("artifacty");

            insertArtefact(localizare,tip1,rol,tip,secol,valoare,denumire,descriere,link, conn1);


        }catch (Exception e) {
            e.printStackTrace();
        }
        closeConn(conn1);

    }
}

