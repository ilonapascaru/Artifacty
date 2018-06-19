package pages;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static function.DatabaseFunction.getConnection;


@WebServlet("/artefact")
public class ArtefactServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            response.setContentType("text/html");
            String denumire = (String)  request.getParameter("getVal");
            PrintWriter out = response.getWriter();

            if(denumire!=null){
                request.setAttribute("denumire", denumire);
                request.getRequestDispatcher("Vizualizare.jsp").forward(request,response);
            }

            String docType =
                    "<!DOCTYPE HTML PUBLIC >\n";
            out.println(docType +
                    "<HTML>\n" +
                    "<HEAD><TITLE>" +
                    "</TITLE></HEAD>\n" +
                    "<BODY BGCOLOR=\"#FDF5E6\">\n" +

                    "</BODY></HTML>");
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}

