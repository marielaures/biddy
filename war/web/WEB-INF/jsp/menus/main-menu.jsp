<%-- 

Document   : main-menu
    Created on : Nov 2, 2016, 11:35:44 AM
    Author     : ml
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<ul id="main-menu">
<li><a href="#">Inscription</a>       |</li>
<li><a href="#">Connexion</a>       |</li>
<li><a href="#">Mon Compte</a>       |</li>
</ul>

<form action="FrontControleur" method="GET" id="cat">
    <input name="section" value="encheres" type="hidden"/>
    <select name="category" id="dropdowncat">
        <option value="" disabled <c:if test="${empty category}">selected</c:if>>Choisir la catégorie</option>
        <c:forEach items="${categories}" var="c">
            <option value="${c.id}" <c:if test="${category == c.id}">selected</c:if>><c:out value="${c.name}"/></option>
        </c:forEach>
    </select>
    <input type="submit" value="Submit">
</form>