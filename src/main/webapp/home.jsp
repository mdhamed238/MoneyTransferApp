
<html>

<head>
    <title>Home Page</title>
    <%@ include file="partials/head.jsp" %>
</head>

<body>


<div class="container">
    <h1 class="my-3 text-center">
        Welcome back <%= request.getAttribute("username") %>
    </h1>
</div>


<%@ include file="partials/footer.jsp" %>

</body>

</html>