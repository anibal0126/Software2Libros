/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;

/**
 *
 * @author German Gonzales
 * @author Alexis Castrillo
 * @author Darwin Bonilla
 * @author Camilo Ortiz
 * @autor Anibal Muñoz 
 * Clase que permite la  calificacion de los libros
 */
public class Calificacion {

    private int idCalificacion, calificacion, idLibro;
    private String fecha;
    private String usuario;

    /**
     * Me permite obtener lel id de la calificacion del libro
     *
     * @return id de la calificacion del libro
     */
    public int getIdCalificacion() {
        return idCalificacion;
    }

    /**
     * Me permite asiganar un id a la calificacion del libro
     *
     * @param idCalificacion id de la calificacion del libro
     */
    public void setIdCalificacion(int idCalificacion) {
        this.idCalificacion = idCalificacion;
    }

    /**
     * Me permite obtener la calificacion del libro
     *
     * @return calificacion del libro
     */
    public int getCalificacion() {
        return calificacion;
    }

    /**
     * Me permite asignar la calificacion del libro
     *
     * @param calificacion calificacion del libro
     */
    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    /**
     * Me permite obtener el id del libro
     *
     * @return id del libro
     */
    public int getIdLibro() {
        return idLibro;
    }

    /**
     * Me permite asignar el id del libro
     *
     * @param idLibro id del libro
     */
    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    /**
     * Me permite obtener el usuario
     *
     * @return usuario
     */

    public String getUsuario() {
        return usuario;
    }

    /**
     * Me permite asignar un usuario
     *
     * @param usuario usuario
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Me permite obtener la fecha de la caliicacion del libro
     *
     * @return decha de la calificacion del libro
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Me premite asignar una fecha de calificacion al libro
     *
     * @param fecha fecha de calificacion del libro
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

}
