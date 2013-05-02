/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucr.strutswebapp.application.action;

import cr.ac.ucr.strutswebapp.business.PeliculaBusiness;
import cr.ac.ucr.strutswebapp.domain.Pelicula;
import java.util.LinkedList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.actions.DispatchAction;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;

/**
 *
 * @author Equipo
 */
public class VerPeliculasAction extends DispatchAction {

    /* forward name="success" path="" */
    private final static String SUCCESS = "success";

    private LinkedList<Pelicula> peliculas;
    private Pelicula pelicula;
    
    public ActionForward iniciar (ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
                
        pelicula = new Pelicula();
        //solo le vamos a poner algunos de los valores para no digitar tantas lineas
        pelicula.setCodPelicula(1000);
        pelicula.setTitulo("Jack el cazagigantes");
        pelicula.getGenero().setCodGenero(100);
        pelicula.getGenero().setNombreGenero("Infantil");
        request.setAttribute("pelicula", pelicula);
        
        PeliculaBusiness peliculaBus = new PeliculaBusiness();
        peliculas = peliculaBus.getPeliculas();
        
        request.setAttribute("peliculas", peliculas);
        
        return mapping.getInputForward();//redirige el flujo de ejecucion hacia el componente weeb jsp ver_peliculas.jsp
        
    }//VerPeliculasAction
    

}
