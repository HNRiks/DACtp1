<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<jsp:useBean id="lembrete" class="newpackage.lembrete"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lembretes</title>
    </head>
    <body>
        <%
           String username = (String) request.getAttribute("username");
           List lembretes = (List) session.getAttribute("lembretes");
        %>
        <c:forEach items="${lembretes}" var="lembrete">
         <%
             boolean readable = lembrete.getUsername() == username;
         %>
         <c:if test="${readable}">
         <td> Título: <c:out value="${lembrete.getTitle}"/></td>
         <td> Mensagem: <c:out value="${lembrete.getBody}"/></td>
         </c:if>
        </c:forEach>
    </body>
</html>
