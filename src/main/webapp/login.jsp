<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <title>Login Page</title>
    <%@ include file="partials/head.jsp" %>
</head>

<body>
<div class="container my-5">
    <h2 class="text-center">Login</h2>
    <% String errorMessage=(String) request.getAttribute("errorMessage"); if (errorMessage !=null) { %>
    <div class="alert alert-danger my-3">
        <%= errorMessage %>
    </div>
    <% } %>
    <form action="/login" method="post" class="form-group">
        <div class="form-group">
            <label for="username">Login:</label>
            <input type="text" name="username" id="username" class="form-control">
        </div>
        <div class="form-group">
            <label for="password">Mot de passe:</label>
            <input type="password" name="password" id="password" class="form-control">
        </div>
        <button type="submit" class="btn btn-primary">Login</button>
    </form>
</div>

<%@ include file="partials/footer.jsp" %>

</body>

</html>