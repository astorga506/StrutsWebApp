<%-- 
    Document   : insertar_pelicula
    Created on : 18/04/2013, 03:34:49 PM
    Author     : Equipo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="html" uri="/WEB-INF/struts-html.tld"%>
<%@taglib prefix="logic" uri="/WEB-INF/struts-logic.tld"%>
<%@taglib prefix="bean" uri="/WEB-INF/struts-bean.tld"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><bean:message key="titulo.insertar.pelicula"/></title>
    </head>
    <body>
        <h1><bean:message key="titulo.insertar.pelicula"/></h1>
        <ul type ="square">            
            <html:messages id="error">
                <li>${error}</li>                
            </html:messages>
        </ul>
        <html:form action="/insertarPelicula" method="get">
            <input type="hidden" name="metodo" value="insertar">
            <bean:message key="label.titulo.pelicula"/>
            <html:text property="titulo"/> <br>
            <bean:message key="label.genero"/>
            <html:select property="codGenero">                
                <logic:iterate name="generos" id="generoActual">                
                    <html:option value="${generoActual.codGenero}">
                        ${generoActual.nombreGenero}
                    </html:option>                    
                </logic:iterate>                
            </html:select><br>
            <bean:message key="label.total.peliculas"/>
            <html:text property="totalPeliculas"/><br>
            <html:checkbox property="subtitulada">                
                <bean:message key="label.subtitulada"/>
            </html:checkbox>
            <html:checkbox property="estreno">                
                <bean:message key="label.estreno"/>
            </html:checkbox><br>
            <input type="submit" value="<bean:message key="button.insertar"/>"
            </html:form>
    </body>
</html>
