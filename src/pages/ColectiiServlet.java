package pages;

import function.LogFunction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import static function.DatabaseFunction.*;
import static function.DatabaseFunction.closeConn;

import static function.DatabaseFunction.getConnection;

@WebServlet("/colectii")
public class ColectiiServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        String localizare=request.getParameter("localizare");
        String localiz=request.getParameter("localiz");
        String tip=request.getParameter("tip");
        String tip1=request.getParameter("tip1");
        String rol=request.getParameter("rol");
        String rol1=request.getParameter("rol1");


        if(localizare!=null){
            request.setAttribute("localizare", localiz);
            request.getRequestDispatcher("colectii2.jsp").forward(request,response);
        }

        if(tip!=null){
            request.setAttribute("tip", tip1);
            request.getRequestDispatcher("colectii2.jsp").forward(request,response);
        }

        if(rol!=null){
            request.setAttribute("rol", rol1);
            request.getRequestDispatcher("colectii2.jsp").forward(request,response);
        }


    }
}

