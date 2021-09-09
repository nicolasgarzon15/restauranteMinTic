/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.modelo;

/**
 *
 * @author NicolasG
 */
public class Mesero {
    private int meseroId;
    private String nombreMesero;
    private String apellidoMesero;
    private int documentoMesero;
    private String correoMesero;
    private String telefonoMesero;
    private int cantidadPedidos;
    private float sumatoria;

    public Mesero(int meseroId, int documentoMesero, String nombreMesero, String apellidoMesero, String correoMesero, String telefonoMesero) {
        this.meseroId = meseroId;
        this.documentoMesero = documentoMesero;
        this.nombreMesero = nombreMesero;
        this.apellidoMesero = apellidoMesero;
        this.correoMesero = correoMesero;
        this.telefonoMesero = telefonoMesero;
    }

    public Mesero(String nombreMesero, String apellidoMesero, int documentoMesero, String telefonoMesero, int cantidadPedidos, float sumatoria) {
        this.nombreMesero = nombreMesero;
        this.apellidoMesero = apellidoMesero;
        this.documentoMesero = documentoMesero;
        this.telefonoMesero = telefonoMesero;
        this.cantidadPedidos = cantidadPedidos;
        this.sumatoria = sumatoria;
    }



    public int getMeseroId() {
        return meseroId;
    }

    public void setMeseroId(int meseroId) {
        this.meseroId = meseroId;
    }

    public int getDocumentoMesero() {
        return documentoMesero;
    }

    public void setDocumentoMesero(int documentoMesero) {
        this.documentoMesero = documentoMesero;
    }

    public String getNombreMesero() {
        return nombreMesero;
    }

    public void setNombreMesero(String nombreMesero) {
        this.nombreMesero = nombreMesero;
    }

    public String getApellidoMesero() {
        return apellidoMesero;
    }

    public void setApellidoMesero(String apellidoMesero) {
        this.apellidoMesero = apellidoMesero;
    }

    public String getCorreoMesero() {
        return correoMesero;
    }

    public void setCorreoMesero(String correoMesero) {
        this.correoMesero = correoMesero;
    }

    public String getTelefonoMesero() {
        return telefonoMesero;
    }

    public void setTelefonoMesero(String telefonoMesero) {
        this.telefonoMesero = telefonoMesero;
    }

    public int getCantidadPedidos() {
        return cantidadPedidos;
    }

    public void setCantidadPedidos(int cantidadPedidos) {
        this.cantidadPedidos = cantidadPedidos;
    }

    public float getSumatoria() {
        return sumatoria;
    }

    public void setSumatoria(float sumatoria) {
        this.sumatoria = sumatoria;
    }
    
    
    
}
