package pages;

import function.LogFunction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;

import static function.DatabaseFunction.closeConn;
import static function.DatabaseFunction.getConnection;
import static function.DatabaseFunction.verifyUser;

import function.LogFunction;
import mysql.DatabaseDetails;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


import static function.DatabaseFunction.*;

@WebServlet("/contact")
public class ContactServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        LogFunction logger = new LogFunction();
        String name = request.getParameter("name");
        String email = request.getParameter("emailid");
        String mesaj = request.getParameter("mesaj");


        Connection conn1 = null;


        try {
            conn1 = getConnection("artifacty");

            insertContact(name, email, mesaj, conn1);
            //(response).sendRedirect("/register.jsp");
        }catch (Exception e) {
            e.printStackTrace();
        }

        closeConn(conn1);

    }
}

