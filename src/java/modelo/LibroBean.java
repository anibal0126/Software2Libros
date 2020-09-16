package modelo;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author German Gonzales
 * @author Alexis Castrillo
 * @author Darwin Bonilla
 * @author Camilo Ortiz
 * @autor Anibal Muñoz Clase que permite hacer la reseña a un libro Clase que
 * permite el manejo de las funciones de los lbros
 */
@ManagedBean
@SessionScoped
public class LibroBean implements Serializable {

    Connection connect = null;
    private String reseniaMensaje;
    private String filtroNombre;
    private String filtroAutor;
    private String filtroIdLibro;

    /**
     * M e permite conectar a con la base de datos
     *
     * @throws ClassNotFoundException
     */
    public void conectar() throws ClassNotFoundException {

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
    }

    private int calificacion;
    private int idLibroCalificacion;

    /**
     * Me permite obtener el id de libro de calificacion
     *
     * @return id libro calificacion
     */
    public int getIdLibroCalificacion() {
        return idLibroCalificacion;
    }

    /**
     * Me permite asignar el id libro calificacion
     *
     * @param idLibroCalificacion
     */
    public void setIdLibroCalificacion(int idLibroCalificacion) {
        this.idLibroCalificacion = idLibroCalificacion;
    }

    /**
     * Me permite obtener la calificacion
     *
     * @return calificacion
     */
    public int getCalificacion1() {
        return calificacion1;
    }

    /**
     * Me permite asignar la calificacion
     *
     * @param calificacion1 calificacion
     */
    public void setCalificacion1(int calificacion1) {
        this.calificacion1 = calificacion1;
    }

    /**
     * Me permite obtener la calificacion
     *
     * @return calificacion
     */
    public int getCalificacion() {
        return calificacion;
    }

    /**
     * Me permite asignar la calificacion
     *
     * @param calificacion calificacion
     */
    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    /**
     * Me permite obtener la reseña
     *
     * @return reseña
     */
    public String getReseniaMensaje() {
        return reseniaMensaje;
    }

    /**
     * Me permite asignar la reseña
     *
     * @param reseniaMensaje
     */

    public void setReseniaMensaje(String reseniaMensaje) {
        this.reseniaMensaje = reseniaMensaje;
    }

    /**
     * Me permite obtener el filtro por nombre
     *
     * @return filtro por nombre
     */
    public String getFiltroNombre() {
        return filtroNombre;
    }

    /**
     * Me permite asigar el filtro por nombre
     *
     * @param filtroNombre filtro por nombre
     */
    public void setFiltroNombre(String filtroNombre) {
        this.filtroNombre = filtroNombre;
    }

    /**
     * Me permite obtener el filtro pro autor
     *
     * @return filtro por autor
     */
    public String getFiltroAutor() {
        return filtroAutor;
    }

    /**
     * Me permite asignar un filtro por autor
     *
     * @param filtroAutor filtro por autor
     */
    public void setFiltroAutor(String filtroAutor) {
        this.filtroAutor = filtroAutor;
    }

    /**
     * Me permite obtener por filtro de id libro
     *
     * @return filtro de id libro
     */
    public String getFiltroIdLibro() {
        return filtroIdLibro;
    }

    /**
     * Me permite asignar filro id del libro
     *
     * @param filtroIdLibro filtro id del libro
     */
    public void setFiltroIdLibro(String filtroIdLibro) {
        this.filtroIdLibro = filtroIdLibro;
    }

    private static final long serialVersionUID = 6081417964063918994L;

    /**
     * Me permite obtener todos los libro
     *
     * @return todos los libros
     * @throws ClassNotFoundException
     * @throws SQLException
     */

    public List<Libro> getLibros() throws ClassNotFoundException, SQLException {

        conectar();
        System.out.println("Entro a listar los libros");

        List<Libro> libros = new ArrayList<>();
        String consulta = "select idLibro, nombre, autor, estado, observaciones from libros";
        System.out.println("Filtro: " + filtroNombre);

        if (filtroNombre != null) {

            if (!filtroNombre.equalsIgnoreCase("")) {
                System.out.println("Entro filtroNombre: " + filtroNombre);
                consulta = "select idLibro, nombre, autor, estado, observaciones from libros WHERE nombre = '" + filtroNombre + "'";
            }
        }

        if (filtroAutor != null) {

            if (!filtroAutor.equalsIgnoreCase("")) {
                System.out.println("Entro filtroAutor: " + filtroAutor);
                consulta = "select idLibro, nombre, autor, estado, observaciones from libros WHERE autor = '" + filtroAutor + "'";
            }
        }

        if (filtroIdLibro != null) {

            if (!filtroIdLibro.equalsIgnoreCase("")) {
                System.out.println("Entro filtroIdLibro: " + filtroIdLibro);
                consulta = "select idLibro, nombre, autor, estado, observaciones from libros WHERE idLibro = " + filtroIdLibro;
            }
        }

        PreparedStatement pstmt = connect.prepareStatement(consulta);
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

        return libros;

    }
    public int calificacion1;

    /**
     * Me permite la calificacion de libros
     *
     * @param id id del libro
     */
    public void calificar(int id) {

        idLibroCalificacion = id;

        System.out.println("este es:  " + idLibroCalificacion);

        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('myDialogVar').show();");
    }

    /**
     * Me permite la rseña de un libro
     *
     * @param id id del libro
     */
    public void resenia(int id) {

        idLibroCalificacion = id;

        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('myResenia').show();");
    }

    /**
     * Me permtie guardar
     *
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void guardar() throws SQLException, ClassNotFoundException {
        conectar();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));

        PreparedStatement pstmt = connect.prepareStatement("insert into calificacion(fecha, calificacion, usuario, libro_idLibro) value ('" + dtf.format(now) + "'," + calificacion + ", 'anibal', " + idLibroCalificacion + ")");
        int rs = pstmt.executeUpdate();

        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('myDialogVar').hide();");

    }

    /**
     * Me permie guardar la reseña del libro
     *
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void guardarResenia() throws SQLException, ClassNotFoundException {
        conectar();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));

        PreparedStatement pstmt = connect.prepareStatement("insert into resenia(libros_idLibro, mensaje, fecha, lector) value (" + idLibroCalificacion + ",'" + reseniaMensaje + "', '" + dtf.format(now) + "','Anibal' )");
        int rs = pstmt.executeUpdate();

        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('myResenia').hide();");

    }

    /**
     * Me permite la v¿calificaciondes de un libro
     *
     * @return alificaciones de ibro
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public List<Calificacion> getCalificaciones() throws ClassNotFoundException, SQLException {

        conectar();

        System.out.println("Esta variable: " + idLibroCalificacion);

        List<Calificacion> calificaciones = new ArrayList<>();
        PreparedStatement pstmt = connect.prepareStatement("select idCalificacion, fecha, calificacion, usuario, libro_idLibro from calificacion where libro_idLibro=" + idLibroCalificacion);
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

    /**
     * Me permite las reseñas de libro
     *
     * @return reseñas de libro
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public List<Resenia> getResenias() throws ClassNotFoundException, SQLException {

        conectar();

        System.out.println("Esta variable: " + idLibroCalificacion);

        List<Resenia> resenias = new ArrayList<>();
        PreparedStatement pstmt = connect.prepareStatement("select libros_idLibro, mensaje, fecha, lector from resenia where libros_idLibro=" + idLibroCalificacion);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {

            Resenia resenia = new Resenia();
            resenia.setIdLibro(rs.getInt("libros_idLibro"));
            resenia.setMensaje(rs.getString("mensaje"));
            resenia.setFecha(rs.getString("fecha"));
            resenia.setLector(rs.getString("lector"));

            resenias.add(resenia);

        }

        // close resources
        rs.close();
        pstmt.close();
        connect.close();

        return resenias;

    }

    /**
     * Me permite listar las calificaciones
     *
     * @param id id de libro calificacion
     */
    public void listarCalificaciones(int id) {

        idLibroCalificacion = id;

        System.out.println("OKEY: " + idLibroCalificacion);

        RequestContext.getCurrentInstance().update("listadoCalificaciones");

        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('listadoCalificaciones').show();");
    }

    /**
     * Me permite listar las reselas de libro
     *
     * @param id id libro calificaicon
     */
    public void listarResenias(int id) {

        idLibroCalificacion = id;

        System.out.println("OKEY: " + idLibroCalificacion);

        RequestContext.getCurrentInstance().update("listadoResenias");

        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('listadoResenias').show();");
    }

    /**
     * Me permite limpiar filtros
     */
    public void limpiarFiltros() {

        filtroNombre = "";
        filtroAutor = "";
        filtroIdLibro = "";
    }
}
