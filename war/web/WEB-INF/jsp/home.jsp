<%-- 
    Document   : home
    Created on : Nov 2, 2016, 1:15:36 PM
    Author     : ml
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <link href="/encheres-war/css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <nav>
            <ul id="main-menu">
                <c:url var="url" value="FrontControleur?section=main-menu" />
                <c:import url="${url}" />
        </nav>
        <section>
            <p>Bienvenue sur les enchères en ligne</p>
        </section>
    </body>
</html>
