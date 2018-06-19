package function;

import java.sql.*;

public class DatabaseFunction {

    public static Connection getConnection(String baza_date) {
        try {
            Connection conn = null;
            Class.forName("com.mysql.jdbc.Driver");

            String userBD = "root";
            String passBD = "root";
            String urlBD = "jdbc:mysql://localhost:3306/artifacty";
            conn = DriverManager.getConnection(urlBD, userBD, passBD);

            return conn;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } catch (ClassNotFoundException nf) {
            nf.printStackTrace();
            return null;
        }
    }

    public static boolean verifyUser(String email, String parola, Connection conn) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT  username , password FROM USER where username=? and password=? ";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, parola);
            rs = stmt.executeQuery();
            return rs.next();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            closeRs(rs);
            closePs(stmt);
        }
    }




    public static void closeRs(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closePs(PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeConn(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("inchis");
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }


    public static void registerUser(String username, String password, String repeatPassword, String email, String interese, Connection conn){
        PreparedStatement stmt = null;
        PreparedStatement stmt2 = null;
        ResultSet rs = null;
        ResultSet rs2 = null;
        int userId;


        try {
            String sql2="SELECT COUNT(id_user) as ID FROM `artifacty`.`user`";
            stmt2 = conn.prepareStatement(sql2);
            rs2 = stmt2.executeQuery();
            rs2.next();
            userId = rs2.getInt("ID");

            String sql = "INSERT INTO `artifacty`.`user` (`id_user`, `username`, `password`, `email`, `grupuri_interes`, `tip_utilizator`) VALUES (?,?,?,?,?,?);";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, userId+1);
            stmt.setString(2, username);
            stmt.setString(3, password);
            stmt.setString(4, email);
            stmt.setString(5, interese);
            stmt.setString(6, "normal");
            stmt.executeUpdate();
            //return rs.next();

        } catch (Exception e) {
            e.printStackTrace();
            //return false;
        } finally {
            closeRs(rs);
            closePs(stmt);
        }


    }



    public static int verifyUsername(String username, Connection conn){

        PreparedStatement stmt = null;
        ResultSet rs = null;
        String user;
        try {
            String sql="SELECT username FROM USER";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()) {
                user = rs.getString("username");
                if (user.equals(username))
                    return 0;
            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            closeRs(rs);
            closePs(stmt);
        }


        return 1;


    }


    public static int verifyEmail(String email, Connection conn){

        PreparedStatement stmt = null;
        ResultSet rs = null;
        String Email;
        try {
            String sql="SELECT email FROM USER";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()) {
                Email = rs.getString("email");
                if (Email.equals(email))
                    return 0;
            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            closeRs(rs);
            closePs(stmt);
        }


        return 1;


    }

    public static void insertContact(String name, String email, String mesaj, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try{
            String sql = "INSERT INTO `artifacty`.`contacte` (`nume`,`email`,`mesaj`) " +
                    "VALUES (?,?,?);";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, mesaj);
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            //return false;
        } finally {
            closeRs(rs);
            closePs(stmt);
        }

    }

    public static void insertArtefact(String localizare,String tip1,String rol, String tip, String secol,
                                      String valoare,String denumire, String descriere,String link, Connection conn){
        PreparedStatement stmt = null;
        PreparedStatement stmt2 = null;
        PreparedStatement stmtTip = null;
        PreparedStatement stmtLoc = null;
        PreparedStatement stmtRol=null;


        ResultSet rs = null;
        ResultSet rs2 = null;
        ResultSet rs3=null;
        ResultSet rs4=null;
        ResultSet rs5=null;
        int artefactId;
        int tipId=0;
        int locId=0;
        int rolId=0;


        try {

            String sql2="SELECT COUNT(id_artefact) as ID FROM `artifacty`.`artefacte`";
            stmt2 = conn.prepareStatement(sql2);
            rs2 = stmt2.executeQuery();
            rs2.next();
            artefactId = rs2.getInt("ID");

            String sql3="SELECT id_tip as ID FROM `artifacty`.`tip` WHERE denumire=? ";
            stmtTip = conn.prepareStatement(sql3);
            stmtTip.setString(1, tip1);
            rs3 = stmtTip.executeQuery();

            while (rs3.next()) {
                tipId = rs3.getInt("ID");
            }

            String sql4="SELECT id_loc as ID FROM `artifacty`.`localizari` WHERE denumire=?";
            stmtLoc = conn.prepareStatement(sql4);
            stmtLoc.setString(1, localizare);
            rs4 = stmtLoc.executeQuery();
            while (rs4.next()) {
                locId = rs4.getInt("ID");
            }

            String sql5="SELECT id_rol as ID FROM `artifacty`.`roluri` WHERE denumire=?";
            stmtRol = conn.prepareStatement(sql5);
            stmtRol.setString(1, rol);
            rs5 = stmtRol.executeQuery();
            while (rs5.next()) {
                rolId = rs5.getInt("ID");
            }

            String sql = "INSERT INTO `artifacty`.`artefacte` (`id_artefact`, `id_user`, `denumire`, `id_tip`," +
                    " `id_rol`, `id_loc`, `valoare`, `licenta`, `termeni_cheie`,`descriere`,`autor`,`perioada_datata`,`link`) " +
                    "VALUES (?,1,?,?,?,?,?,'','',?,'',?,?);";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, artefactId+1);
            stmt.setString(2, denumire);
            //stmt.setString(3, denumire);
            stmt.setInt(3, tipId);
            stmt.setInt(4, rolId);
            stmt.setInt(5, locId);
            stmt.setString(6,valoare);
            stmt.setString(7, descriere);
            stmt.setString(8, secol);
            stmt.setString(9, link);
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            //return false;
        } finally {
            closeRs(rs);
            closePs(stmt);
        }


    }


}


