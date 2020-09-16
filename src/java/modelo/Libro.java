/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author German Gonzales
 * @author Alexis Castrillo
 * @author Darwin Bonilla
 * @author Camilo Ortiz
 * @autor Anibal Muñoz 
 * Clase que permite la creacion de libro
 */
public class Libro {

    private Integer idLibro;
    private String nombre;
    private String autor;
    private String estado;
    private String observaciones;

    public Libro() {
    }

    /**
     * Metodo contructor de la clase libro
     *
     * @param idLibro id del libro
     * @param nombre nombre del libro
     * @param autor autor del librp
     * @param estado estado del libro
     * @param observaciones observacones del libro
     */
    public Libro(Integer idLibro, String nombre, String autor, String estado,
            String observaciones) {
        this.idLibro = idLibro;
        this.nombre = nombre;
        this.autor = autor;
        this.estado = estado;
        this.observaciones = observaciones;
    }

    /**
     * Me perite obtener el id del libro
     *
     * @return id del libro
     */
    public Integer getIdLibro() {
        return idLibro;
    }

    /**
     * Me permite asignar id libro
     *
     * @param idLibro id libro
     */
    public void setIdLibro(Integer idLibro) {
        this.idLibro = idLibro;
    }

    /**
     * Me permite obtener el nombre del libro
     *
     * @return nombre del libro
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Me permite asignar el nombre del libro
     *
     * @param nombre nombre del libro
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Me permite obtener el nombre del autor
     *
     * @return nombre del autor
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Me permite asignar el autor
     *
     * @param autor autor del libro
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * Me permte obtener el estado del libro
     *
     * @return estado del libro
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Me permite asigar el estado del libro
     *
     * @param estado estado del libro
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Me permite obtener las observaciones del libro
     *
     * @return
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * Me permite asignar las observaciones del libro
     *
     * @param observaciones observaciones del libro
     */
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

}
