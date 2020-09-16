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
 * @autor Anibal Muñoz Clase que permite hacer la reseña a un libro
 */
public class Resenia {
   
    private String lector;
    private String fecha;
    private String mensaje;
    private int idLibro;

    public Resenia() {
    }

    /**
     * Constructor que permite la creacion de una reseña
     *
     * @param lector lectro de la reseña
     * @param mensaje mensaje de la reseña
     * @param fecha fecha de la reseña
     * @param idLibro id del libro para la reseña
     */
    public Resenia(String lector, String mensaje, String fecha, int idLibro) {
        this.lector = lector;
        this.mensaje = mensaje;
        this.fecha = fecha;
        this.idLibro = idLibro;
    }

    /**
     * Me permite obtener el lector
     *
     * @return lector
     */
    public String getLector() {
        return lector;
    }

    /**
     * Me permite asignar el lector
     *
     * @param lector lector
     */
    public void setLector(String lector) {
        this.lector = lector;
    }

    /**
     * Me permite obtener EL MENSAJE
     *
     * @return mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * Me permite asignar el mensaje
     *
     * @param mensaje mensaje
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * Me permite obtener la fecha
     *
     * @return fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * me permie asignar la fecha
     *
     * @param fecha fecha
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
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
     * Me permite asignar id libro
     *
     * @param idLibro id libro
     */
    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

}
