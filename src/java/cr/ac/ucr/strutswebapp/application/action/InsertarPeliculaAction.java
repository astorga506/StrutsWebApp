/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucr.strutswebapp.application.action;

import cr.ac.ucr.strutswebapp.application.form.PeliculaForm;
import cr.ac.ucr.strutswebapp.business.GeneroBusiness;
import cr.ac.ucr.strutswebapp.business.PeliculaBusiness;
import cr.ac.ucr.strutswebapp.domain.Genero;
import cr.ac.ucr.strutswebapp.domain.Pelicula;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionErrors;

import org.apache.struts.actions.DispatchAction;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author Equipo
 */
public class InsertarPeliculaAction extends DispatchAction {

    private final static String SUCCESS = "success";
    private LinkedList<Genero> generos;

    public ActionForward iniciar(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        GeneroBusiness generoBusiness = new GeneroBusiness();
        generos = generoBusiness.getGeneros();
        request.setAttribute("generos", this.generos);


        return mapping.getInputForward();//Redirige el flujo de ejecucion hacia insertar_pelicula.jsp
    }

    public ActionForward insertar(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws IllegalAccessException, InvocationTargetException {

        PeliculaForm peliculaForm = (PeliculaForm) form;

        ActionErrors errors = peliculaForm.validate(mapping, request);

        if (errors.isEmpty()) {//el usuario llenó correctamente el formulario
            
            Pelicula pelicula = new Pelicula();
            BeanUtils.copyProperties(pelicula, peliculaForm);
            pelicula.getGenero().setCodGenero(peliculaForm.getCodGenero());
            PeliculaBusiness peliculaBus = new PeliculaBusiness();
            boolean insertado = true;
            
            try {
                
                peliculaBus.insertar(pelicula);
                insertado = true;
                
            } catch (SQLException ex) {
                
                insertado = false;
            }//catch
            
            if(insertado){
                
                request.setAttribute("titulo", "titulo.insertar.pelicula");
                request.setAttribute("mensaje", "mensaje.pelicula.insertada");
                return mapping.findForward(SUCCESS);
                                
            }else{//no se inserto porque fallo el intento de insercion
                
                errors.add("errores", new ActionMessage("error.bd.pelicula.no.insertada"));
                this.saveErrors(request, errors);
                request.setAttribute("generos", this.generos);
                return mapping.getInputForward();
                
            }//else - insertado
            
        } else {//hay errores

            request.setAttribute("generos", this.generos);
            this.saveErrors(request, errors);
            return mapping.getInputForward();

        }//else - hay errores


    }
}