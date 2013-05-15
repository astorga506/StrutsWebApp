<%-- 
    Document   : editar_genero
    Created on : Apr 17, 2012, 11:01:38 AM
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
        <title><bean:message key="title.editar.genero"/></title>
    </head>
    <body>
        <h1><bean:message key="title.editar.genero"/></h1>
        <html:messages id="mensaje">
            <b>${mensaje}</b> 
        </html:messages> <br>
        <html:form action="/editarGenero" method="get">
            <input type="hidden" name="metodo" value="editar"></input>
            <bean:message key="label.codigo.genero"/> <html:text property="codGenero" disabled="true"/><br>
            <bean:message key="label.nombre.genero"/><html:text property="nombreGenero"/><br>
            <input type="submit" name="btnEditar" 
                   value="<bean:message key="button.editar"/>">
        </html:form>
    </body>
</html>
