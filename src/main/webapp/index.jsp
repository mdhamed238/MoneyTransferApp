<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <title>Login Page</title>
    <%@ include file="partials/head.jsp" %>
</head>

<body>
<div class="container my-5 w-50">
    <h2 class="text-center">Login</h2>
    <% String errorMessage=(String) request.getAttribute("errorMessage"); if (errorMessage !=null) { %>
    <div class="alert alert-danger w-75 my-3 mx-auto">
        <%= errorMessage %>
    </div>
    <% } %>
    <form action="login" method="post" class="form-group w-75 mx-auto">
        <div class="form-group">
            <label for="username">Login</label>
            <input type="text" name="username" id="username" class="form-control" required>
        </div>
        <div class="form-group">
            <label for="password">Mot de passe</label>
            <input type="password" name="password" id="password" class="form-control" required>
        </div>
        <button type="submit" class="btn btn-primary btn-block">Login</button>
    </form>
</div>

<%@ include file="partials/footer.jsp" %>

</body>

</html>
