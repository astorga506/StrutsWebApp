/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucr.strutswebapp.application.form;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author Equipo
 */
public class PeliculaForm extends org.apache.struts.action.ActionForm {
    
    private int codPelicula;
    private String titulo;
    private int totalPeliculas;
    private boolean subtitulada, estreno;    
    private int codGenero;
    
    
    public PeliculaForm() {
        
    }

    public int getCodPelicula() {
        return codPelicula;
    }

    public void setCodPelicula(int codPelicula) {
        this.codPelicula = codPelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getTotalPeliculas() {
        return totalPeliculas;
    }

    public void setTotalPeliculas(int totalPeliculas) {
        this.totalPeliculas = totalPeliculas;
    }

    public boolean isSubtitulada() {
        return subtitulada;
    }

    public void setSubtitulada(boolean subtitulada) {
        this.subtitulada = subtitulada;
    }

    public boolean isEstreno() {
        return estreno;
    }

    public void setEstreno(boolean estreno) {
        this.estreno = estreno;
    }

    public int getCodGenero() {
        return codGenero;
    }

    public void setCodGenero(int codGenero) {
        this.codGenero = codGenero;
    }

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     * @return
     */
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        
        ActionErrors errors = new ActionErrors();
        
        if(this.titulo  == null || this.titulo == ""){
            
            errors.add("Errores", new ActionMessage("error.titulo.no.ingresado"));
            
        }
        
        if(this.totalPeliculas <= 0){            
            
            errors.add("Errores", new ActionMessage("error.total.peliculas"));
            
        }
        
        return errors;
    }
}
