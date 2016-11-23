<%-- 
    Document   : ventesencours-catalogue
    Created on : Nov 2, 2016, 12:06:22 PM
    Author     : ml
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1>Enchères en cours</h1>
<c:if test="${empty auctions}">
    <p>Aucune enchère trouvée pour la catégorie <c:out value="${category}" /></p>
</c:if>
<c:if test="${not empty auctions}">
    <table border = "1">
        <thead>
        <th>Catégorie</th>    
        <th>Nom</th>
        <th>Description</th>
        <th>Condition</th>
        <th>Date de début</th>
        <th>Durée</th>
        <th>Montant initial</th>
        <th>Détails</th>
    </thead>
    <tbody>
        <c:forEach items="${auctions}" var="a">
            <tr>
                <td>${a.product.category.name}</td>
                <td>${a.product.name}</td>
                <td>${a.product.description}</td>
                <td>${a.product.condition}</td>
            
                <td>
                    <fmt:formatDate type="date" value="${a.startDate}" />
                </td>
                    
                <td>${a.duration}</td>
                <td>
                    <fmt:formatNumber value="${a.initialAmount}" maxFractionDigits="2" minFractionDigits="2" />
                </td>
                <td>
                    <c:url var="url" value="FrontControleur?section=detail-enchere&ref=${a.id}" />
                    <a href="${url}">
                </td>
                <%--
                <td>
                    <c:out value="${p.taxe.taux} %" />
                </td>
                <td>
                    <fmt:formatNumber value="${p.prixTTC}" maxFractionDigits="2" minFractionDigits="2" />
                </td>
                <td>
                    ${p.stock}
                </td>
                <td>
                    <c:url var="url" value="Controleur?origine=catalogue&section=operations-panier&action=ajouter&ref=${p.reference}" />
                    <a href="${url}">ajouter au panier</a>
                </td> --%>
            </tr>
        </c:forEach>
    </tbody>
</table>
</c:if>