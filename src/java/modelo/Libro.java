/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

public class Libro {

	private Integer idLibro;
	private String nombre;
	private String autor;
	private String estado;
	private String observaciones;
        

	public Libro() {
	}

	public Libro(Integer idLibro, String nombre, String autor, String estado,
			String observaciones) {
		this.idLibro = idLibro;
		this.nombre = nombre;
		this.autor = autor;
		this.estado = estado;
		this.observaciones = observaciones;
	}

	public Integer getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(Integer idLibro) {
		this.idLibro = idLibro;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

}
