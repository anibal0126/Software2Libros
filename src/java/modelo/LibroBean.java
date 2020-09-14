package modelo;

import java.awt.BorderLayout;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean  
@RequestScoped
public class LibroBean implements Serializable {

	private static final long serialVersionUID = 6081417964063918994L;
        

	public List<Libro> getLibros() throws ClassNotFoundException, SQLException {
            
		Connection connect = null;

		String url = "jdbc:mysql://localhost:3306/libros";

		String username = "root";
		String password = "0711";

		try {

			Class.forName("com.mysql.jdbc.Driver");

			connect = DriverManager.getConnection(url, username, password);
			System.out.println("Connection established"+connect);

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
        public void calificar(int id){
            
            System.out.println("Este es el "+id);
               
        }

}