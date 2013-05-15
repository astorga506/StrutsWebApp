/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucr.strutswebapp.application.form;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author Alvaro Mena
 */
public class GeneroForm extends ActionForm{
    private int codGenero;
    private String nombreGenero;

    public GeneroForm() {
    }

    public int getCodGenero() {
        return codGenero;
    }

    public void setCodGenero(int codGenero) {
        this.codGenero = codGenero;
    }

    public String getNombreGenero() {
        return nombreGenero;
    }

    public void setNombreGenero(String nombreGenero) {
        this.nombreGenero = nombreGenero;
    }

    @Override
    public ActionErrors validate(ActionMapping mapping, 
    HttpServletRequest request) {
        ActionErrors errores = new ActionErrors();
        if (nombreGenero==null || nombreGenero.equals("")){
            errores.add("errores", 
                    new ActionMessage("error.nombre.genero.vacio"));
        }
        return errores;
    }//validate
    
    
}
