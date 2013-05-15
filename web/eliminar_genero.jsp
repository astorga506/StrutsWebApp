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
        <title><bean:message key="title.eliminar.genero"/></title>
    </head>
    <body>
        <h1><bean:message key="title.eliminar.genero"/></h1>
        <form action="./eliminarGenero.do" method="get">
            <input type="hidden" name="metodo" value="eliminar"></input>
            <bean:message key="label.codigo.genero"/>${generoEliminar.codGenero}<br>
            <bean:message key="label.nombre.genero"/>${generoEliminar.nombreGenero}<br>
            <bean:message key="question.desea.eliminar.genero"/><br>
            <input type="submit" name="btnEliminar" 
                   value="<bean:message key="button.eliminar"/>">
        </form>
    </body>
</html>
