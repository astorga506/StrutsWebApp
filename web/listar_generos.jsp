<%-- 
    Document   : listar_generos
    Created on : Apr 17, 2012, 8:35:26 AM
    Author     : Alvaro Mena
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="bean" uri="/WEB-INF/struts-bean.tld" %>
<%@taglib prefix="logic" uri="/WEB-INF/struts-logic.tld" %>
<%@taglib prefix="html" uri="/WEB-INF/struts-html.tld" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><bean:message key="titulo.listado.generos"/></title>
    </head>
    <body>
        <h1><bean:message key="titulo.listado.generos"/></h1>
        <table border="1">
            <tr>
                <td><bean:message key="header.codigo.genero"/></td>
                <td><bean:message key="header.nombre.genero"/></td>
                <td colspan="2"><bean:message key="header.acciones"/></td>
            </tr>
            <logic:iterate id="generoActual" name="generos">
                <tr>
                    <td>${generoActual.codGenero}</td>
                    <td>${generoActual.nombreGenero}</td>
                    <td>
                        <html:link href="./editarGenero.do?metodo=iniciar&codGenero=${generoActual.codGenero}">
                            <bean:message key="accion.editar"/>
                        </html:link>
                    </td>
                    <td>
                         <html:link href="./eliminarGenero.do?metodo=iniciar&codGenero=${generoActual.codGenero}">
                            <bean:message key="accion.eliminar"/>
                        </html:link>
                    </td>
                </tr>
            </logic:iterate>

        </table>

    </body>
</html>
