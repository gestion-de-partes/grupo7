/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partes;

import himevico.GestorBBDD;
import himevico.Incidencia;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import trabajadores.Logistica;

/**
 * Clase Parte
 *
 * @author
 */
public class Parte {

    private int idParte;
    private Date fecha;
    private double kilometrosInicio;
    private double kilometrosFin;
    private double gasoil;
    private double peajes;
    private double dietas;
    private double otros;
    private boolean eliminado;
    private boolean validado;
    private trabajadores.Logistica trabajador;
    private Incidencia incidencia = null;

    /**
     * Crear parte vacío
     */
    public Parte() {
    }

    /**
     * Constructor que genera un objeto tipo parte
     *
     * @param idParte
     * @param kilometrosInicio
     * @param kilometrosFin
     * @param gasoil
     * @param peajes
     * @param dietas
     * @param otros
     * @param eliminado
     * @param validado
     */
    public Parte(int idParte, double kilometrosInicio, double kilometrosFin, double gasoil, double peajes, double dietas, double otros, boolean eliminado, boolean validado) {
        this.idParte = idParte;
        this.kilometrosInicio = kilometrosInicio;
        this.kilometrosFin = kilometrosFin;
        this.gasoil = gasoil;
        this.peajes = peajes;
        this.dietas = dietas;
        this.otros = otros;
        this.eliminado = eliminado;
        this.validado = validado;
        //GestorBBDD.crearParte(this);
    }

    /**
     *
     * @param logistica
     * @throws SQLException
     */
    public Parte(Logistica logistica) throws SQLException {
        this.trabajador = logistica;
        GestorBBDD.crearParte(this);

    }

    /**
     * Obtener incidencia si existe para este idParte
     * @param idParte
     * @throws SQLException
     */
    public Parte(int idParte) throws SQLException {
        this.idParte = idParte;
        GestorBBDD.getParte(this);
        if (GestorBBDD.existeParteIncidencia(this)) {
            this.incidencia = GestorBBDD.getIncidencia(this);
        }

    }

    /**
     *
     * @param logistica
     * @return
     * @throws Exception
     */
    public Parte parteAbierto(Logistica logistica) throws Exception {
        this.trabajador = logistica;
        System.out.println("PARTE ABIERTO LOGISTICA?");
        System.out.println(this.trabajador.getIdTrabajador());
        if ((GestorBBDD.ultimoParteAbierto(this.trabajador.getIdTrabajador())) > 0) {
            System.out.println("Existe parte abierto");
            return new Parte(GestorBBDD.ultimoParteAbierto(this.trabajador.getIdTrabajador()));
        } else {
            System.out.println("Crear parte nuevo");
            new Parte(logistica);
            return new Parte(GestorBBDD.ultimoParteAbierto(this.trabajador.getIdTrabajador()));
        }
    }

    /**
     *
     * @throws Exception
     */
    public void cerrarParte() throws Exception {
        GestorBBDD.cerrarParte(this);
    }

    /**
     * @return the idParte
     */
    public int getIdParte() {
        return idParte;
    }

    /**
     * @param idParte the idParte to set
     */
    public void setIdParte(int idParte) {
        this.idParte = idParte;
    }

    /**
     * @return the kilometrosInicio
     */
    public double getKilometrosInicio() {
        return kilometrosInicio;
    }

    /**
     * @param kilometrosInicio the kilometrosInicio to set
     */
    public void setKilometrosInicio(double kilometrosInicio) {
        this.kilometrosInicio = kilometrosInicio;
    }

    /**
     * @return the kilometrosFin
     */
    public double getKilometrosFin() {
        return kilometrosFin;
    }

    /**
     * @param kilometrosFin the kilometrosFin to set
     */
    public void setKilometrosFin(double kilometrosFin) {
        this.kilometrosFin = kilometrosFin;
    }

    /**
     * @return the gasoil
     */
    public double getGasoil() {
        return gasoil;
    }

    /**
     * @param gasoil the gasoil to set
     */
    public void setGasoil(double gasoil) {
        this.gasoil = gasoil;
    }

    /**
     * @return the peajes
     */
    public double getPeajes() {
        return peajes;
    }

    /**
     * @param peajes the peajes to set
     */
    public void setPeajes(double peajes) {
        this.peajes = peajes;
    }

    /**
     * @return the dietas
     */
    public double getDietas() {
        return dietas;
    }

    /**
     * @param dietas the dietas to set
     */
    public void setDietas(double dietas) {
        this.dietas = dietas;
    }

    /**
     * @return the otros
     */
    public double getOtros() {
        return otros;
    }

    /**
     * @param otros the otros to set
     */
    public void setOtros(double otros) {
        this.otros = otros;
    }

    /**
     * @return the eliminado
     */
    public boolean isEliminado() {
        return eliminado;
    }

    /**
     * @param eliminado the eliminado to set
     */
    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    /**
     * @return the validado
     */
    public boolean isValidado() {
        return validado;
    }

    /**
     * @param validado the validado to set
     */
    public void setValidado(boolean validado) {
        this.validado = validado;
    }

    /**
     *
     * @return
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     *
     * @param fecha
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     *
     * @return
     */
    public Logistica getTrabajador() {
        return trabajador;
    }

    /**
     *
     * @param trabajador
     */
    public void setTrabajador(Logistica trabajador) {
        this.trabajador = trabajador;
    }

    /**
     *
     * @return
     */
    public Incidencia getIncidencia() {
        return incidencia;
    }

    /**
     *
     * @param incidencia
     */
    public void setIncidencia(Incidencia incidencia) {
        this.incidencia = incidencia;
    }

    @Override
    public String toString() {
        // Create an instance of SimpleDateFormat used for formatting 
        // the string representation of date (month/day/year)
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");

        Date day = fecha;

        String reportDate = df.format(day);

        return reportDate;
    }

}
