/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucr.strutswebapp.application.action;


import cr.ac.ucr.strutswebapp.business.GeneroBusiness;
import cr.ac.ucr.strutswebapp.domain.Genero;
import cr.ac.ucr.strutswebapp.exceptions.GeneroNoExistenteExeption;
import java.sql.SQLException;
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
public class EliminarGeneroAction extends DispatchAction {

    private Genero generoEliminar;
    private final int GENERO_NO_EXISTENTE = 10;
    private final int SQL_EXCEPTION = 11;
    private final int SQL_EXCEPTION_FOREING_KEY = 547;
    private final int GENERO_EXISTENTE = 12;
    private final int GENERO_ELIMINADO = 13;

    public ActionForward iniciar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        int codGenero = Integer.parseInt(request.getParameter("codGenero"));
        GeneroBusiness generoBusiness = new GeneroBusiness();
        int opcionEjecucion = GENERO_EXISTENTE;
        try {
            generoEliminar = generoBusiness.getGenero(codGenero);
        } catch (SQLException ex) {
            opcionEjecucion = SQL_EXCEPTION;
        } catch (GeneroNoExistenteExeption ex) {
            opcionEjecucion = GENERO_NO_EXISTENTE;
        }
        if (opcionEjecucion == GENERO_EXISTENTE) {
            request.setAttribute("generoEliminar", generoEliminar);
            return mapping.getInputForward();
        } else if (opcionEjecucion == GENERO_NO_EXISTENTE) {
            String tituloNoExito = "title.eliminar.genero";
            String mensajeNoExito = "error.genero.eliminar.noexiste";
            request.setAttribute("tituloNoExito", tituloNoExito);
            request.setAttribute("mensajeNoExito", mensajeNoExito);
            return mapping.findForward("noExito");
        } else {//opcionEjecucion==SQL_EXCEPTION
            String tituloNoExito = "title.eliminar.genero";
            String mensajeNoExito = "error.base.datos";
            request.setAttribute("tituloNoExito", tituloNoExito);
            request.setAttribute("mensajeNoExito", mensajeNoExito);
            return mapping.findForward("noExito");
        }
    }//iniciar

    public ActionForward eliminar(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        int opcionEjecucion = GENERO_ELIMINADO;
        GeneroBusiness generoBusiness = new GeneroBusiness();
        try {
            generoBusiness.eliminar(generoEliminar.getCodGenero());
        } catch (SQLException ex) {
            if (ex.getErrorCode() == SQL_EXCEPTION_FOREING_KEY)
                opcionEjecucion = SQL_EXCEPTION_FOREING_KEY;
            else opcionEjecucion = SQL_EXCEPTION;
            
        }//CATCH
        if (opcionEjecucion == GENERO_ELIMINADO) {
            String tituloExito = "title.eliminar.genero";
            String mensajeExito = "mensaje.genero.eliminado";
            request.setAttribute("tituloExito", tituloExito);
            request.setAttribute("mensajeExito", mensajeExito);
            return mapping.findForward("exito");
        } else {//error de conexion con la base de datos
            String mensajeNoExito;
            if (opcionEjecucion==SQL_EXCEPTION)
                     mensajeNoExito = "error.base.datos";
            else mensajeNoExito  = "error.genero.foreign.key";
            String tituloNoExito = "title.eliminar.genero";
            request.setAttribute("tituloNoExito", tituloNoExito);
            request.setAttribute("mensajeNoExito", mensajeNoExito);
            return mapping.findForward("noExito");
        }//else
    }//ELIMINAR
}
