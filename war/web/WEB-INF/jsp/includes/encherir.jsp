<%-- 
    Document   : encherir
    Created on : Nov 4, 2016, 9:57:53 PM
    Author     : ml
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<form action="FrontControleur" method="GET" accept-charset="UTF-8" id="bid">
    <input type="hidden" name="section" value="TOUPDATE" />
    <label>Montant de la nouvelle enchère </label><input type="text" name="enchere" />
    <input type="submit" value="Valider" />
</form>
