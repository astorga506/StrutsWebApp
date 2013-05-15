/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucr.strutswebapp.application.action;


import cr.ac.ucr.strutswebapp.application.form.GeneroForm;
import cr.ac.ucr.strutswebapp.business.GeneroBusiness;
import cr.ac.ucr.strutswebapp.domain.Genero;
import cr.ac.ucr.strutswebapp.exceptions.GeneroNoExistenteExeption;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;

/**
 *
 * @author Alvaro Mena
 */
public class EditarGeneroAction extends DispatchAction {

    private Genero generoOriginal;
    private final int GENERO_NO_EXISTENTE = 10;
    private final int SQL_EXCEPTION = 11;
    private final int GENERO_EXISTENTE = 12;
    private final int GENERO_EDITADO = 13;

    public ActionForward iniciar(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        int codGenero = Integer.parseInt(request.getParameter("codGenero"));
        GeneroBusiness generoBusiness = new GeneroBusiness();
        int opcionEjecucion = GENERO_EXISTENTE;
        try {
            generoOriginal = generoBusiness.getGenero(codGenero);
        } catch (SQLException ex) {
            opcionEjecucion = SQL_EXCEPTION;
        } catch (GeneroNoExistenteExeption ex) {
            opcionEjecucion = GENERO_NO_EXISTENTE;
        }
        if (opcionEjecucion == GENERO_EXISTENTE) {
            // OJOOOOO se requiere poner la información del genero en
            // los componentes gráficos (cajas de texto, etc)
            GeneroForm generoForm = (GeneroForm) form;
            BeanUtils.copyProperties(generoForm, generoOriginal);
            return mapping.getInputForward();
        } else if (opcionEjecucion == GENERO_NO_EXISTENTE) {
            String tituloNoExito = "title.editar.genero";
            String mensajeNoExito = "error.genero.editar.noexiste";
            request.setAttribute("tituloNoExito", tituloNoExito);
            request.setAttribute("mensajeNoExito", mensajeNoExito);
            return mapping.findForward("noExito");
        } else {//opcionEjecucion==SQL_EXCEPTION
            String tituloNoExito = "title.editar.genero";
            String mensajeNoExito = "error.base.datos";
            request.setAttribute("tituloNoExito", tituloNoExito);
            request.setAttribute("mensajeNoExito", mensajeNoExito);
            return mapping.findForward("noExito");
        }
    }//iniciar

    public ActionForward editar(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        GeneroForm generoForm = (GeneroForm) form;
        ActionErrors errores = generoForm.validate(mapping, request);
        int opcionEjecucion = GENERO_EDITADO;
        if (errores.isEmpty()) {
            Genero generoModificar = new Genero();
            BeanUtils.copyProperties(generoModificar, generoForm);
            GeneroBusiness generoBusiness = new GeneroBusiness();
            try {
                generoBusiness.editar(generoModificar);
            } catch (SQLException ex) {
                opcionEjecucion = SQL_EXCEPTION;
            }//CATCH
            if (opcionEjecucion == GENERO_EDITADO) {
                String tituloNoExito = "title.editar.genero";
                String mensajeNoExito = "mensaje.genero.editado";
                request.setAttribute("titulo", tituloNoExito);
                request.setAttribute("mensaje", mensajeNoExito);
                return mapping.findForward("success");
            } else {//error de conexion con la base de datos
                String tituloNoExito = "title.editar.genero";
                String mensajeNoExito = "error.base.datos";
                request.setAttribute("tituloNoExito", tituloNoExito);
                request.setAttribute("mensajeNoExito", mensajeNoExito);
                return mapping.findForward("noExito");
            }//else
        } else {//el usuario no completo el formulario
            this.saveErrors(request, new ActionMessages(errores));
            return mapping.getInputForward();
        }
    }
}
