<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="bean" uri="/WEB-INF/struts-bean.tld"%>
<%@taglib prefix="logic" uri="/WEB-INF/struts-logic.tld"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><bean:message key="titulo.ver.peliculas"/></title>
    </head>
    <body>
        <h1><bean:message key="titulo.ver.peliculas"/></h1>
        <bean:message key="label.titulo.pelicula"/> <bean:write name="pelicula" property="titulo"/> <br>
        <bean:message key="label.titulo.pelicula"/> ${pelicula.titulo} <%-- Expresion de lenguaje (EL)--%> <br>
        <bean:message key="label.nombre.genero"/> <bean:write name="pelicula" property="genero.nombreGenero"/><br>
        ${pelicula.genero.nombreGenero}     
        
        
        <%-- Uso de los foreach de taglib --%>
        <logic:iterate name="peliculas" id="peliculaActual">
            <bean:message key="label.titulo.pelicula"/> 
            <bean:write name="peliculaActual" property="titulo"/> <br>
            <bean:message key="label.nombre.genero"/> 
            <bean:write name="peliculaActual" property="genero.nombreGenero"/><br>
        </logic:iterate>
            
        <%-- Uso de los foreach de jstl --%>
        <c:forEach items="${peliculas}" var="peliculaTemp">
            
            <bean:message key="label.titulo.pelicula"/> ${peliculaTemp.titulo}
            
        </c:forEach>
        
    </body>
</html>
