package modelo;

import java.awt.BorderLayout;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import org.primefaces.context.RequestContext;
import java.util.*;

@ManagedBean
@SessionScoped
public class LibroBean implements Serializable {

    Connection connect = null;

    public void conectar() throws ClassNotFoundException {

        String url = "jdbc:mysql://localhost:3306/libros";

        String username = "root";
        String password = "0711";

        try {

            Class.forName("com.mysql.jdbc.Driver");

            connect = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established" + connect);

        } catch (SQLException ex) {
            System.out.println("in exec");
            System.out.println(ex.getMessage());
        }
    }

    private int calificacion;
    private int idLibroCalificacion;

    public int getIdLibroCalificacion() {
        return idLibroCalificacion;
    }

    public void setIdLibroCalificacion(int idLibroCalificacion) {
        this.idLibroCalificacion = idLibroCalificacion;
    }

    public int getCalificacion1() {
        return calificacion1;
    }

    public void setCalificacion1(int calificacion1) {
        this.calificacion1 = calificacion1;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    private static final long serialVersionUID = 6081417964063918994L;

    public List<Libro> getLibros() throws ClassNotFoundException, SQLException {

        conectar();

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
    public int calificacion1;

    public void calificar(int id) {

        idLibroCalificacion = id;

        System.out.println("este es:  " + idLibroCalificacion);

        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('myDialogVar').show();");
    }

    public void guardar() throws SQLException, ClassNotFoundException {
        conectar();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
        
        PreparedStatement pstmt = connect.prepareStatement("insert into calificacion(fecha, calificacion, usuario, libro_idLibro) value ('"+dtf.format(now)+"',"+calificacion+", 'anibal', "+idLibroCalificacion+")");
        int rs = pstmt.executeUpdate();
        
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('myDialogVar').hide();");

    }
    
    public List<Calificacion> getCalificaciones() throws ClassNotFoundException, SQLException{
        
        conectar();
        
        System.out.println("Esta variable: "+ idLibroCalificacion);
        

        List<Calificacion> calificaciones = new ArrayList<>();
        PreparedStatement pstmt = connect.prepareStatement("select idCalificacion, fecha, calificacion, usuario, libro_idLibro from calificacion where libro_idLibro="+idLibroCalificacion);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {

            Calificacion calificacion = new Calificacion();
            calificacion.setIdCalificacion(rs.getInt("idCalificacion"));
            calificacion.setFecha(rs.getString("fecha"));
            calificacion.setCalificacion(rs.getInt("calificacion"));
            calificacion.setUsuario(rs.getString("usuario"));
            calificacion.setIdLibro(rs.getInt("libro_idLibro"));

            calificaciones.add(calificacion);

        }

        // close resources
        rs.close();
        pstmt.close();
        connect.close();

        return calificaciones;
        
    }
    
    public void listarCalificaciones(int id){
        
        idLibroCalificacion = id;
        
        System.out.println("OKEY: "+idLibroCalificacion);
        
        RequestContext.getCurrentInstance().update("listadoCalificaciones");
        
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('listadoCalificaciones').show();");
    }

}
