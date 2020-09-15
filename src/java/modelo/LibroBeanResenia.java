/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author USUARIO
 */
@ManagedBean
@RequestScoped
public class LibroBeanResenia {

    public void getResenia(String idLibro, String lector, String mensaje) throws ClassNotFoundException, SQLException {

      
        
        

    }

    public List<Libro> getLibros() throws ClassNotFoundException, SQLException {

        Connection connect = null;

        String url = "jdbc:mysql://localhost:3306/libros";

        String username = "root";
        String password = "12345";

        try {

            Class.forName("com.mysql.jdbc.Driver");

            connect = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established" + connect);

        } catch (SQLException ex) {
            System.out.println("in exec");
            System.out.println(ex.getMessage());
        }

        List<Libro> libros = new ArrayList<>();
        PreparedStatement pstmt = connect.prepareStatement("select idLibro, nombre, autor, estado, observaciones from libros");
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {

            Libro libro = new Libro();
            libro.setIdLibro(rs.getInt("idLibro"));
            libro.setNombre(rs.getString("nombre"));
            libro.setAutor(rs.getString("autor"));
            libro.setEstado(rs.getString("estado"));
            libro.setObservaciones(rs.getString("observaciones"));

            libros.add(libro);

        }

        // close resources
        rs.close();
        pstmt.close();
        connect.close();

        return libros;

    }
    
    

}
