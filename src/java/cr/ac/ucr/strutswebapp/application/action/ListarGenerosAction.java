/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucr.strutswebapp.application.action;

import cr.ac.ucr.strutswebapp.business.GeneroBusiness;
import cr.ac.ucr.strutswebapp.domain.Genero;
import java.util.LinkedList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

/**
 *
 * @author Alvaro Mena
 */
public class ListarGenerosAction extends DispatchAction{
    private LinkedList<Genero> generos;

    public ActionForward iniciar(ActionMapping mapping, ActionForm form, 
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        GeneroBusiness generoBusiness = new GeneroBusiness();
        generos = generoBusiness.getGeneros();
        request.setAttribute("generos", this.generos);
        return mapping.getInputForward();
    }
    
    
    
    
}
