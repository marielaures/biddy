<%-- 
    Document   : detailenchere
    Created on : Nov 4, 2016, 9:23:45 PM
    Author     : ml
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1>Meilleure enchère</h1>

    <table border = "1">
        <thead>
        <th>Catégorie</th>    
        <th>Nom</th>
        <th>Description</th>
        <th>Condition</th>
        <th>Date de début</th>
        <th>Durée</th>
        <th>Montant initial</th>
        <th>Montant de la meilleure enchère</th>
        <th>Enchérir</th>
    </thead>
    <tbody>
            <tr>
                <td>${bestBid.auction.product.category.name}</td>
                <td>${bestBid.auction.product.name}</td>
                <td>${bestBid.auction.product.description}</td>
                <td>${bestBid.auction.product.condition}</td>
            
                <td>
                    <fmt:formatDate type="date" value="${bestBid.auction.startDate}" />
                </td>
                    
                <td>${bestBid.auction.duration}</td>
                <td>
                    <fmt:formatNumber value="${bestBid.auction.initialAmount}" maxFractionDigits="2" minFractionDigits="2" />
                </td>
                <td>
                    <fmt:formatNumber value="${bestBid.amount}" maxFractionDigits="2" minFractionDigits="2" />
                </td>
                <td>
                    <c:url var="url" value="FrontControleur?category=${category}&section=encheres&action=new&auctionID=${bestBid.auction.id}" />
                    <a href="${url}">Enchérir</a>
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
    </tbody>
</table>
